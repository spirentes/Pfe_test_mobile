package PageObjects.charging_stations;

import PageObjects.BasePage;
import com.google.zxing.*;
import com.google.zxing.NotFoundException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.cucumber.core.internal.com.fasterxml.jackson.databind.JsonNode;
import io.cucumber.core.internal.com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.*;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.Point;
import org.openqa.selenium.support.PageFactory;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;

public
class ScanChargingStations extends BasePage {
    private AndroidDriver driver;
    @AndroidFindBy(xpath = "//android.view.ViewGroup[1]/android.widget.TextView[@index='1']")
    WebElement pageTitle;


    public ScanChargingStations(AndroidDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public boolean isOnPage() {
        try {
            // Check for the presence of the navMenuIcon element
            return pageTitle.isDisplayed();
        } catch (NoSuchElementException e) {
            // The element is not present, so the page is not displayed
            return false;
        }
    }
    public BufferedImage createQRCodeImage(String qrCodeContent) throws WriterException {
        BitMatrix bitMatrix = new QRCodeWriter().encode(qrCodeContent, BarcodeFormat.QR_CODE, 200, 200);
        BufferedImage image = new BufferedImage(bitMatrix.getWidth(), bitMatrix.getHeight(), BufferedImage.TYPE_INT_RGB);
        for (int x = 0; x < bitMatrix.getWidth(); x++) {
            for (int y = 0; y < bitMatrix.getHeight(); y++) {
                image.setRGB(x, y, bitMatrix.get(x, y) ? Color.BLACK.getRGB() : Color.WHITE.getRGB());
            }
        }
        return image;
    }
    public String qrCodeContent(String filePath) throws IOException, NotFoundException, ChecksumException, FormatException, ParseException {
        File file = new File(filePath);
        if (file.exists()) {
            System.out.println("Absolute path of file: " + file.getAbsolutePath());
        } else {
            System.out.println("File does not exist");
        }

        BufferedImage image = ImageIO.read(new File(filePath));
        int imageWidth = image.getWidth();
        int imageHeight = image.getHeight();
        // System.out.println(imageWidth);
        // System.out.println(imageHeight);
        Map<DecodeHintType, Object> hints = new EnumMap<>(DecodeHintType.class);
        hints.put(DecodeHintType.TRY_HARDER, Boolean.TRUE);
        hints.put(DecodeHintType.POSSIBLE_FORMATS,
                  EnumSet.allOf(BarcodeFormat.class));
        hints.put(DecodeHintType.PURE_BARCODE, Boolean.FALSE);
        BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(new BufferedImageLuminanceSource(image)));
        MultiFormatReader reader = new MultiFormatReader();
        Result result = reader.decode(bitmap, hints);
        System.out.println("QR Code content: " + result.getText());

        byte[] decodedBytes = Base64.getDecoder().decode(result.getText());
        String decodedString = new String(decodedBytes);

        // parse the decoded string to a JSON object using the simple-json library
        JSONParser parser = new JSONParser();
        JSONObject jsonObj = (JSONObject) parser.parse(decodedString);

        String chargingStationID = (String) jsonObj.get("chargingStationID");
        long connectorID = (long) jsonObj.get("connectorID");
        String endpoint = (String) jsonObj.get("endpoint");
        String tenantName = (String) jsonObj.get("tenantName");
        String tenantSubDomain = (String) jsonObj.get("tenantSubDomain");

        System.out.println("Charging Station ID: " + chargingStationID);
        System.out.println("Connector ID: " + connectorID);
        System.out.println("Endpoint: " + endpoint);
        System.out.println("Tenant Name: " + tenantName);
        System.out.println("Tenant Subdomain: " + tenantSubDomain);
        return chargingStationID;

    }
    public void scanQRCode(String qrCodeContent) throws NotFoundException, ChecksumException, FormatException, WriterException {
        Map<DecodeHintType, Object> hints = new EnumMap<>(DecodeHintType.class);
        hints.put(DecodeHintType.TRY_HARDER, Boolean.TRUE);
        hints.put(DecodeHintType.POSSIBLE_FORMATS, EnumSet.allOf(BarcodeFormat.class));
        hints.put(DecodeHintType.PURE_BARCODE, Boolean.FALSE);

        MultiFormatReader reader = new MultiFormatReader();
        Result result = reader.decode(new BinaryBitmap(new HybridBinarizer(
                new BufferedImageLuminanceSource(createQRCodeImage(qrCodeContent)))), hints);
        System.out.println("QR Code content: " + result.getText());
    }
    private static final String API_URL = "https://beta.cpo.server.wattzhub.com/v1/api/charging-stations/";
    private static final ObjectMapper mapper = new ObjectMapper();
    public void getChargingStationById(String id) throws IOException {
//        String token ="eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6IjYzZWY3ZGQxMmE4OTUxNDZlOTJhNWM3MiIsInJvbGUiOiJBIiwicm9sZXNBQ0wiOlsiYWRtaW4iXSwibmFtZSI6IkFETUlOIiwibW9iaWxlIjoiIiwiZW1haWwiOiJzYWJyaS5tZWpyaUBpbnRlcm5zaGlwLmNvbnRpbnVvdXNuZXQuY29tIiwidGFnSURzIjpbIlMwMDciXSwiZmlyc3ROYW1lIjoiQWRtaW4iLCJsb2NhbGUiOiJlbl9VUyIsImxhbmd1YWdlIjoiZW4iLCJjdXJyZW5jeSI6IkVVUiIsInRlbmFudElEIjoiNjNlZjdkYmQyYTg5NTE0NmU5MmE1YzNkIiwidGVuYW50TmFtZSI6IkFkbWluIiwidGVuYW50U3ViZG9tYWluIjoidGVzdCIsInVzZXJIYXNoSUQiOiI4NmE4ODAxZTc2Y2ZhZmI5MjgzYzJjNTMzN2ZlNDVmYTVkY2JjMDQ2NjJjYzBkYTdiZDY4Y2ViNjBkOTg5MDczIiwidGVuYW50SGFzaElEIjoiYzJlZjQ5NWJjZGZhZTAxOTk5MjE0NzE0OGRlZDNhOWJhMDBjNmRlYjk4MzNjZTI2ZGFiM2M5ZjU0ZDc1MmQ1MyIsInNjb3BlcyI6WyJBc3NldDpDaGVja0Nvbm5lY3Rpb24iLCJBc3NldDpDcmVhdGUiLCJBc3NldDpDcmVhdGVDb25zdW1wdGlvbiIsIkFzc2V0OkRlbGV0ZSIsIkFzc2V0OkluRXJyb3IiLCJBc3NldDpMaXN0IiwiQXNzZXQ6UmVhZCIsIkFzc2V0OlJlYWRDb25zdW1wdGlvbiIsIkFzc2V0OlJldHJpZXZlQ29uc3VtcHRpb24iLCJBc3NldDpVcGRhdGUiLCJCaWxsaW5nOkNoZWNrQ29ubmVjdGlvbiIsIkJpbGxpbmc6Q2xlYXJCaWxsaW5nVGVzdERhdGEiLCJDYXI6Q3JlYXRlIiwiQ2FyOkRlbGV0ZSIsIkNhcjpMaXN0IiwiQ2FyOlJlYWQiLCJDYXI6VXBkYXRlIiwiQ2FyQ2F0YWxvZzpMaXN0IiwiQ2FyQ2F0YWxvZzpSZWFkIiwiQ2hhcmdpbmdQcm9maWxlOkxpc3QiLCJDaGFyZ2luZ1Byb2ZpbGU6UmVhZCIsIkNoYXJnaW5nU3RhdGlvbjpBdXRob3JpemUiLCJDaGFyZ2luZ1N0YXRpb246Q2hhbmdlQXZhaWxhYmlsaXR5IiwiQ2hhcmdpbmdTdGF0aW9uOkNoYW5nZUNvbmZpZ3VyYXRpb24iLCJDaGFyZ2luZ1N0YXRpb246Q2xlYXJDYWNoZSIsIkNoYXJnaW5nU3RhdGlvbjpDbGVhckNoYXJnaW5nUHJvZmlsZSIsIkNoYXJnaW5nU3RhdGlvbjpDcmVhdGUiLCJDaGFyZ2luZ1N0YXRpb246RGF0YVRyYW5zZmVyIiwiQ2hhcmdpbmdTdGF0aW9uOkRlbGV0ZSIsIkNoYXJnaW5nU3RhdGlvbjpFeHBvcnQiLCJDaGFyZ2luZ1N0YXRpb246R2V0Q29tcG9zaXRlU2NoZWR1bGUiLCJDaGFyZ2luZ1N0YXRpb246R2V0Q29uZmlndXJhdGlvbiIsIkNoYXJnaW5nU3RhdGlvbjpHZXREaWFnbm9zdGljcyIsIkNoYXJnaW5nU3RhdGlvbjpJbkVycm9yIiwiQ2hhcmdpbmdTdGF0aW9uOkxpc3QiLCJDaGFyZ2luZ1N0YXRpb246UmVhZCIsIkNoYXJnaW5nU3RhdGlvbjpSZW1vdGVTdGFydFRyYW5zYWN0aW9uIiwiQ2hhcmdpbmdTdGF0aW9uOlJlbW90ZVN0b3BUcmFuc2FjdGlvbiIsIkNoYXJnaW5nU3RhdGlvbjpSZXNldCIsIkNoYXJnaW5nU3RhdGlvbjpTZXRDaGFyZ2luZ1Byb2ZpbGUiLCJDaGFyZ2luZ1N0YXRpb246U3RhcnRUcmFuc2FjdGlvbiIsIkNoYXJnaW5nU3RhdGlvbjpTdG9wVHJhbnNhY3Rpb24iLCJDaGFyZ2luZ1N0YXRpb246VW5sb2NrQ29ubmVjdG9yIiwiQ2hhcmdpbmdTdGF0aW9uOlVwZGF0ZSIsIkNoYXJnaW5nU3RhdGlvbjpVcGRhdGVGaXJtd2FyZSIsIkNvbXBhbnk6Q3JlYXRlIiwiQ29tcGFueTpEZWxldGUiLCJDb21wYW55Okxpc3QiLCJDb21wYW55OlJlYWQiLCJDb21wYW55OlVwZGF0ZSIsIkNvbm5lY3Rpb246Q3JlYXRlIiwiQ29ubmVjdGlvbjpEZWxldGUiLCJDb25uZWN0aW9uOkxpc3QiLCJDb25uZWN0aW9uOlJlYWQiLCJJbnZvaWNlOkRvd25sb2FkIiwiSW52b2ljZTpMaXN0IiwiSW52b2ljZTpSZWFkIiwiTG9nZ2luZzpFeHBvcnQiLCJMb2dnaW5nOkxpc3QiLCJMb2dnaW5nOlJlYWQiLCJOb3RpZmljYXRpb246Q3JlYXRlIiwiT2NwaUVuZHBvaW50OkNyZWF0ZSIsIk9jcGlFbmRwb2ludDpEZWxldGUiLCJPY3BpRW5kcG9pbnQ6R2VuZXJhdGVMb2NhbFRva2VuIiwiT2NwaUVuZHBvaW50Okxpc3QiLCJPY3BpRW5kcG9pbnQ6UGluZyIsIk9jcGlFbmRwb2ludDpSZWFkIiwiT2NwaUVuZHBvaW50OlJlZ2lzdGVyIiwiT2NwaUVuZHBvaW50OlRyaWdnZXJKb2IiLCJPY3BpRW5kcG9pbnQ6VXBkYXRlIiwiT2ljcEVuZHBvaW50OkNyZWF0ZSIsIk9pY3BFbmRwb2ludDpEZWxldGUiLCJPaWNwRW5kcG9pbnQ6TGlzdCIsIk9pY3BFbmRwb2ludDpQaW5nIiwiT2ljcEVuZHBvaW50OlJlYWQiLCJPaWNwRW5kcG9pbnQ6UmVnaXN0ZXIiLCJPaWNwRW5kcG9pbnQ6VHJpZ2dlckpvYiIsIk9pY3BFbmRwb2ludDpVcGRhdGUiLCJQYXltZW50TWV0aG9kOkNyZWF0ZSIsIlBheW1lbnRNZXRob2Q6RGVsZXRlIiwiUGF5bWVudE1ldGhvZDpMaXN0IiwiUGF5bWVudE1ldGhvZDpSZWFkIiwiUHJpY2luZzpSZWFkIiwiUHJpY2luZzpVcGRhdGUiLCJQcmljaW5nRGVmaW5pdGlvbjpDcmVhdGUiLCJQcmljaW5nRGVmaW5pdGlvbjpEZWxldGUiLCJQcmljaW5nRGVmaW5pdGlvbjpMaXN0IiwiUHJpY2luZ0RlZmluaXRpb246UmVhZCIsIlByaWNpbmdEZWZpbml0aW9uOlVwZGF0ZSIsIlJlZ2lzdHJhdGlvblRva2VuOkNyZWF0ZSIsIlJlZ2lzdHJhdGlvblRva2VuOkRlbGV0ZSIsIlJlZ2lzdHJhdGlvblRva2VuOkxpc3QiLCJSZWdpc3RyYXRpb25Ub2tlbjpSZWFkIiwiUmVnaXN0cmF0aW9uVG9rZW46UmV2b2tlIiwiUmVnaXN0cmF0aW9uVG9rZW46VXBkYXRlIiwiUmVwb3J0OlJlYWQiLCJTZXR0aW5nOkNyZWF0ZSIsIlNldHRpbmc6RGVsZXRlIiwiU2V0dGluZzpMaXN0IiwiU2V0dGluZzpSZWFkIiwiU2V0dGluZzpVcGRhdGUiLCJTaXRlOkNyZWF0ZSIsIlNpdGU6RGVsZXRlIiwiU2l0ZTpFeHBvcnRPQ1BQUGFyYW1zIiwiU2l0ZTpHZW5lcmF0ZVFyQ29kZSIsIlNpdGU6TGlzdCIsIlNpdGU6TWFpbnRhaW5QcmljaW5nRGVmaW5pdGlvbnMiLCJTaXRlOlJlYWQiLCJTaXRlOlVwZGF0ZSIsIlNpdGVBcmVhOkFzc2lnbkFzc2V0cyIsIlNpdGVBcmVhOkFzc2lnbkNoYXJnaW5nU3RhdGlvbnMiLCJTaXRlQXJlYTpDcmVhdGUiLCJTaXRlQXJlYTpEZWxldGUiLCJTaXRlQXJlYTpFeHBvcnRPQ1BQUGFyYW1zIiwiU2l0ZUFyZWE6R2VuZXJhdGVRckNvZGUiLCJTaXRlQXJlYTpMaXN0IiwiU2l0ZUFyZWE6UmVhZCIsIlNpdGVBcmVhOlJlYWRBc3NldHMiLCJTaXRlQXJlYTpSZWFkQ2hhcmdpbmdTdGF0aW9uc0Zyb21TaXRlQXJlYSIsIlNpdGVBcmVhOlVuYXNzaWduQXNzZXRzIiwiU2l0ZUFyZWE6VW5hc3NpZ25DaGFyZ2luZ1N0YXRpb25zIiwiU2l0ZUFyZWE6VXBkYXRlIiwiU291cmNlOkxpc3QiLCJUYWc6Q3JlYXRlIiwiVGFnOkRlbGV0ZSIsIlRhZzpFeHBvcnQiLCJUYWc6SW1wb3J0IiwiVGFnOkxpc3QiLCJUYWc6UmVhZCIsIlRhZzpUYWdzR2V0RW1zcCIsIlRhZzpVcGRhdGUiLCJUYXg6TGlzdCIsIlRyYW5zYWN0aW9uOkRlbGV0ZSIsIlRyYW5zYWN0aW9uOkV4cG9ydCIsIlRyYW5zYWN0aW9uOkluRXJyb3IiLCJUcmFuc2FjdGlvbjpMaXN0IiwiVHJhbnNhY3Rpb246UmVhZCIsIlRyYW5zYWN0aW9uOlJlZnVuZFRyYW5zYWN0aW9uIiwiVHJhbnNhY3Rpb246VXBkYXRlIiwiVXNlcjpDcmVhdGUiLCJVc2VyOkRlbGV0ZSIsIlVzZXI6RXhwb3J0IiwiVXNlcjpJbXBvcnQiLCJVc2VyOkluRXJyb3IiLCJVc2VyOkxpc3QiLCJVc2VyOlJlYWQiLCJVc2VyOlN5bmNocm9uaXplQmlsbGluZ1VzZXIiLCJVc2VyOlVwZGF0ZSIsIlVzZXJzU2l0ZXM6QXNzaWduIiwiVXNlcnNTaXRlczpMaXN0IiwiVXNlcnNTaXRlczpSZWFkIiwiVXNlcnNTaXRlczpVbmFzc2lnbiJdLCJzaXRlc0FkbWluIjpbXSwic2l0ZXNPd25lciI6W10sInNpdGVzIjpbXSwiYWN0aXZlQ29tcG9uZW50cyI6WyJvY3BpIiwicmVmdW5kIiwicHJpY2luZyIsIm9yZ2FuaXphdGlvbiIsInN0YXRpc3RpY3MiLCJiaWxsaW5nIiwiYXNzZXQiLCJzbWFydENoYXJnaW5nIiwiZG91YmxlQWNjZXNzIiwiY2FyIl0sImlhdCI6MTY4MzE0MDM2OCwiZXhwIjoxNjgzMTgzNTY4fQ.zJxQAWsWA9CPerIiKjwLyfgn5bY1nFQoxiDjXYGIbJI";
//        String urlString = API_URL + id;
//        URL url = new URL(urlString);
//        System.out.println(url);
//        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
//        connection.setRequestMethod("GET");
//        connection.setRequestProperty("Authorization", "Bearer " + token);
//        int responseCode = connection.getResponseCode();
//        String message = connection.getResponseMessage();
//        System.out.println(message);
//        System.out.println(responseCode);
//        if (responseCode == HttpURLConnection.HTTP_NOT_FOUND) {
//            throw new FileNotFoundException("Charging station with ID " + id + " not found");
//        } else if (responseCode != HttpURLConnection.HTTP_OK) {
//            throw new IOException("Unexpected response code: " + responseCode);
//        }
//
//        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
//
//        StringBuilder response = new StringBuilder();
//        String line;
//
//        while ((line = reader.readLine()) != null) {
//            response.append(line);
//        }
//
//        reader.close();
//
//        JsonNode json =mapper.readTree(response.toString());
//        System.out.println(json.toString());
//        String name = json.get("connectorId").asText();
//        System.out.println(name);
        // Set the camera's image source to the QR code image
        Map<String, Object> settings = new HashMap<>();
        settings.put("cameraSimulation", "image");
        settings.put("imagePath", "C:\\Users\\Asus\\Downloads\\pfe-test-mobile-master\\resources\\cs_qr_codes\\qr_code.png");
        driver.executeScript("mobile: setAppiumSession", settings);

// Locate the scanning area
        WebElement scanArea = driver.findElement(By.xpath("//android.view.View[@resource-id=\"com.wattzhub.cpo:id/texture_view\"]/../../android.view.ViewGroup/android.view.ViewGroup"));

// Get the size and position of the scanning area
        Dimension scanAreaSize = scanArea.getSize();
        Point scanAreaLocation = scanArea.getLocation();

// Calculate the position of the QR code image within the scanning area
        int qrCodeX = scanAreaLocation.getX() + (scanAreaSize.getWidth() / 2);
        int qrCodeY = scanAreaLocation.getY() + (scanAreaSize.getHeight() / 2);

// Execute a script to position the QR code image within the scanning area
        Map<String, Object> scriptArgs = new HashMap<>();
        scriptArgs.put("x", qrCodeX);
        scriptArgs.put("y", qrCodeY);
        driver.executeScript("mobile: dragFromToForDuration", scriptArgs);

    }

}
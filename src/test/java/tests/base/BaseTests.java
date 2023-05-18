package tests.base;


import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;


public abstract
class BaseTests extends AbstractTestNGCucumberTests {
    public static AndroidDriver driver;
    //    public static WebDriver                driver;
    public        AppiumDriverLocalService service;

    //@BeforeClass
    public static
    void configureAppium ( ) throws InterruptedException, MalformedURLException {
        System.out.println ( "Configuring Appium..." );
        // run appium server automatically
      /*  service =
                new AppiumServiceBuilder ( ).withAppiumJS ( new File (
                                                    "C:\\Users\\msi\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js" ) )
                                            .withIPAddress ( "127.0.0.1" ).usingPort ( 4723 )
                                            .withTimeout ( Duration.ofSeconds ( 300 ) )
                                            .build ( );
        service.start ( ); */

        //___________________USING ANDROID EMULATOR___________________

        // create capabilities
        /* UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("sdk_gphone_x86");
        options.setApp("C:\\Users\\msi\\IdeaProjects\\WattzHubCPO_MobileAutomation\\resources\\beta-cpo-v2.1.1 (1).apk");
        // create object for AndroidDriver/IosDriver
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));*/


        // ________________USING PHYSICAL ANDROID DEVICE___________________

        DesiredCapabilities capabilities = new DesiredCapabilities ( );
        capabilities.setCapability ( "deviceName" , "Infinix X665E" );
        capabilities.setCapability ( "automationName" , "UiAutomator2" );
        capabilities.setCapability ( "udid" , "088373729L006869" );
        capabilities.setCapability ( "platformName" , "Android" );
        capabilities.setCapability ( "platformVersion" , "12" );
        capabilities.setCapability ( "appPackage" , "com.wattzhub.cpo" );
        capabilities.setCapability ( "appActivity" , "com.wattzhub.cpo.MainActivity" );
        capabilities.setCapability ( "noReset" , true );
        capabilities.setCapability ( "autoGrantPermissions" , true );
        capabilities.setCapability ( "gpsEnabled" , true );
        capabilities.setCapability ( "autoDismissAlerts" , true );
        capabilities.setCapability (
                "permissions" ,
                "{\"android.webkit.resource.VIDEO_CAPTURE\": \"grant\", \"android.webkit.resource.AUDIO_CAPTURE\": \"grant\", \"android.permission.ACCESS_FINE_LOCATION\": \"grant\"}"
                                   );
        // ________________USING THE APPIUM SERVER___________________

        driver = new AndroidDriver ( new URL ( "http://127.0.0.1:4723" ) , capabilities );


        // ________________USING THE APPIUM GRID___________________

//        // Specify the URL of the Appium Grid hub
//        String hubUrl = " http://172.25.0.1:4444";
//        String node1Url = "http://172.25.0.1:5555";
//
//        try {
//            // Create a new instance of the RemoteWebDriver
//           driver = new AndroidDriver ( new URL( hubUrl), capabilities);
//
//            // Perform your test actions using the driver
//            // ...
//
//            // Close the driver
//            driver.quit();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }




        driver.manage ( ).timeouts ( ).implicitlyWait ( Duration.ofSeconds ( 15 ) );
    }


    // @Test
    //public
    // void testLaunchApp ( ) {
    //     // Create a Duration object for a timeout of 10 seconds
    //     Duration timeoutDuration = Duration.ofSeconds ( 10 );
    //
    //     // Pass the Duration object to the withTimeout method
    //     WebDriverWait wait = new WebDriverWait ( driver , timeoutDuration );
    //
    //     if ( wait.until ( ExpectedConditions.visibilityOfElementLocated ( By.id ( "android:id/content" ) ) )
    //              .isDisplayed ( ) )
    //         System.out.println ( "App launched successfully" );
    // }


    //@AfterClass
//    public
//    void afterTest ( ) {
//
//        driver.quit ( );
//
//        // service.stop ( );
//    }




}



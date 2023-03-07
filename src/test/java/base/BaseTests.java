package base;

//object Locators : xpath, id, className, accessibilityId,androidUIautomator


import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
//import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;


public
class BaseTests {
    public AndroidDriver            driver;
    public AppiumDriverLocalService service;

    @BeforeClass
    public
    void configureAppium ( ) throws MalformedURLException {
        System.out.println("Configuring Appium...");
        // run appium server automatically
        service =
                new AppiumServiceBuilder ( ).withAppiumJS ( new File (
                                                    "C:\\Users\\msi\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js" ) )
                                            .withIPAddress ( "127.0.0.1" ).usingPort ( 4723 )
                                            .withTimeout ( Duration.ofSeconds ( 300 ) )
                                            .build ( );
        service.start ( );

        //___________________USING ANDROID EMULATOR___________________

        // create capabilities
        /* UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("sdk_gphone_x86");
        options.setApp("C:\\Users\\msi\\IdeaProjects\\WattzHubCPO_MobileAutomation\\resources\\beta-cpo-v2.1.1 (1).apk");

        // create object for AndroidDriver/IosDriver
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));*/


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

        driver = new AndroidDriver ( new URL ( "http://127.0.0.1:4723" ) , capabilities );
        driver.manage ( ).timeouts ( ).implicitlyWait ( Duration.ofSeconds ( 5 ) );

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


    @AfterClass
    public
    void afterTest ( ) {

        driver.quit ( );

        service.stop ( );
    }


}

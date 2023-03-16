package tests.login;

import tests.base.BaseTests;
import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import PageObjects.LoginPage;
import PageObjects.SearchChargingStationsMapPage;

import java.net.MalformedURLException;

import static org.testng.AssertJUnit.assertEquals;


public
class LoginTests extends BaseTests {


    LoginPage LoginPage;

    @BeforeClass
    public
    void setUp ( ) throws MalformedURLException {
        configureAppium ( );
        LoginPage = new LoginPage ( driver );
    }

    //successful test
    @Test
    public
    void testSuccessfulLogin ( ) {
        LoginPage.setEmail ( "Kalboussioumaima12@gmail.com" );
        LoginPage.setPassword ( "Kalboussi.Oumaima123" );
        LoginPage.acceptConditions ( );
        SearchChargingStationsMapPage searchChargingStationsMapPage = LoginPage.clickLoginButton ( );
    }


    //successful test
    @Test
    public
    void testConnectionWithoutAcceptingTerms ( ) {
        LoginPage.setEmail ( "Kalboussioumaima12@gmail.com" );
        LoginPage.setPassword ( "Kalboussi.Oumaima123" );
        SearchChargingStationsMapPage searchChargingStationsMapPage = LoginPage.clickLoginButton ( );
        assertEquals (
                driver.findElement ( By.xpath ( "//android.widget.TextView[@index='9']" ) ).getText ( ) ,
                "Vous devez accepter les conditions d'utilisation"
                     );
    }
    //unsuccessful test !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    @Test
    public
    void testConnexionValidEmailInvalidPassword( ) {
        LoginPage.setEmail ( "Kalboussioumaima12@gmail.com" );
        LoginPage.setPassword ( "Kalboussi.Oum54123" );
        LoginPage.acceptConditions ( );
        SearchChargingStationsMapPage searchChargingStationsMapPage = LoginPage.clickLoginButton ( );
        assertEquals(driver.findElement ( By.xpath ( "" ) ).getText(), "Mauvais email ou mot de passe");

    }
    //unsuccessful test !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    @Test
    public
    void testConnexionInvalidEmail( ) {
        LoginPage.setEmail ( "Kalboussi12@gmail.com" );
        LoginPage.setPassword ( "Kalboussi.Oum54123" );
        LoginPage.acceptConditions ( );
        SearchChargingStationsMapPage searchChargingStationsMapPage = LoginPage.clickLoginButton ( );
        assertEquals(driver.findElement ( By.xpath ( "" ) ).getText(), "Mauvais email ou mot de passe");

    }




    @AfterClass
    public
    void tearDown ( ) {
        driver.quit ( );
        service.stop ( );
    }


}

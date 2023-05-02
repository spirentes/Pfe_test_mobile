package tests.search;

import org.testng.ITestContext;
import tests.base.BaseTests;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import PageObjects.SearchChargingStationsMapPage;

import java.net.MalformedURLException;

public
class SearchTests extends BaseTests {
    SearchChargingStationsMapPage SearchChargingStationsMapPage;
    @BeforeClass
    public
    void setUp ( ) throws MalformedURLException {
        configureAppium ( );
        SearchChargingStationsMapPage =  new SearchChargingStationsMapPage ( driver );
    }
    @Test
    public void testSearchField(){
        SearchChargingStationsMapPage.setSearchField ( );

    }
    @AfterClass
    public
    void tearDown ( ) {
        driver.quit ( );
        service.stop ( );
    }

//    @Override
//    public
//    void onStart ( ITestContext context ) {
//
//    }
}

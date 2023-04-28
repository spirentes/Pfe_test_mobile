package tests.permission_tests;

import org.testng.ITestContext;
import tests.base.BaseTests;
import org.testng.annotations.Test;
import PageObjects.permissions.LocationPermission;

public
class LocationTests extends BaseTests {

    LocationPermission locationPermission =new LocationPermission ( super.driver );

    @Test
    public void testAllowOnlyWhileUsingApp() {
        locationPermission.foregroundOnly();
        // Add assertions or additional test steps here

    }

    @Test
    public void testAllowOnlyOnce() {
        locationPermission.onetimeOnly();
        // Add assertions or additional test steps here

    }

    @Test
    public void testDenyLocation() {
        locationPermission.denyLocation();
        // Add assertions or additional test steps here
    }


    @Override
    public
    void onStart ( ITestContext context ) {

    }
}

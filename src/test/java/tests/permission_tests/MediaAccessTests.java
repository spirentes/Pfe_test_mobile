package tests.permission_tests;

import org.testng.ITestContext;
import tests.base.BaseTests;
import org.testng.annotations.Test;
import PageObjects.permissions.MediaAccessPermission;

public
class MediaAccessTests extends BaseTests {
    private MediaAccessPermission mediaPermission = new MediaAccessPermission(super.driver);

    @Test
    public void testAllowMediaAccess() {
        // Perform some action that requires media access permission
        // ...

        mediaPermission.allowMediaAccess();

        // Assert that the permission message disappears and the action is successful
        // ...
    }

    @Test
    public void testDenyMediaAccess() {
        // Perform some action that requires media access permission
        // ...

        mediaPermission.denyMediaAccess();

        // Assert that the permission message disappears and the action fails
        // ...
    }

//    @Override
//    public
//    void onStart ( ITestContext context ) {
//
//    }
}















package UserManagement.Auth;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Created by Prima on 8/5/2016.
 */

@RunWith(Suite.class)

@Suite.SuiteClasses({
        RegisterTest.class,
        LoginTest.class,
        LogoutTest.class
})

public class AuthTestSuite {
    // the class remains empty,
    // used only as a holder for the above annotations
}

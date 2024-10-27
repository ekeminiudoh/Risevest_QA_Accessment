package tests;

import base.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.DashboardPage;
import pages.LoginPage;
import utils.ReadTestData;

import java.lang.reflect.Method;

import static utils.extentReports.ExtentTestManager.startTest;

public class InvalidLoginTest extends TestBase {
    private LoginPage loginPage;
    protected ReadTestData readTestData;
    private SoftAssert softAssert;


    public void setUpTest() {
        loginPage = new LoginPage(driver);
        readTestData = new ReadTestData();
        softAssert = new SoftAssert();

    }


    @Test( description = " TC_02 - validate user cannot login with invalid credentials")
    public void testInvalidLogin(Method method) {
        startTest(method.getName(), method.getAnnotation(Test.class).description(), "invalid login");
        setUpTest();
        loginPage.userSignIn(readTestData.setInvalidEmail(), readTestData.setInvalidPassword());
        softAssert.assertEquals(loginPage.getErrorMessage(), "Invalid email or password.", "Unexpected error message.");
        softAssert.assertTrue(driver.getCurrentUrl().contains("/login"), "User should remain on login page.");
    }
}

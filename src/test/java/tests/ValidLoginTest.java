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

public class ValidLoginTest extends TestBase {

    private LoginPage loginPage;
    private DashboardPage dashboardPage;
    protected ReadTestData readTestData;
    private SoftAssert softAssert;

    public void setUpTest() {
        loginPage = new LoginPage(driver);
        dashboardPage = new DashboardPage(driver);
        readTestData = new ReadTestData();
        softAssert = new SoftAssert();
    }

    @Test( description = " TC_01 - validate user can login with valid credentials")
    public void testValidLogin(Method method) {
        startTest(method.getName(), method.getAnnotation(Test.class).description(), "valid login");
        setUpTest();
        loginPage.userSignIn(readTestData.setValidEmail(), readTestData.setValidPassword());
        softAssert.assertEquals(driver.getTitle(), "Home - Risevest", "Homepage title mismatch.");
        softAssert.assertTrue(dashboardPage.isGreetingNoteDisplayed("EKEMINI"), "Logout button should be visible.");
    }
}


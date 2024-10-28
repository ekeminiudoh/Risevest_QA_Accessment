package tests;

import base.TestBase;
import com.github.javafaker.Faker;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.*;

import java.lang.reflect.Method;
import java.util.List;

import static utils.extentReports.ExtentTestManager.startTest;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class RiseVestE2ETest extends TestBase {

    public LoginPage loginPage;
    public WalletPage walletPage;
    public PlansPage plansPage;
    public SoftAssert softAssert;
    public Faker faker = new Faker();

    @BeforeMethod
    public void setUpTest() {
        loginPage = new LoginPage(driver);
        walletPage = new WalletPage(driver);
        plansPage = new PlansPage(driver);
        softAssert = new SoftAssert();
       }

    String planName = faker.company().catchPhrase();
    String currency = "Naira"; // or "USD"
    String income = "500000"; // Example amount
    String percent = "15"; // Example investment
    String age = "65";// type
    String importanceOption = "Stability"; // Choose among "Capital Growth", "Stability", "Safety"

    @Test
    public void testEndToEndFlow(Method method) throws InterruptedException {
        // Log in with valid credentials
//        startTest(method.getName(), method.getAnnotation(Test.class).description(), "valid login");
        loginPage.userSignIn(readTestData.setValidEmail(), readTestData.setValidPassword());

        walletPage.clickNotificationCloseBtn().gotoWallet();
        walletPage.toggleWalletBalance();
        // asserting that the wallet balance is displayed correctly;
        softAssert.assertTrue(walletPage.getWalletBalance().contains("*"));
        // how/Hide Wallet Balance
        walletPage.toggleWalletBalance(); // Hides balance
        //asserting wallet balance can be hidden
        softAssert.assertTrue(walletPage.getWalletBalance().contains("$"));

        // View Plans
        plansPage.gotoPlans();
        softAssert.assertTrue(driver.getCurrentUrl().contains("/plans"), "User should remain on plans page.");

        plansPage.viewPlans();
        softAssert.assertTrue(plansPage.isPlanCreated(), "Plans should be visible in the view section.");

//      Create a new plan and verify creation
        plansPage.gotoPlans();
        softAssert.assertTrue(driver.getCurrentUrl().contains("/plans"), "User should remain on plans page.");

        plansPage.createNewPlan(planName, percent, age, currency, income, importanceOption);
        softAssert.assertTrue(plansPage.VerifyReviewPage("Review"));
        plansPage.ClickOnCreatePlan();
        softAssert.assertTrue(plansPage.VerifyCreatedPlanPage("You just created your Build Wealth plan"), "created plan successfully");
        Thread.sleep(3000);

    }
}



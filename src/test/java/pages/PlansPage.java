package pages;

import base.PageBase;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.stream.IntStream;

public class PlansPage extends PageBase {

    @FindBy(xpath = "//*[@id=\"root\"]/div/div/a[2]/span[2]")
    public WebElement plansBtn;

    @FindBy(css = "._planCard_1rcc3_1.bg-primary.text-white[data-test-id='user-plan']")
    public WebElement viewPlansSection;

    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/main[1]/div[1]/div[1]/div[2]/div[1]/div[2]/a[1]")
    public WebElement startInvestingButton;

    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/main[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/button[1]")
    public WebElement startInvestingButton2;

    @FindBy(xpath ="//*[@id=\"root\"]/div/main/div/div/div/div/div[2]/ul/li[1]/span[1]")
    public WebElement selectCurrency_ngn;

    @FindBy(xpath ="/html/body/div[1]/div/main/div/div/div/div/div[2]/ul/li[2]/span[1]")
    public WebElement selectCurrency_usd;

    @FindBy(xpath = "//*[@id=\"name\"]")
    public WebElement planNameField;

    @FindBy(xpath = "//*[@id=\"root\"]/div/main/div/div/div/div/form/div/div/form/div/button")
    public WebElement continueBtn;

    @FindBy(xpath = "//*[@id=\"root\"]/div/main/div/div/div/div/form/div/button")
    public WebElement continueBtn2;

    @FindBy(xpath = "//button[normalize-space()='Continue']")
    public WebElement continueBtn3;

    @FindBy(xpath = "/html/body/div[1]/div/main/div/div/div/div/form/div/div[3]/div/input")
    public WebElement  incomeField;

    @FindBy(id = "mui-1")
    public WebElement savingsPercent;

    @FindBy(id = "mui-2")
    public WebElement retirementAge;

    @FindBy(xpath = "//button[normalize-space()='Continue']")
    public WebElement continueBtn4;

    @FindBy(xpath = "//button[normalize-space()='Agree & Continue']")
    public WebElement continueBtn5;

    @FindBy(xpath = "/html/body/div[1]/div/main/div/div/div/div/form/div/div[6]/div/button[1]")
    public WebElement continueBtn6;

    @FindBy(xpath = "/html/body/div[1]/div/main/div/div/div/div/form/div/button")
    public WebElement agreeAndContinueBtn;

    @FindBy(xpath = "//button[normalize-space()='Create Plan']")
    public WebElement createPlanBtn;

    @FindBy(className = "MuiFormControlLabel-labelPlacementEnd")
    List<WebElement> setPreference;

    @FindBy(xpath = "/html/body/div[1]/div/main/div/div/div/div/button")
    public WebElement viewPlanBtn;

    @FindBy(xpath = "/html/body/div[4]/div[3]/div/div[2]/button[2]")
    public WebElement noPayLaterBtn;

    @FindBy(id = "submitPlan")
    public WebElement submitPlanBtn;

    @FindBy(xpath = "//*[@id=\"root\"]/div/main/div/div/div/div/header/h2")
    public WebElement planNameHolder;

    @FindBy(css = ".MuiButtonBase-root.MuiButton-root.MuiButton-contained.MuiButton-containedSecondary.MuiButton-sizeLarge.MuiButton-containedSizeLarge.MuiButton-colorSecondary.MuiButton-disableElevation.MuiButton-fullWidth.MuiButton-root.MuiButton-contained.MuiButton-containedSecondary.MuiButton-sizeLarge.MuiButton-containedSizeLarge.MuiButton-colorSecondary.MuiButton-disableElevation.MuiButton-fullWidth.css-1ez3rum-MuiButtonBase-root-MuiButton-root")
    public WebElement PlanModal;

    @FindBy(xpath = "//h2[normalize-space()='Review']")
    public WebElement ReviewTitle;

    @FindBy(xpath = "/h1[normalize-space()='You just created your Build Wealth plan']")
    public WebElement CreatedPlanTitle;

    public PlansPage(WebDriver driver) {
        super(driver);
    }

    public void gotoPlans() {
        click(plansBtn);
    }

    public void viewPlans() {
        waitForClickable(viewPlansSection);
        click(viewPlansSection);
    }

    public void selectCurrency(String currency) {
        if (currency.equalsIgnoreCase("Naira")) {
            click(selectCurrency_ngn); // Click Naira button
        } else if (currency.equalsIgnoreCase("USD")) {
            click(selectCurrency_usd); // Click USD button
        } else {
            throw new IllegalArgumentException("Unsupported currency: " + currency);
        }
    }

    public void selectPlanOption(String option) {
        for (int i = 0; i < setPreference.size(); i++) {
            // Check if the radio button label matches the option
            if (setPreference.get(i).getText().equalsIgnoreCase(option)) {
                click(setPreference.get(i)); // Click the radio button
                return; // Exit after selecting the option
            }
        }
        throw new IllegalArgumentException("Invalid option: " + option); // If option is not found
    }

    public void createNewPlan( String planName,String percent, String age, String currency, String income, String option) throws InterruptedException {
        try {
            click(startInvestingButton);
            click(startInvestingButton2);
            selectCurrency(currency);

            waitForVisibility(planNameField);
            enterText(planNameField, planName);
            System.out.println("Plan Name Entered");

            click(continueBtn);

            waitForVisibility(incomeField);
            enterText(incomeField, income);
            System.out.println("Income Entered");

            click(continueBtn2);

            waitForVisibility(savingsPercent);
            enterText(savingsPercent, percent);
            System.out.println("Savings Percent Entered");
            int attempts = 0;
            while (attempts < 3) {  // Adjust attempts as needed
                try {
                    driver.findElement(By.xpath("//button[normalize-space()='Continue']")).click();
                    break;
                } catch (StaleElementReferenceException e) {
                    attempts++;
                    System.out.println("Attempting to recover from StaleElementReferenceException - Attempt #" + attempts);
                }
            }

            waitForVisibility(retirementAge);
            enterText(retirementAge, age);
            System.out.println("Retirement Age Entered");
            while (attempts < 3) {  // Adjust attempts as needed
                try {
                    driver.findElement(By.xpath("//button[normalize-space()='Continue']")).click();
                    break;
                } catch (StaleElementReferenceException e) {
                    attempts++;
                    System.out.println("Attempting to recover from StaleElementReferenceException - Attempt #" + attempts);
                }
            }


            selectPlanOption(option); // Ensure option dropdown is properly handled with waits
            while (attempts < 3) {  // Adjust attempts as needed
                try {
                    driver.findElement(By.xpath("//button[normalize-space()='Continue']")).click();
                    break;
                } catch (StaleElementReferenceException e) {
                    attempts++;
                    System.out.println("Attempting to recover from StaleElementReferenceException - Attempt #" + attempts);
                }
            }

            waitForClickable(continueBtn4);
            while (attempts < 4) {  // Adjust attempts as needed
                try {
                    driver.findElement(By.xpath("//button[normalize-space()='Continue']")).click();
                    break;
                } catch (StaleElementReferenceException e) {
                    attempts++;
                    System.out.println("Attempting to recover from StaleElementReferenceException - Attempt #" + attempts);
                }
            }
            waitForClickable(continueBtn5);

            while (attempts < 6) {  // Adjust attempts as needed
                try {
                    driver.findElement(By.xpath("//button[normalize-space()='Agree & Continue']")).click();
                    break;
                } catch (StaleElementReferenceException e) {
                    attempts++;
                    System.out.println("Attempting to recover from StaleElementReferenceException - Attempt #" + attempts);
                }
            }
            Thread.sleep(2000);

//
//        waitForClickable(agreeAndContinueBtn);
//        click(agreeAndContinueBtn);
//
//        waitForClickable(createPlanBtn);
//        click(createPlanBtn);
//
//        System.out.println("New plan created successfully.");

        } catch (Exception e) {
            System.err.println("An error occurred while creating a new plan: " + e.getMessage());
        }
    }

    public void ClickOnCreatePlan(){
        waitForClickable(createPlanBtn);
        createPlanBtn.click();
    }

    public boolean VerifyReviewPage(String text){
        waitForVisibility(ReviewTitle);
        return ReviewTitle.getText().equals(text);
    }

    public boolean VerifyCreatedPlanPage(String text){
        int retries = 3;
        while (retries > 0) {
            try {
                WebElement elem = driver.findElement(By.xpath("/h1[normalize-space()='You just created your Build Wealth plan']"));
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
                wait.until(ExpectedConditions.visibilityOf(elem));
                // Element found and visible
//                waitForVisibility(CreatedPlanTitle);
                return elem.getText().equals(text);
            } catch (StaleElementReferenceException e) {
                retries--;
            }
        }
        throw new TimeoutException("Failed to locate element after retries.");
    }

    public boolean isPlanCreated() {
        waitForClickable(PlanModal);
        click(PlanModal);
        waitForVisibility(planNameHolder);
        return planNameHolder.isDisplayed();
    }

    public String getCreatedPlanName() {
        // Locate the element that displays the created plan's name
        WebElement createdPlanElement = planNameHolder;// Replace with the actual selector
        // Return the text of the located element
        return createdPlanElement.getText().trim(); // Trim to remove any leading/trailing spaces
    }
}

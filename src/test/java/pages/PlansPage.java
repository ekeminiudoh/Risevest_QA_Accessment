package pages;

import base.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.stream.IntStream;

public class PlansPage extends PageBase {

    @FindBy(xpath = "//*[@id=\"root\"]/div/div/a[2]/span[2]")
    public WebElement plansBtn;

    @FindBy(css = "._planCard_1rcc3_1.bg-primary.text-white[data-test-id='user-plan']")
    public WebElement viewPlansSection;

    @FindBy(xpath = "//*[@id=\"root\"]/div/main/div/div/div[2]/div/div[2]/a/div/div/p[3]")
    public WebElement startInvestingButton;

    @FindBy(xpath = "//*[@id=\"root\"]/div/main/div/div/div/div/div/div/button")
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

    @FindBy(xpath = "/html/body/div[1]/div/main/div/div/div/div/form/div/button")
    public WebElement continueBtn3;

    @FindBy(xpath = "/html/body/div[1]/div/main/div/div/div/div/form/div/div[3]/div/input")
    public WebElement  incomeField;

    @FindBy(xpath = "//*[@id=\"mui-1\"]")
    public WebElement savingsPercent;

    @FindBy(xpath = "//*[@id=\"mui-2\"]")
    public WebElement retirementAge;

    @FindBy(xpath = "/html/body/div[1]/div/main/div/div/div/div/form/div/button")
    public WebElement continueBtn4;

    @FindBy(xpath = "/html/body/div[1]/div/main/div/div/div/div/form/div/button")
    public WebElement continueBtn5;

    @FindBy(xpath = "/html/body/div[1]/div/main/div/div/div/div/form/div/div[6]/div/button[1]")
    public WebElement continueBtn6;

    @FindBy(xpath = "/html/body/div[1]/div/main/div/div/div/div/form/div/button")
    public WebElement agreeAndContinueBtn;

    @FindBy(xpath = "/html/body/div[1]/div/main/div/div/div/div/form/div/div[9]/button")
    public WebElement createPlanBtn;

    @FindBy(className = "PrivateSwitchBase-input")
    List<WebElement> setPreference;

    @FindBy(xpath = "/html/body/div[1]/div/main/div/div/div/div/button")
    public WebElement viewPlanBtn;

    @FindBy(xpath = "/html/body/div[4]/div[3]/div/div[2]/button[2]")
    public WebElement noPayLaterBtn;

    @FindBy(id = "submitPlan")
    public WebElement submitPlanBtn;

    @FindBy(xpath = "//*[@id=\"root\"]/div/main/div/div/div/div/header/h2")
    public WebElement planNameHolder;


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
        for (WebElement radioButton : setPreference) {
            // Check if the radio button label matches the option
            if (radioButton.getAttribute("value").equalsIgnoreCase(option)) {
                click(radioButton); // Click the radio button
                return; // Exit after selecting the option
            }
        }
        throw new IllegalArgumentException("Invalid option: " + option); // If option is not found
    }

    public void createNewPlan( String planName,String percent, String age, String currency, String income, String option) {
        click(startInvestingButton);
        click(startInvestingButton2);
        selectCurrency(currency);
        enterText(planNameField, planName);
        click(continueBtn);
        enterText(incomeField, income);
        click(continueBtn2);
        enterText(savingsPercent, percent);
        click(continueBtn3);
        enterText(retirementAge, age);
        click(continueBtn4);
        selectPlanOption(option);
        click(continueBtn5);
        click(continueBtn6);
        click(agreeAndContinueBtn);
        click(createPlanBtn);
    }

    public boolean isPlanCreated() {
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

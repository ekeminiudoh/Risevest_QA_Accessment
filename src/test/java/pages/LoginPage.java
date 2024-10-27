package pages;

import base.PageBase;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class LoginPage extends PageBase {

    @FindBy(id = "email")
    private WebElement emailField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div[2]/main/div/div/div/form/button")
    private WebElement signInBtn;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div[2]/main/div/div/div/form/div[3]/div[2]")
    private WebElement errorMessage;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void userSignIn(String email, String password) {
        enterText(emailField, email);
        enterText(passwordField, password);
        click(signInBtn);
    }

    /**
     * Retrieves the error message displayed on the login page when login fails.
     *
     * @return the error message text if displayed; otherwise, returns null.
     * This method is useful for validating invalid login attempts, as it checks
     * for the presence of an error message and retrieves its content for assertions.
     */
    public String getErrorMessage() {
        return errorMessage.isDisplayed() ? errorMessage.getText() : null;
    }

}

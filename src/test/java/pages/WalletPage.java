package pages;

import base.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WalletPage extends PageBase {

    @FindBy(xpath = "//*[@id=\"root\"]/div/div/a[3]/span[2]")
    public WebElement walletBtn;

    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/main[1]/div[1]/div[1]/div[1]/p[2]")
    public WebElement walletBalance;

    @FindBy(css = "button[class='text-primary'] svg")
    public WebElement viewIcon;

    @FindBy(xpath = "//button[normalize-space()='No, maybe later']")
    public WebElement NotificationCloseBtn;
    @FindBy(xpath = "//button[normalize-space()='Okay, got it!']")
    public WebElement GotItBtn;
    public WalletPage(WebDriver driver) {
        super(driver);
    }
    public WalletPage clickNotificationCloseBtn() {
        waitForClickable(NotificationCloseBtn);
        click(NotificationCloseBtn);
        waitForClickable(GotItBtn);
        click(GotItBtn);
        return this;
    }
    public void gotoWallet() {
        click(walletBtn);
    }

    public String getWalletBalance() {
        return walletBalance.isDisplayed() ? walletBalance.getText() : null;
    }

    public void toggleWalletBalance() {
        waitForClickable(viewIcon);
        click(viewIcon);
    }
}

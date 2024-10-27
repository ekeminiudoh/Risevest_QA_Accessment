package pages;

import base.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DashboardPage extends PageBase {


    @FindBy(xpath = "//*[@id=\"root\"]/div/div/a[1]/span[2]")
    public WebElement homeBtn;

    @FindBy(xpath = "//*[@id=\"root\"]/div/main/div/div/div/div[1]/div[1]")
    public WebElement greetingNote;

    public DashboardPage(WebDriver driver) {
        super(driver);
    }

    public void gotoHome(){
        click(homeBtn);
    }

    public boolean isGreetingNoteDisplayed(String note){
        System.out.println(greetingNote.getText());
        return greetingNote.getText().contains(note);
    }
}

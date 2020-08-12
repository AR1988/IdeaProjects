package gihub.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.PageObject;

public class SettingsPage extends PageObject {

    @FindBy(xpath = "//*[@id=\"options_bucket\"]/div[10]/ul/li[4]/details/summary")
    WebElement deleteRepoBtn;

    @FindBy(xpath = "//*[@id=\"options_bucket\"]/div[10]/ul/li[4]/details/details-dialog/div[3]/form/p/input")
    WebElement confirmDeleteInput;

    @FindBy(xpath = "//*[@id=\"options_bucket\"]/div[10]/ul/li[4]/details/details-dialog/div[3]/form")
    WebElement deleteRepoForm;


    public SettingsPage(WebDriver driver) {
        super(driver);
    }

    public MainPage deleteRepo(String repoName, String nickName) {
        clickOnWebElement(deleteRepoBtn);
        sendTextToWebElement(confirmDeleteInput, nickName + "/" + repoName);
        submitForm(deleteRepoForm);
        return new MainPage(driver);
    }
}

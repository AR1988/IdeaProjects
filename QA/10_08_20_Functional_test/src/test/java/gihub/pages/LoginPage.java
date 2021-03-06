package gihub.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.PageObject;


public class LoginPage extends PageObject {

    @FindBy(id = "login_field")
    private WebElement login;

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(name = "commit")
    private WebElement loginButton;

    public LoginPage(WebDriver driver) {
        super(driver);
    }


    public MainPage login(String user, String pass) {

        sendTextToWebElement(login, user);
        sendTextToWebElement(password, pass);
        clickOnWebElement(loginButton);
        return new MainPage(driver);
    }
}

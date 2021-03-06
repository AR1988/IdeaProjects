package gihub.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.PageObject;

public class MainPage extends PageObject {

    @FindBy(xpath = "/html/body/div[1]/header/div[6]/details/summary")
    private WebElement menuBtn;

//    @FindBy(xpath = "//*[@id=\"repos-container\"]/ul")
//    private WebElement repoList;

    @FindBy(xpath = "//*[@id=\"js-flash-container\"]")
    private WebElement alertBlock;

    public MainPage(WebDriver driver) {
        super(driver);
    }

    private void clickCreatePage() {
        clickOnWebElement(menuBtn);
        driver.findElement(By.xpath("/html/body/div[1]/header/div[6]/details/details-menu/a[1]"))
                .click();
    }

    public CreateRepoPage createRepo() {
        clickCreatePage();
        return new CreateRepoPage(driver);
    }

    public String getMessageFromAlertBlock() {
        return alertBlock.getText();
    }
}

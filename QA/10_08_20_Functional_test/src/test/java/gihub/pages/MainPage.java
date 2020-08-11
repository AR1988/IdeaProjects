package gihub.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.PageObject;

public class MainPage extends PageObject {

    public MainPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "/html/body/div[1]/header/div[6]/details/summary")
    private WebElement menuBtn;

    @FindBy(xpath = "//*[@id=\"repos-container\"]/ul")
    private WebElement repoList;


    private void clickCreatePage() {
        menuBtn.click();
        driver.findElement(By.xpath("/html/body/div[1]/header/div[6]/details/details-menu/a[1]"))
                .click();
    }

    public CreateRepoPage createRepo() {
        clickCreatePage();
        return new CreateRepoPage(driver);
    }
}

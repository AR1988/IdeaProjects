package gihub.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.PageObject;

public class CreateRepoPage extends PageObject {

    @FindBy(id = "repository_name")
    private WebElement repoNameInput;
    @FindBy(id = "repository_description")
    private WebElement descriptionInput;
    @FindBy(xpath = "//*[@id=\"new_repository\"]/div[4]/button")
    private WebElement repoFormSubmitBtn;
    @FindBy(id = "new_repository")
    private WebElement repoForm;

    public CreateRepoPage(WebDriver driver) {
        super(driver);
    }

    public void fillForm(String repoName, String desc) {

        sendTextToWebElement(repoNameInput, repoName);
        sendTextToWebElement(descriptionInput, desc);
    }

    public RepoDetailsPage submitCreateRepoForm() {
        submitForm(repoFormSubmitBtn);
        return new RepoDetailsPage(driver);
    }

    public WebElement getRepoFormSubmitBtn() {
        return repoFormSubmitBtn;
    }

}

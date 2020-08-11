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
    @FindBy(id = "new_repository")
    private WebElement repoForm;

    public CreateRepoPage(WebDriver driver) {
        super(driver);
    }

    public boolean createBtnEnabled() {
        waitForElementIsDispalyed(3000, repoForm);
        return repoForm.isEnabled();
    }

    public void fillAndSendForm(String repoName, String desc) {
        repoNameInput.sendKeys(repoName);
        descriptionInput.sendKeys(desc);
    }

    public RepoDetailsPage submitCreateRepoForm() {
        repoForm.submit();
        return new RepoDetailsPage(driver);
    }
}

package gihub.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.PageObject;

public class RepoDetailsPage extends PageObject {

    @FindBy(xpath = "//*[@id=\"js-repo-pjax-container\"]/div[1]/div/div/h1/strong/a")
    private WebElement repoName;

    @FindBy(xpath = "//*[@id=\"js-repo-pjax-container\"]/div[1]/div/div/h1/span[1]/a")
    private WebElement repoNickName;

    @FindBy(xpath = "//*[@id=\"js-repo-pjax-container\"]/div[2]/nav/ul/li[9]/a")
    private WebElement settingBtn;

    @FindBy(xpath = "//*[@id=\"empty-setup-clone-url\"]")
    private WebElement repoGitUrl;

    @FindBy(xpath = "//*[@id=\"js-repo-pjax-container\"]/div[1]/nav/ul/li[9]/a")
    private WebElement settingRepoUrl;

    public RepoDetailsPage(WebDriver driver) {
        super(driver);
    }

    public boolean verifyRepoNames(String repoName, String nickName) {
        return this.repoName.getText().equals(repoName)
                && this.repoNickName.getText().equals(nickName);
    }

    public SettingsPage goToSettingPage() {
        settingRepoUrl.click();
        return new SettingsPage(driver);
    }

    public String getRepoGitUrl() {
        return repoGitUrl.getAttribute("value");
    }

    public WebElement getRepoName() {
        return repoName;
    }
}

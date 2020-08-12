package gihub.pages;

import gihub.exception.FindMoreThenOneElement;
import gihub.exception.NoSearchResult;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.PageObject;

public class ReposPage extends PageObject {

    @FindBy(id = "your-repos-filter")
    private WebElement searchInput;
    @FindBy(xpath = "//*[@id=\"js-pjax-container\"]/div[2]/div/div[2]/div[2]/div/div[1]/form")
    private WebElement searchForm;

    @FindBy(xpath = "//*[@id=\"user-repositories-list\"]/div[1]/div[1]/strong[1]")
    private WebElement searchResult;

    @FindBy(xpath = "//*[@id=\"js-pjax-container\"]/div[1]/div/div/div[2]/div/nav/a[2]/span")
    private WebElement totalRepos;

    public ReposPage(WebDriver driver) {
        super(driver);
    }

    public RepoDetailsPage searchRepo(String repoName) {

        search(repoName);

        int searchResult = getSearchResultAmount(repoName);

        if (searchResult == 0)
            throw new NoSearchResult("no repo found with name " + repoName);
        else if (searchResult > 1)
            throw new FindMoreThenOneElement("find: " + searchResult + " elements");
        else
            driver.findElement(By.xpath("//*[@id=\"user-repositories-list\"]/ul/li/div[1]/div[1]/h3/a"))
                    .click();

        return new RepoDetailsPage(driver);
    }

    public int getSearchResultAmount(String repoName) {
        search(repoName);
        return Integer.parseInt(this.searchResult.getText());
    }

    public int getTotalRepos() {
        int searchResult;
        try {
            searchResult = Integer.parseInt(this.totalRepos.getText());
        } catch (NumberFormatException ex) {
            searchResult = 0;
        }
        return searchResult;
    }

    public RepoDetailsPage getFirstRepoDetails() {
        driver.findElement(By.xpath("//*[@id=\"user-repositories-list\"]/ul/li/div[1]/div[1]/h3/a"))
                .click();
        return new RepoDetailsPage(driver);
    }

    private void search(String repoName) {
        sendTextToWebElement(searchInput, repoName);
        submitForm(searchForm);
    }
}

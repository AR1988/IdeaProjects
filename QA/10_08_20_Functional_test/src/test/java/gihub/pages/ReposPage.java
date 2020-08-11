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
    WebElement searchInput;
    @FindBy(xpath = "//*[@id=\"js-pjax-container\"]/div[2]/div/div[2]/div[2]/div/div[1]/form")
    WebElement searchForm;

    @FindBy(xpath = "//*[@id=\"user-repositories-list\"]/div[1]/div[1]/strong[1]")
    WebElement searchResult;

    //    @FindBy(xpath = "//*[@id=\"js-pjax-container\"]/div[1]/div/div/div[2]/div/nav/a[2]/span")
    @FindBy(xpath = "//*[@id=\"js-pjax-container\"]/div[1]/div/div/div[2]/div/nav/a[2]/span")
    WebElement totalRepos;

    public ReposPage(WebDriver driver) {
        super(driver);
    }

    public RepoDetailsPage searchRepo(String repoName) {
        searchInput.sendKeys(repoName);
        searchForm.submit();

        int searchResult = Integer.parseInt(this.searchResult.getText());

        if (searchResult == 0)
            throw new NoSearchResult("no repo found with name " + repoName);
        else if (searchResult > 1)
            throw new FindMoreThenOneElement("find: " + searchResult + " elements");
        else
            driver.findElement(By.xpath("//*[@id=\"user-repositories-list\"]/ul/li/div[1]/div[1]/h3/a"))
                    .click();
        return new RepoDetailsPage(driver);
    }

    public RepoDetailsPage getFirstRepoDetails() {
        driver.findElement(By.xpath("//*[@id=\"user-repositories-list\"]/ul/li/div[1]/div[1]/h3/a"))
                .click();
        return new RepoDetailsPage(driver);
    }

    public int findElement(String repoName) {
        searchInput.sendKeys(repoName);
        searchForm.submit();

        return Integer.parseInt(this.searchResult.getText());
    }

    public int getTotalRepos() {
        return Integer.parseInt(this.totalRepos.getText());
    }
}

package gihub;

import gihub.pages.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import utils.FunctionalTest;

import java.util.ArrayList;
import java.util.List;

import static java.lang.System.currentTimeMillis;
import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class BasicTest extends FunctionalTest {
    LoginPage loginPage = new LoginPage(driver);
    MainPage mainPage;
    RepoDetailsPage repoDetailsPage;
    SettingsPage settingsPage;
    ReposPage reposPage;

    String user = "phone.boock.test@gmail.com";
    String password = "testpass_111";
    String nickName = "ar1919";
    String baseURL = "https://github.com/login";
    String reposURL = "https://github.com/" + nickName + "?tab=repositories";
    String mainPageUrl = "https://github.com/";

    String repoName = "My-test-Repo";
    String repoDesc = "Desc: " + this.repoName;

    static int totalReposBeforeStart;


    @Before
    public void init() {
        driver.get(baseURL);
        mainPage = loginPage.login(user, password);
    }

    @Test
    public void test00_setTotalRepos() {
        driver.get(reposURL);
        reposPage = new ReposPage(driver);

        totalReposBeforeStart = reposPage.getTotalRepos();
        logger.info("total repos before test start: " + totalReposBeforeStart);
    }

    @Test
    public void test01_createRepo() {
        CreateRepoPage createRepoPage = mainPage.createRepo();
        assertFalse(createRepoPage.getRepoFormSubmitBtn().isEnabled());

        createRepoPage.fillForm(this.repoName, repoDesc);
        repoDetailsPage = createRepoPage.submitCreateRepoForm();

        assertTrue(repoDetailsPage.verifyRepoNames(this.repoName, nickName));
        assertEquals(mainPageUrl + nickName + "/" + this.repoName + ".git",
                repoDetailsPage.getRepoGitUrl());
    }

    @Test
    public void test02_repoExist_testFormValidators() {
        driver.get(baseURL);
        CreateRepoPage createRepoPage = mainPage.createRepo();
        assertFalse(createRepoPage.getRepoFormSubmitBtn().isEnabled());
        createRepoPage.fillForm(this.repoName, repoDesc);
        assertFalse(createRepoPage.getRepoFormSubmitBtn().isEnabled());
    }

    @Test
    public void test03_searchFoundOne() {
        driver.get(reposURL);
        reposPage = new ReposPage(driver);
        assertEquals(1, reposPage.getSearchResultAmount(this.repoName));
    }

    @Test
    public void test04_deleteRepoBySearch() {
        driver.get(reposURL);

        assertEquals(1, searchResultAmount(this.repoName));
        reposPage = new ReposPage(driver);
        repoDetailsPage = reposPage.searchRepo(repoName);
        settingsPage = repoDetailsPage.goToSettingPage();
        mainPage = settingsPage.deleteRepo(this.repoName, nickName);
        String message = mainPage.getMessageFromAlertBlock();

        String expectedMessage = "Your repository \""
                + nickName + "/"
                + this.repoName
                + "\" was successfully deleted.";

        assertEquals(expectedMessage, message);
        assertEquals(0, searchResultAmount(this.repoName));
    }

    @Test
    public void test05_searchFound6() {
        List<String> reposNames = new ArrayList<>();
        for (int i = 0; i < 2; i++)
            reposNames.add("repoName_" + currentTimeMillis() + i);

        createRepos(reposNames);

        driver.get(reposURL);
        reposPage = new ReposPage(driver);
        String repoName = "repoName";
        assertEquals(2, reposPage.getSearchResultAmount(repoName));

        deleteRepo(reposNames);
    }

    @Test
    public void test06_reposAmountBeforeAndAfter() {
        driver.get(reposURL);
        reposPage = new ReposPage(driver);
        int reposAfterTests = reposPage.getTotalRepos();
        logger.info("total repos after all tests: " + reposAfterTests);
        assertEquals(totalReposBeforeStart, reposAfterTests);
    }

    private void createRepos(List<String> reposNames) {
        for (String name : reposNames) {
            driver.get(mainPageUrl);
            CreateRepoPage createRepoPage = mainPage.createRepo();
            createRepoPage.fillForm(name, repoDesc);
            createRepoPage.submitCreateRepoForm();
        }
    }

    private void deleteRepo(List<String> reposNames) {
        driver.get(reposURL);

        reposPage = new ReposPage(driver);

        for (String repoName : reposNames) {
            driver.get(reposURL);
            repoDetailsPage = reposPage.searchRepo(repoName);
            settingsPage = repoDetailsPage.goToSettingPage();
            mainPage = settingsPage.deleteRepo(repoName, nickName);
        }
    }


    private int searchResultAmount(String repoNameForSearch) {
        driver.get(reposURL);
        reposPage = new ReposPage(driver);
        return reposPage.getSearchResultAmount(repoNameForSearch);
    }

    /**
     * run this, if need to clear all repositories
     * <p>
     * ACHTUNG!!!
     * !*** removes all repositories ***!
     */

//    @Test
    public void clearRepos() {
        driver.get(reposURL);
        ReposPage reposPage = new ReposPage(driver);
        int reposNumber = reposPage.getTotalRepos();
        for (int i = 0; i < reposNumber; i++) {
            driver.get(reposURL);
            repoDetailsPage = reposPage.getFirstRepoDetails();
            String repoName = repoDetailsPage.getRepoName().getText();
            settingsPage = repoDetailsPage.goToSettingPage();
            settingsPage.deleteRepo(repoName, nickName);
        }
    }
}



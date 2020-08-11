package gihub;

import gihub.pages.*;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import utils.FunctionalTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.lang.System.currentTimeMillis;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class BasicTest extends FunctionalTest {
    LoginPage loginPage = new LoginPage(driver);
    MainPage mainPage;
    RepoDetailsPage repoDetailsPage;
    SettingsPage settingsPage;

    String user = "phone.boock.test@gmail.com";

    String password = "test_pass11";

    String nickName = "ar1919";

    String baseURL = "https://github.com/login";

    String repoURL = "https://github.com/" + nickName + "?tab=repositories";


    @Before
    public void init() {
        driver.get(baseURL);
        mainPage = loginPage.login(user, password);
    }

    @Test
    public void test01_createRepo() {
        String repoName = String.valueOf(currentTimeMillis());
        CreateRepoPage createRepoPage = mainPage.createRepo();
        createRepoPage.fillAndSendForm(repoName, repoName + "desc.");
        repoDetailsPage = createRepoPage.submitCreateRepoForm();

        assertTrue(repoDetailsPage.verifyRepoNames(repoName, nickName));
        assertEquals("https://github.com/" + nickName + "/" + repoName + ".git",
                repoDetailsPage.getRepoGitUrl());
    }

    @Test
    public void test02_searchFoundOne() {
        String repoName = String.valueOf(currentTimeMillis());
        createRepos(Collections.singletonList(repoName));

        driver.get(repoURL);

        ReposPage reposPage = new ReposPage(driver);
        assertEquals(1, reposPage.findElement(repoName));
    }

    @Test
    public void test03_deleteRepoBySearch() {
        String repoName = "My-test-Repo";
        createRepos(Collections.singletonList(repoName));

        driver.get(repoURL);
        ReposPage reposPage = new ReposPage(driver);

        repoDetailsPage = reposPage.searchRepo(repoName);
        settingsPage = repoDetailsPage.goToSettingPage();
        settingsPage.deleteRepo(repoName, nickName);

        String message = driver.findElement(By.xpath("//*[@id=\"js-flash-container\"]")).getText();
        String expectedMessage = "Your repository \"" + nickName + "/" + repoName + "\" was successfully deleted.";
        assertEquals(expectedMessage, message);
    }

    @Test
    public void test04_searchFound3() {
        List<String> reposNames = new ArrayList<>();
        for (int i = 0; i <= 5; i++)
            reposNames.add("repoName: " + currentTimeMillis() + i);

        createRepos(reposNames);

        driver.get("https://github.com/" + nickName + "?tab=repositories");
        ReposPage reposPage = new ReposPage(driver);


        String repoName = "repoName";
        assertEquals(6, reposPage.findElement(repoName));
    }

    @Test
    public void test04_removeRepo() {
        driver.get("https://github.com/" + nickName + "?tab=repositories");
        ReposPage reposPage = new ReposPage(driver);

        try {
            int reposNumber = reposPage.getTotalRepos();
            for (int i = 0; i < reposNumber; i++) {
                driver.get("https://github.com/" + nickName + "?tab=repositories");

                repoDetailsPage = reposPage.getFirstRepoDetails();
                String repoName = repoDetailsPage.getRepoName().getText();

                settingsPage = repoDetailsPage.goToSettingPage();
                settingsPage.deleteRepo(repoName, nickName);
            }
        } catch (NumberFormatException e) {
            assertTrue(true);
        }
    }

    private void createRepos(List<String> reposNames) {
        for (String name : reposNames) {
            driver.get(baseURL);
            CreateRepoPage createRepoPage = mainPage.createRepo();
            createRepoPage.fillAndSendForm(name, name + " desc");

            repoDetailsPage = createRepoPage.submitCreateRepoForm();
        }
    }
}



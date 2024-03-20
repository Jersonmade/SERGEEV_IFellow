import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.Test;
import ru.iFellow.pages.CreateBugPage;
import ru.iFellow.pages.LoginPage;
import ru.iFellow.pages.MainPage;
import ru.iFellow.pages.TestSeleniumPage;
import ru.iFellow.utils.ConfProperties;
import webhooks.WebHook;

public class SelenideTest extends WebHook {
    private final LoginPage loginPage = new LoginPage();
    private final MainPage mainPage = new MainPage();
    private final TestSeleniumPage testSeleniumPage = new TestSeleniumPage();
    private final CreateBugPage createBugPage = new CreateBugPage();

    @Epic(value = "Jira")
    @Feature(value = "Авторизация")
    @Test
    public void loginTest() {
        loginPage.inputLog(ConfProperties.getProperty("login"));
        loginPage.inputPass(ConfProperties.getProperty("password"));
        loginPage.clickBtn();
        mainPage.clickProjects();
        mainPage.checkTasks();
        testSeleniumPage.searchTestSelenium();
        testSeleniumPage.collectionVersion();
        testSeleniumPage.collectionStatus();
        createBugPage.clickCreateBugLink();
        createBugPage.inputTopic();
        createBugPage.fillDescription();
        createBugPage.fillEnvironmentField();
        createBugPage.createBug();
        createBugPage.createDoneTest();
        createBugPage.businessProgress();
        createBugPage.checkBug();
    }

}

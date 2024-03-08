import org.junit.jupiter.api.Test;
import ru.iFellow.pages.CreateBugPage;
import ru.iFellow.pages.LoginPage;
import ru.iFellow.pages.MainPage;
import ru.iFellow.pages.TestSeleniumPage;
import webhooks.WebHook;

public class SelenideTest extends WebHook {
    private final LoginPage loginPage = new LoginPage();
    private final MainPage mainPage = new MainPage();
    private final TestSeleniumPage testSeleniumPage = new TestSeleniumPage();
    private final CreateBugPage createBugPage = new CreateBugPage();

    @Test
    public void loginTest() {
        loginPage.inputLog();
        loginPage.inputPass();
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

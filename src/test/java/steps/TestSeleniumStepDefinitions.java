package steps;

import io.cucumber.java.ru.И;
import ru.iFellow.pages.TestSeleniumPage;

public class TestSeleniumStepDefinitions {
    private final TestSeleniumPage testSeleniumPage = new TestSeleniumPage();

    @И("пользователь ищет задачу \"TestSelenium\"")
    public void searchTask() {
        testSeleniumPage.searchTestSelenium();
    }

    @И("пользователь проверяет статус задачи")
    public void verifyTaskStatus() {
        testSeleniumPage.collectionStatus();
    }

    @И("пользователь проверяет привязку в \"Исправить в версиях\"")
    public void verifyTaskVersion() {
        testSeleniumPage.collectionVersion();
    }
}

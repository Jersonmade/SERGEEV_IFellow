package steps;

import io.cucumber.java.ru.И;
import ru.iFellow.pages.TestSeleniumPage;

public class TestSeleniumStepDefinitions {
    private final TestSeleniumPage testSeleniumPage = new TestSeleniumPage();

    @И("пользователь ищет задачу \"TestSelenium\"")
    public void пользователь_ищет_задачу() {
        testSeleniumPage.searchTestSelenium();
    }

    @И("пользователь проверяет статус задачи")
    public void пользователь_проверяет_статус_задачи() {
        testSeleniumPage.collectionStatus();
    }

    @И("пользователь проверяет привязку в \"Исправить в версиях\"")
    public void пользователь_проверяет_привязку_задачи() {
        testSeleniumPage.collectionVersion();
    }
}

package steps;

import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Тогда;
import ru.iFellow.pages.CreateBugPage;

public class CreateBugStepDefinitions {
    private final CreateBugPage createBugPage = new CreateBugPage();

    @И("пользователь нажимает на кнопку \"Создать баг\"")
    public void pressCreateBugBtn() {
        createBugPage.clickCreateBugLink();
    }

    @И("пользователь вводит тему задачи")
    public void enterTopic() {
        createBugPage.inputTopic();
    }

    @И("пользователь заполняет описание задачи")
    public void fillDesc() {
        createBugPage.fillDescription();
    }

    @И("пользователь заполняет поле окружения")
    public void fillEnvField() {
        createBugPage.fillEnvironmentField();
    }

    @И("пользователь создает задачу")
    public void makeBug() {
        createBugPage.createBug();
    }

    @И("пользователь завершает тестирование задачи")
    public void makeDoneTest() {
        createBugPage.createDoneTest();
    }

    @И("пользователь переводит задачу в статус \"готово\"")
    public void switchTaskStatus() {
        createBugPage.businessProgress();
    }

    @Тогда("пользователь проверяет созданную задачу")
    public void verifyBug() {
        createBugPage.checkBug();
    }
}

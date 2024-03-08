package steps;

import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Тогда;
import ru.iFellow.pages.CreateBugPage;

public class CreateBugStepDefinitions {
    private final CreateBugPage createBugPage = new CreateBugPage();

    @И("пользователь нажимает на кнопку \"Создать баг\"")
    public void пользователь_нажимает_на_кнопку_Создать_баг() {
        createBugPage.clickCreateBugLink();
    }

    @И("пользователь вводит тему задачи")
    public void пользователь_вводит_тему_задачи() {
        createBugPage.inputTopic();
    }

    @И("пользователь заполняет описание задачи")
    public void пользователь_заполняет_описание_задачи() {
        createBugPage.fillDescription();
    }

    @И("пользователь заполняет поле окружения")
    public void пользователь_заполняет_поле_окружения() {
        createBugPage.fillEnvironmentField();
    }

    @И("пользователь создает задачу")
    public void пользователь_создает_задачу() {
        createBugPage.createBug();
    }

    @И("пользователь завершает тестирование задачи")
    public void пользователь_завершает_тестирование_задачи() {
        createBugPage.createDoneTest();
    }

    @И("пользователь переводит задачу в статус \"готово\"")
    public void пользователь_прогрессирует_бизнес_процесс() {
        createBugPage.businessProgress();
    }

    @Тогда("пользователь проверяет созданную задачу")
    public void пользователь_проверяет_созданную_задачу() {
        createBugPage.checkBug();
    }
}

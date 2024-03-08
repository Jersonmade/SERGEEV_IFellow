package steps;

import io.cucumber.java.ru.И;
import ru.iFellow.pages.MainPage;

public class MainStepDefinitions {
    private final MainPage mainPage = new MainPage();

    @И("пользователь нажимает на проект \"Test\"")
    public void пользователь_нажимает_на_проект() {
        mainPage.clickProjects();
    }

    @И("пользователь проверяет задачи в проекте")
    public void пользователь_проверяет_задачи() {
        mainPage.checkTasks();
    }
}

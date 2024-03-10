package steps;

import io.cucumber.java.ru.И;
import ru.iFellow.pages.MainPage;

public class MainStepDefinitions {
    private final MainPage mainPage = new MainPage();

    @И("пользователь нажимает на проект \"Test\"")
    public void pressProjects() {
        mainPage.clickProjects();
    }

    @И("пользователь проверяет задачи в проекте")
    public void verifyTasks() {
        mainPage.checkTasks();
    }
}

package todotesting;

import com.codeborne.selenide.Configuration;
import org.openqa.selenium.chrome.ChromeOptions;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Condition.*;

import static com.codeborne.selenide.Selenide.*;

public class ToDoPageTest {

    @BeforeAll
    public static void setUpAll() {

        Configuration.browserSize = "1280x800";
        SelenideLogger.addListener("allure", new AllureSelenide());
        Configuration.holdBrowserOpen = false;
    }

    @BeforeEach
    public void setUp() {

        // Fix the issue https://github.com/SeleniumHQ/selenium/issues/11750
        Configuration.browserCapabilities = new ChromeOptions().addArguments("--remote-allow-origins=*");
        open("https://todomvc.com/examples/react/dist/");
    }

    @AfterEach
    public void clear() {
        closeWebDriver();
    }

    @Test
    @DisplayName("Task creation and text checking")
    public void taskCreationAndTextChecking() {

        Task task = ToDoPage.createRandomTask(10);
        task.label.shouldHave(text(task.text));
    }

    @Test
    @DisplayName("Task deleting check")
    public void taskDeletingCheck() {

        Task task = ToDoPage.createRandomTask(12);
        task.deleteTaskButton.shouldNotBe(visible);

        task.label.hover();
        task.deleteTaskButton.shouldBe(visible);
        task.deleteTaskButton.click();
        task.label.shouldNot(exist);
    }

    @Test
    @DisplayName("Checking the task status change")
    public void checkingTheTaskStatusChange() {

        Task task = ToDoPage.createTask("Simple Task");

        task.toggleCheckbox.click();
        task.toggleCheckbox.shouldBe(checked);
    }

    @Test
    @DisplayName("Checking that only active tasks are visible")
    public void checkingThatOnlyActiveTasksAreVisible() {

        Task task1 = ToDoPage.createRandomTask(10);
        Task task2 = ToDoPage.createRandomTask(10);

        task2.toggleCheckbox.click();
        ToDoPage.footerButtonActive.click();

        task1.label.shouldBe(visible);
        task2.label.shouldNotBe(visible);
    }

    @Test
    @DisplayName("Checking that only completed tasks are visible")
    public void checkingThatOnlyCompletedTasksAreVisible() {

        Task task1 = ToDoPage.createRandomTask(10);
        Task task2 = ToDoPage.createRandomTask(10);

        task2.toggleCheckbox.click();
        ToDoPage.footerButtonCompleted.click();

        task1.label.shouldNotBe(visible);
        task2.label.shouldBe(visible);
    }

    @Test
    @DisplayName("Checking that all tasks are completed")
    public void checkingThatAllTasksAreCompleted() {

        Task task1 = ToDoPage.createRandomTask(10);
        Task task2 = ToDoPage.createRandomTask(10);

        ToDoPage.toggleAllTasks.click();

        task1.toggleCheckbox.shouldBe(checked);
        task2.toggleCheckbox.shouldBe(checked);
    }

    @Test
    @DisplayName("Checking that all completed tasks have been deleted")
    public void checkingThatAllCompletedTasksHaveBeenDeleted() {

        Task task1 = ToDoPage.createRandomTask(10);
        Task task2 = ToDoPage.createRandomTask(10);

        ToDoPage.toggleAllTasks.click();
        ToDoPage.footerButtonClearCompleted.click();

        task1.label.shouldNot(exist);
        task2.label.shouldNot(exist);
    }
}

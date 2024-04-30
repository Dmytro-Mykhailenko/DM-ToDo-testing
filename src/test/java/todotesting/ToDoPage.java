package todotesting;

import com.codeborne.selenide.SelenideElement;
import org.apache.commons.lang3.RandomStringUtils;
import static com.codeborne.selenide.Selenide.$x;

// page_url = https://todomvc.com/examples/react/dist/
public class ToDoPage {

    public static SelenideElement todoInput = $x("//*[@data-testid='text-input']");
    public static SelenideElement toggleAllTasks = $x("//*[@data-testid='toggle-all']");
    public static SelenideElement footerButtonActive = $x("//*[@href='#/active']");
    public static SelenideElement footerButtonCompleted = $x("//*[@href='#/completed']");
    public static SelenideElement footerButtonClearCompleted = $x("//*[@class='clear-completed']");

    public static Task createTask(String text) {

        ToDoPage.todoInput.setValue(text);
        ToDoPage.todoInput.pressEnter();

        return new Task(text);
    }

    public static Task createRandomTask(int textLength) {

        String text = RandomStringUtils.randomAlphanumeric(textLength);
        ToDoPage.todoInput.setValue(text);
        ToDoPage.todoInput.pressEnter();

        return new Task(text);
    }
}
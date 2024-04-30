package todotesting;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class Task {

    public String text;

    public SelenideElement label;
    public SelenideElement deleteTaskButton;
    public SelenideElement toggleCheckbox;

    public Task(String text) {

        this.text = text;
        this.label = $x("//*[@data-testid='todo-item-label' and text()='" + text + "']");
        this.deleteTaskButton = $x("//*[@data-testid='todo-item-label' and text()='" + text + "']/../*[@data-testid='todo-item-button']");
        this.toggleCheckbox = $x("//*[@data-testid='todo-item-label' and text()='" + text + "']/../*[@data-testid='todo-item-toggle']");
    }
}


package com.example.dmtodotesting;

import com.codeborne.selenide.SelenideElement;
import org.apache.commons.lang3.RandomStringUtils;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

// page_url = https://todomvc.com/examples/react/dist/
public class ToDoPage {

    public static SelenideElement todoInput = $x("//*[@data-testid='text-input']");
    public static SelenideElement toggleAllTasks = $x("//*[@data-testid='toggle-all']");
    public static SelenideElement footerButtonActive = $x("//*[@href='#/active']");
    public static SelenideElement footerButtonCompleted = $x("//*[@href='#/completed']");
    public static SelenideElement footerButtonClearCompleted = $x("//*[@class='clear-completed']");

    public static Task createTask(String taskText) {

        ToDoPage.todoInput.setValue(taskText);
        ToDoPage.todoInput.pressEnter();

        return new Task(taskText);
    }

    public static Task createRandomTask(int taskTextLength) {

        String taskText = RandomStringUtils.randomAlphanumeric(taskTextLength);
        ToDoPage.todoInput.setValue(taskText);
        ToDoPage.todoInput.pressEnter();

        return new Task(taskText);
    }
}
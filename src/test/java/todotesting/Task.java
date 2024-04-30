package com.example.dmtodotesting;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class Task {

    public String tText;

    public SelenideElement label;
    public SelenideElement deleteTaskButton;
    public SelenideElement toggleCheckbox;

    public Task(String taskText) {

        this.tText = taskText;

        String taskLabelXpath = "//*[@data-testid='todo-item-label' and text()='" + this.tText + "']";
        String deleteTaskButtonXpath = taskLabelXpath + "/../*[@data-testid='todo-item-button']";
        String taskToggleCheckboxXpath = taskLabelXpath + "/../*[@data-testid='todo-item-toggle']";

        this.label = $x(taskLabelXpath);
        this.deleteTaskButton = $x(deleteTaskButtonXpath);
        this.toggleCheckbox = $x(taskToggleCheckboxXpath);
    }
}


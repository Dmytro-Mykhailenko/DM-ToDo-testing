# Testing of ToDoMVC webApp

- ***ToDoMVC webApp [URL](https://todomvc.com/examples/react/dist/)***

# Dependencies

- ***Maven, version: 3.8.5***
- ***Java, version: 21***
- ***Maven Surefire Plugin, version: 2.22.2***
- ***SLF4J Simple, version: 2.0.7***
- ***JUnit Jupiter, version: 5.10.0***
- ***Allure, version: 2.24.0***
- ***AspectJ, version: 1.9.19***
- ***Selenide, version: 6.19.1***

## Web UI checks

| № | Check name                                          | Status |
|---|-----------------------------------------------------|--------|
| 1 | Task creation and text checking                     | Pass   |
| 2 | Task deleting check                                 | Pass   |
| 3 | Checking the task status change                     | Pass   |
| 4 | Checking that only active tasks are visible         | Pass   |
| 5 | Checking that only completed tasks are visible      | Pass   |
| 6 | Checking that all tasks are completed               | Pass   |
| 7 | Checking that all completed tasks have been deleted | Pass   |

### Web Element names & Xpath locators

| № | Element name                 | Xpath                                                                                             |
|---|------------------------------|---------------------------------------------------------------------------------------------------|
| 1 | To-do input                  | //*[@data-testid='text-input']                                                                    |
| 2 | Toggle all tasks button      | //*[@data-testid='toggle-all']                                                                    |
| 3 | Show active tasks button     | //*[@href='#/active']                                                                             |
| 4 | Show completed tasks button  | //*[@href='#/completed']                                                                          |
| 5 | Clear completed tasks button | //*[@class='clear-completed']                                                                     |
| 6 | Task label                   | //*[@data-testid='todo-item-label' and text()='{taskText}']                                       |
| 7 | Delete task button           | //*[@data-testid='todo-item-label' and text()='{taskText}']/../*[@data-testid='todo-item-button'] |
| 8 | Task toggle button           | //*[@data-testid='todo-item-label' and text()='{taskText}']/../*[@data-testid='todo-item-toggle'] |

---

**Usage**

```
mvn clean test  
mvn allure:serve 
```

To run a specific test class using Maven, execute the following command in the terminal:

```
mvn clean test -Dtest=TestClassName
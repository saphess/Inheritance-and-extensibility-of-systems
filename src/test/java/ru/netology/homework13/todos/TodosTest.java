package ru.netology.homework13.todos;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class TodosTest {
    @Test
    public void shouldAddThreeTasksOfDifferentType() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {simpleTask, epic, meeting};
        Task[] actual = todos.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindNothing() {
        SimpleTask simpleTask1 = new SimpleTask(1, "SimpleTask1");
        SimpleTask simpleTask2 = new SimpleTask(2, "SimpleTask2");

        String[] subtasks1 = {"Task1", "Task2", "Task3"};
        Epic epic1 = new Epic(1, subtasks1);
        String[] subtasks2 = {"task1", "task2", "task3"};
        Epic epic2 = new Epic(2, subtasks2);

        Meeting meet1 = new Meeting(1,"Topic1","Project1", "Now");
        Meeting meet2 = new Meeting(2,"Topic2","Project2", "Tomorrow");

        Todos todos = new Todos();

        todos.add(simpleTask1);
        todos.add(simpleTask2);
        todos.add(epic1);
        todos.add(epic2);
        todos.add(meet1);
        todos.add(meet2);

        Task[] expected = new Task[0];
        Task[] actual = todos.search("search");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindTaskFromSimpleTask() {
        SimpleTask simpleTask1 = new SimpleTask(1, "SimpleTask1");
        SimpleTask simpleTask2 = new SimpleTask(2, "SimpleTask2");

        Todos todos = new Todos();
        todos.add(simpleTask1);
        todos.add(simpleTask2);

        Task[] expected = {simpleTask1, simpleTask2};
        Task[] actual = todos.search("Task");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindTaskFromEpic() {
        String[] subtasks1 = {"Task1", "Task2", "Task3"};
        Epic epic1 = new Epic(1, subtasks1);

        String[] subtasks2 = {"task1", "task2", "task3"};
        Epic epic2 = new Epic(2, subtasks2);

        Todos todos = new Todos();
        todos.add(epic1);
        todos.add(epic2);

        Task[] expected = {epic1};
        Task[] actual = todos.search("Task");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindTaskFromMeetingIfSearchByStart() {
        Meeting meet1 = new Meeting(1,"Topic1","Project1", "Now");
        Meeting meet2 = new Meeting(2,"Topic2","Project2", "Tomorrow");

        Todos todos = new Todos();
        todos.add(meet1);
        todos.add(meet2);

        Task[] expected = new Task[0];
        Task[] actual = todos.search("Tomorrow");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindTaskFromMeetingIfSearchByTopic() {
        Meeting meet1 = new Meeting(1,"Topic1","Project1", "Now");
        Meeting meet2 = new Meeting(2,"Topic2","Project2", "Tomorrow");

        Todos todos = new Todos();
        todos.add(meet1);
        todos.add(meet2);

        Task[] expected = {meet1, meet2};
        Task[] actual = todos.search("Topic");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindTaskFromMeetingIfSearchByProject() {
        Meeting meet1 = new Meeting(1,"Topic1","Project1", "Now");
        Meeting meet2 = new Meeting(2,"Topic2","Project2", "Tomorrow");

        Todos todos = new Todos();
        todos.add(meet1);
        todos.add(meet2);

        Task[] expected = {meet1, meet2};
        Task[] actual = todos.search("Project");
        Assertions.assertArrayEquals(expected, actual);
    }
}

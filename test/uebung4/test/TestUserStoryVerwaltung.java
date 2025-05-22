package uebung4.test;


import main.uebung4.userstory.Task;
import main.uebung4.userstory.UserStory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TestUserStoryVerwaltung {
    List<UserStory> user;
    List<Task> task;

    @BeforeEach
    void init () {
        user = new ArrayList<>();
        task = new ArrayList<>();
    }

    @Test
    void test() {
        user.add(new UserStory(1, "User Story 1", "should-have"));
        task.add(new Task(10, "Test Task"));

        assertEquals(1, user.size());
        assertEquals(1, task.size());

        assertEquals("ID: 1, Beschreibung: User Story 1, should-have\nZugeordnete Tasks: Keine", user.get(0).toString());

        user.get(0).addTask(task.get(0));

        assertEquals("ID: 1, Beschreibung: User Story 1, should-have\nZugeordnete Tasks: \nID: 10, Beschreibung: Test Task\n", user.get(0).toString());
    }
}

package main.uebung4.userstory;

import java.io.Serializable;
import java.util.ArrayList;

public class UserStory implements Serializable {
    private int id;
    private String beschreibung;
    private String priority; // M | S | C | W
    private ArrayList<Task> tasks;

    public UserStory(int id, String beschreibung, String priority) {
        this.id = id;
        this.beschreibung = beschreibung;
        this.priority = priority;
        tasks = new ArrayList<>();
    }

    public void addTask(Task task){
        tasks.add(task);
    }

    public int getId(){
        return id;
    }

    @Override
    public String toString() {
        String s = "";

        s += "ID: " + id + ", ";
        s += "Beschreibung: " + beschreibung + ", ";
        s += priority + "\n";

        if (tasks.size() == 0) {
            s += "Zugeordnete Tasks: Keine";
        } else {
            s+="Zugeordnete Tasks: \n";
            for (int i=0; i<tasks.size(); i++) {
                s += tasks.get(i).toString() + "\n";
            }
        }

        return s;
    }
}

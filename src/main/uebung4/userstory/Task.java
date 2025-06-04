package main.uebung4.userstory;

import java.io.Serializable;

public class Task implements Serializable {
    private int id;
    private String beschreibung;

    public Task(int id, String beschreibung){
        this.id=id;
        this.beschreibung= beschreibung;
    }

    public int getId(){
        return id;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Beschreibung: " + beschreibung;
    }
}

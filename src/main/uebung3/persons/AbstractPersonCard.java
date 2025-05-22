package main.uebung3.persons;

public abstract class AbstractPersonCard implements PersonCard {
    private static int iDs = 1;
    private String vorname;
    private String nachname;
    private int id;

    AbstractPersonCard(String vorname, String nachname) {
        this.vorname = vorname;
        this.nachname = nachname;
        this.id = iDs++;
    }

    @Override
    public String getFirstName() {
        return vorname;
    }

    @Override
    public String getLastName() {
        return nachname;
    }

    @Override
    public int getId() {
        return id;
    }
}

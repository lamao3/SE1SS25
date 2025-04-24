package main.uebung2.persons;

public class DeveloperCard extends AbstractPersonCard {

    private boolean hasEnoughCoffee;

    public DeveloperCard(String vorname, String nachname, boolean hasEnoughCoffee) {
        super(vorname, nachname);
        this.hasEnoughCoffee = hasEnoughCoffee;
    }

    public boolean getHasEnoughCoffee() {
        return hasEnoughCoffee;
    }
}

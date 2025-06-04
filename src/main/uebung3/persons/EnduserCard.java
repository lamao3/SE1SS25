package main.uebung3.persons;

public class EnduserCard extends AbstractPersonCard {

    private boolean isHungry;

    public EnduserCard(String vorname, String nachname, boolean isHungry) {
        super(vorname, nachname);
        this.isHungry = isHungry;
    }

    public boolean getIsHungry() {
        return isHungry;
    }
}

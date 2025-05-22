package main.uebung3.box;

import main.uebung3.persons.DeveloperCard;
import main.uebung3.persons.EnduserCard;
import main.uebung3.persons.PersonCard;

import java.util.ArrayList;

public class CardBox {
    private ArrayList<PersonCard> cards;

    public CardBox() {
        this.cards = new ArrayList<>();
    }

    public int size() {
        return cards.size();
    }

    public void addPersonCard(PersonCard p) throws CardBoxException {
        if (!checkIfExists(p))
            cards.add(p);
    }

    public String deletePerson(int id) {
        PersonCard p = null;

        for (int i=0; i<cards.size(); i++) {
            if (cards.get(i).getId() == id) {
                p = cards.get(i);
                cards.remove(i);
                break;
            }
        }

        if (p == null) {
            return "Zu löschende Person ist nicht vorhanden!";
        }

        return "Person mit der ID " + id + " wurde gelöscht!";
    }

    public boolean checkIfExists(PersonCard p) throws CardBoxException {
        boolean res = false;
        int x = p.getId();

        if (size() == 0)
            return res;

        for (int i=0; i<cards.size(); i++) {
            if (cards.get(i).getId() == x) {
                res = true;
                throw new CardBoxException("Das CardBox-Objekt mit der ID [ID des Objekts] ist bereits vorhanden");
            }
        }

        return res;
    }

    public void showContent() {
        for (int i=0; i<cards.size(); i++) {
            PersonCard p = cards.get(i);

            String s = "ID = " + p.getId() + ", Vorname = " + p.getFirstName() + ", Nachname = " + p.getLastName();

            if (p instanceof DeveloperCard) {
                s += ", hasEnoughCoffee = " + ((DeveloperCard) p).getHasEnoughCoffee();
            }

            if (p instanceof EnduserCard) {
                s += ", isHungry = " + ((EnduserCard) p).getIsHungry();
            }

            System.out.println(s);
        }
    }
}

package main.uebung1.client;

import main.uebung1.businesslogic.FactoryHexNumberTransformer;
import main.uebung1.businesslogic.HexNumberTransformer;

public class Client {
    public void printTransformation(int number) {
        String result = "";

        try {
            result = FactoryHexNumberTransformer.createHexNumberTransformer().transformNumber(number);
        } catch (Exception e) {
            System.out.println("Number Error");
        }

        System.out.println("Die Hexadezimaldarstellung der Zahl " + number + " ist: " + result);
    }
}


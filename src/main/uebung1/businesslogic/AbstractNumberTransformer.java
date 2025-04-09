package main.uebung1.businesslogic;

public abstract class AbstractNumberTransformer implements NumberTransformer {
    public String getTransformNumber(String res, int number) throws Exception {
        if ((number < 1) || (number > 65535)) {
            System.out.println("Number out of Bounds. Nur zwischen 1 und 65535.");
            throw new Exception("Number out of Bounds");
        } else {
            return res;
        }
    }
}

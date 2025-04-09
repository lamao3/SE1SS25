package main.uebung1.businesslogic;

public class FactoryHexNumberTransformer {
    public static HexNumberTransformer createHexNumberTransformer() {
        return new HexNumberTransformer();
    }
}

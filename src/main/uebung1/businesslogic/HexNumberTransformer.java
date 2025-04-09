package main.uebung1.businesslogic;

public class HexNumberTransformer extends AbstractNumberTransformer {
    @Override
    public String transformNumber(int number) throws Exception {
        return getTransformNumber(Integer.toHexString(number), number);
    }

    @Override
    public String getTransformerType() {
        return "Transformer für Hexadezimalzahlen";
    }
}

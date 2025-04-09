package main.uebung1.businesslogic;

import java.text.DecimalFormat;

public class GermanFormatNumberTransformer  extends AbstractNumberTransformer {
    @Override
    public String transformNumber(int number) throws Exception {
        return getTransformNumber(new DecimalFormat("#.###").format(number), number);
    }

    @Override
    public String getTransformerType() {
        return "Transformer für deutsche Zahlenformatierungen";
    }
}

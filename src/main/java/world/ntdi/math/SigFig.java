package world.ntdi.math;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;
import java.math.MathContext;
import java.text.DecimalFormat;

@Getter
@AllArgsConstructor
public class SigFig {
    private final int m_amountOfSigFigs;

    public double roundSigFigs(final double p_value) {
        if (p_value == 0.0) {
            return 0.0;
        }

        double orderOfMagnitude = Math.floor(Math.log10(Math.abs(p_value))) + 1;

        // Calculate the scale factor
        double scale = Math.pow(10, m_amountOfSigFigs - orderOfMagnitude);

        // Adjust the sign after scaling
        double scaledNum = p_value * scale;

        // Round to the nearest integer
        long roundedValue = Math.round(scaledNum);

        // Divide by the scale factor to get the rounded result
        double r = roundedValue / scale;
        return r;
    }
}

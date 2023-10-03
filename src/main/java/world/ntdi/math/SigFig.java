package world.ntdi.math;

import lombok.Getter;

import java.math.BigDecimal;
import java.math.MathContext;

@Getter
public class SigFig {
    private final int m_amountOfSigFigs;

    public SigFig(final double p_value) {
        m_amountOfSigFigs = calculateAmountOfSigFigs(p_value);
    }

    public double roundSigFigs(final double p_value) {
        return roundSigFigs(p_value, m_amountOfSigFigs);
    }

    public double roundSigFigs(final double p_value, final int p_amountOfSigFigs) {
        BigDecimal bigDecimal = new BigDecimal(p_value);
        bigDecimal = bigDecimal.round(new MathContext(p_amountOfSigFigs));
        return bigDecimal.doubleValue();
    }

    private int calculateAmountOfSigFigs(final double p_value) {
        String numericalString = String.valueOf(p_value);

        String [] sig_figs = numericalString.split("(^0+(\\.?)0*|(~\\.)0+$|\\.)");

        int sum = 0;

        for (final String fig : sig_figs) {
            sum += fig.length();
        }

        return sum;
    }
}

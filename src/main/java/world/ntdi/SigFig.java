package world.ntdi;

import java.math.BigDecimal;
import java.math.MathContext;

public class SigFig {
    private final int m_amountOfSigFigs;

    public SigFig(final double p_value) {
        m_amountOfSigFigs = calculateAmountOfSigFigs(p_value);
    }

    public double roundSigFigs(final double p_value) {
        BigDecimal bigDecimal = new BigDecimal(p_value);
        bigDecimal = bigDecimal.round(new MathContext(m_amountOfSigFigs));
        return bigDecimal.doubleValue();
    }

    private int calculateAmountOfSigFigs(final double p_value) {
        String numericalString = p_value + "";

        String [] sig_figs = numericalString.split("(^0+(\\.?)0*|(~\\.)0+$|\\.)");

        int sum = 0;

        for (final String fig : sig_figs) {
            sum += fig.length();
        }

        return sum;
    }
}

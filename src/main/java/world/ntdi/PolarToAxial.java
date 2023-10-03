package world.ntdi;

import java.math.BigDecimal;
import java.math.MathContext;

public final class PolarToAxial {
    public static void main(String[] args) {
        final double magnitude = 120;
        final double angle = 30D;
        final String units = "m";
        final String direction = "North of West";

        final String[] subDirection = direction.split(" ");

        final String firstHalf = subDirection[0];
        final String lastHalf = subDirection[2];

        final double sinD = magnitude * (Math.sin(Math.toRadians(angle)));
        final double cosD = magnitude * (Math.cos(Math.toRadians(angle)));

        double x = 0;
        double y = 0;

        if (firstHalf.equalsIgnoreCase("east") || firstHalf.equalsIgnoreCase("west")) {
            y = cosD * (lastHalf.equalsIgnoreCase("south") ? -1 : 1);
            x = sinD * (firstHalf.equalsIgnoreCase("west") ? -1 : 1);
        } else if (firstHalf.equalsIgnoreCase("north") || firstHalf.equalsIgnoreCase("south")) {
            y = sinD * (firstHalf.equalsIgnoreCase("south") ? -1 : 1);
            x = cosD * (lastHalf.equalsIgnoreCase("west") ? -1 : 1);
        }

        final double roundedX = roundSigFigs(x, 3);
        final double roundedY = roundSigFigs(y, 3);

        System.out.println("(" + roundedX + ", " + roundedY + ") " + units);
    }

    private static double roundSigFigs(final double p_value, final int p_sigFigs) {
        BigDecimal bigDecimal = new BigDecimal(p_value);
        bigDecimal = bigDecimal.round(new MathContext(p_sigFigs));
        return bigDecimal.doubleValue();
    }

    private static int calculateAmountOfSigFigs(final double p_value) {
        String numericalString = p_value + "";

        String [] sig_figs = numericalString.split("(^0+(\\.?)0*|(~\\.)0+$|\\.)");

        int sum = 0;

        for (final String fig : sig_figs) {
            sum += fig.length();
        }

        return sum;
    }
}

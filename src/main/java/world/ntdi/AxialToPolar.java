package world.ntdi;

import java.math.BigDecimal;
import java.math.MathContext;

public final class AxialToPolar {
    public static void main(String[] args) {
        final double x = 5D;
        final double y = -30D;
        final String unit = "m";

        final double xAbs = Math.abs(x);
        final double yAbs = Math.abs(y);

        final double tan;

        final String direction;

        final double magnitude = Math.sqrt((xAbs*xAbs) + (yAbs*yAbs));
        final double magnitudeRounded = roundSigFigs(magnitude, 3);

        if (xAbs > yAbs) { // North or South of East or West
            tan = Math.toDegrees(Math.atan(yAbs / xAbs));

            final String firstHalf = y > 0 ? "North" : "South";
            final String lastHalf = x > 0 ? "East" : "West";

            direction = firstHalf + " of " + lastHalf;
        } else { // East or West of North or South
            tan = Math.toDegrees(Math.atan(xAbs / yAbs));

            final String firstHalf = x > 0 ? "East" : "West";
            final String lastHalf = y > 0 ? "North" : "South";

            direction = firstHalf + " of " + lastHalf;
        }

        final double roundedTan = roundSigFigs(tan, 3);

        System.out.println(magnitudeRounded + " " + unit + " @ " + roundedTan + " " + direction);
    }

    private static double roundSigFigs(final double p_value, final int p_sigFigs) {
        BigDecimal bigDecimal = new BigDecimal(p_value);
        bigDecimal = bigDecimal.round(new MathContext(p_sigFigs));
        return bigDecimal.doubleValue();
    }
}

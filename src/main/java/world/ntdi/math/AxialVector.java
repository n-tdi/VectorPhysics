package world.ntdi.math;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class AxialVector {
    private final double m_x;
    private final double m_y;
    private final String m_unit;

    public PolarVector toPolar() {
        final SigFig sigFig = new SigFig(m_x);

        final double xAbs = Math.abs(m_x);
        final double yAbs = Math.abs(m_y);

        final double tan;

        final String direction;

        final double magnitude = Math.sqrt((xAbs*xAbs) + (yAbs*yAbs));
        final double magnitudeRounded = sigFig.roundSigFigs(magnitude);

        if (xAbs > yAbs) { // North or South of East or West
            tan = Math.toDegrees(Math.atan(yAbs / xAbs));

            final String firstHalf = m_y > 0 ? "North" : "South";
            final String lastHalf = m_x > 0 ? "East" : "West";

            direction = firstHalf + " of " + lastHalf;
        } else { // East or West of North or South
            tan = Math.toDegrees(Math.atan(xAbs / yAbs));

            final String firstHalf = m_x > 0 ? "East" : "West";
            final String lastHalf = m_y > 0 ? "North" : "South";

            direction = firstHalf + " of " + lastHalf;
        }

        final double roundedTan = sigFig.roundSigFigs(tan);

        return new PolarVector(magnitudeRounded, m_unit, roundedTan, direction);
    }

    @Override
    public String toString() {
        return "(" + m_x + ", " + m_y + ") " + m_unit;
    }
}

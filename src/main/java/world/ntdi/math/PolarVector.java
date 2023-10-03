package world.ntdi.math;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PolarVector {
    private final double m_magnitude;
    private final String m_unit;
    private final double m_angle;
    private final String m_direction;

    public AxialVector toAxial() {
        final SigFig sigFig = new SigFig(m_magnitude);

        final String[] subDirection = m_direction.split(" ");

        final String firstHalf = subDirection[0];
        final String lastHalf = subDirection[2];

        final double sinD = m_magnitude * (Math.sin(Math.toRadians(m_angle)));
        final double cosD = m_magnitude * (Math.cos(Math.toRadians(m_angle)));

        double x = 0;
        double y = 0;

        if (firstHalf.equalsIgnoreCase("east") || firstHalf.equalsIgnoreCase("west")) {
            y = cosD * (lastHalf.equalsIgnoreCase("south") ? -1 : 1);
            x = sinD * (firstHalf.equalsIgnoreCase("west") ? -1 : 1);
        } else if (firstHalf.equalsIgnoreCase("north") || firstHalf.equalsIgnoreCase("south")) {
            y = sinD * (firstHalf.equalsIgnoreCase("south") ? -1 : 1);
            x = cosD * (lastHalf.equalsIgnoreCase("west") ? -1 : 1);
        }

        final double roundedX = sigFig.roundSigFigs(x);
        final double roundedY = sigFig.roundSigFigs(y);

        return new AxialVector(roundedX, roundedY, m_unit);
    }

    @Override
    public String toString() {
        return m_magnitude + " " + m_unit + " @ " + m_angle + " " + m_direction;
    }
}

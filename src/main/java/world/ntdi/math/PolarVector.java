package world.ntdi.math;

import lombok.AllArgsConstructor;
import lombok.Getter;
import world.ntdi.step.Step;

@Getter
@AllArgsConstructor
public class PolarVector {
    private final double m_magnitude;
    private final String m_unit;
    private final double m_angle;
    private final String m_direction;

    public PolarVector add(final PolarVector p_polarVectorToAdd) {
        final Step step = Step.getInstance();

        step.addStep("Convert our first vector to axial");

        final AxialVector axialEquivalent = toAxial();

        step.addStep(axialEquivalent.toString());

        step.addStep("Convert our second vector to add to axial");

        final AxialVector axialEquivalentToAdd = p_polarVectorToAdd.toAxial();

        System.out.println(axialEquivalentToAdd.toString());

        step.addStep("Then we add our x and y and that makes a resultant axial");

        final AxialVector axialResult = axialEquivalent.add(axialEquivalentToAdd);

        step.addStep(axialResult.toString());

        step.addStep("Now we convert our axial vector to polar notation");

        final PolarVector polarVector = axialResult.toPolar();

        step.addStep(polarVector.toString());

        return polarVector;
    }

    public AxialVector toAxial() {
        final SigFig sigFig = new SigFig(3);
        final Step step = Step.getInstance();

        final String[] subDirection = m_direction.split(" ");

        final String firstHalf = subDirection[0];
        final String lastHalf = subDirection[2];

        final double sinD = m_magnitude * (Math.sin(Math.toRadians(m_angle)));
        final double cosD = m_magnitude * (Math.cos(Math.toRadians(m_angle)));

        step.addStep(m_magnitude + "(sin" + m_angle + "): " + sinD);
        step.addStep(m_magnitude + "(cos" + m_angle + "): " + cosD);

        double x = 0;
        double y = 0;

        if (firstHalf.equalsIgnoreCase("east") || firstHalf.equalsIgnoreCase("west")) {
            y = cosD * (lastHalf.equalsIgnoreCase("south") ? -1 : 1);
            x = sinD * (firstHalf.equalsIgnoreCase("west") ? -1 : 1);

            step.addStep("Because we're going east or west off of the y axis, we'll use y = cos, x = sin, times -1 for west and south respectively");
        } else if (firstHalf.equalsIgnoreCase("north") || firstHalf.equalsIgnoreCase("south")) {
            y = sinD * (firstHalf.equalsIgnoreCase("south") ? -1 : 1);
            x = cosD * (lastHalf.equalsIgnoreCase("west") ? -1 : 1);

            step.addStep("Because we're going north or south off of the x axis, we'll use y = sin, x = cos, times -1 for west and south respectively");
        }

        final double roundedX = sigFig.roundSigFigs(x);
        final double roundedY = sigFig.roundSigFigs(y);

        step.addStep("Which makes our final x: " + roundedX);
        step.addStep("Which makes our final y: " + roundedY);

        return new AxialVector(roundedX, roundedY, m_unit);
    }

    @Override
    public String toString() {
        return m_magnitude + " " + m_unit + " @ " + m_angle + " " + m_direction;
    }
}

package world.ntdi;

import world.ntdi.math.PolarVector;
import world.ntdi.math.SigFig;
import world.ntdi.step.Step;

public final class VectorPhysics {
    public static void main(String[] args) {
        final PolarVector polarVector = new PolarVector(150, "m", 30, "West of South");

        final PolarVector polarVector1 = new PolarVector(100, "m", 15, "South of East");

        Step.getInstance().addStep(polarVector + " + " + polarVector1);

        final PolarVector result = polarVector.add(polarVector1);

        Step.getInstance().addStep("Our result: " + result);
    }
}

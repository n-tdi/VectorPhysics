package world.ntdi;

import world.ntdi.ui.AdditionPanel;
import world.ntdi.ui.ConversionPanel;

import javax.swing.*;

public final class VectorPhysics {
    public static void main(String[] args) {
//        final PolarVector polarVector = new PolarVector(150, "m", 30, "West of South");
//
//        final PolarVector polarVector1 = new PolarVector(100, "m", 15, "South of East");
//
//        Step.getInstance().addStep(polarVector + " + " + polarVector1);
//
//        final PolarVector result = polarVector.add(polarVector1);
//
//        Step.getInstance().addStep("Our result: " + result);


        SwingUtilities.invokeLater(() -> {
            final JFrame frame = new JFrame("Vector Physics");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            int size = 50;

            frame.setSize(size * 9, size * 16);

            final JTabbedPane tabbedPane = new JTabbedPane();

            tabbedPane.addTab("Conversion", new ConversionPanel());
            tabbedPane.addTab("Addition", new AdditionPanel());

            frame.add(tabbedPane);
            frame.setVisible(true);
        });
    }
}

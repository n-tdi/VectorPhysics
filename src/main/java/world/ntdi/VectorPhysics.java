package world.ntdi;

import world.ntdi.ui.AdditionPanel;
import world.ntdi.ui.ConversionPanel;

import javax.swing.*;

public final class VectorPhysics {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            final JFrame frame = new JFrame("Vector Physics");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            final int size = 50;

            frame.setSize(size * 9, size * 12);

            final JTabbedPane tabbedPane = new JTabbedPane();

            tabbedPane.addTab("Conversion", new ConversionPanel());
            tabbedPane.addTab("Addition", new AdditionPanel());

            frame.add(tabbedPane);
            frame.setVisible(true);
        });
    }
}

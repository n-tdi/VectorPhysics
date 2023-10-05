package world.ntdi.ui;

import world.ntdi.ui.components.AverageInput;

import javax.swing.*;
import java.awt.*;

public class SolvingPanel extends JPanel {
    public SolvingPanel() {
        super(new GridBagLayout());
        final GridBagConstraints gridBagConstraints = new GridBagConstraints();

        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridx = 0;

        add(new JLabel("Find the missing value in s = d/t"), gridBagConstraints);

        final AverageInput averageInput = new AverageInput();

        gridBagConstraints.gridy = 1;

        add(averageInput, gridBagConstraints);
    }
}

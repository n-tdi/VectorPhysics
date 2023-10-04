package world.ntdi.ui;

import world.ntdi.math.PolarVector;
import world.ntdi.ui.components.StepOutput;
import world.ntdi.ui.components.VectorInput;

import javax.swing.*;
import java.awt.*;
import java.util.function.Consumer;

public class AdditionPanel extends JPanel {
    public AdditionPanel() {
        setLayout(new GridBagLayout());
        final GridBagConstraints gridBagConstraints = new GridBagConstraints();

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;

        add(new JLabel("Add Two Vectors"), gridBagConstraints);

        final StepOutput stepOutput = new StepOutput();

        final Consumer<String> additionComplete = stepOutput::addSteps;

        gridBagConstraints.gridy = 1;
        add(new VectorAddition(additionComplete), gridBagConstraints);

        gridBagConstraints.gridy = 2;
        add(stepOutput, gridBagConstraints);
    }

    private static class VectorAddition extends JPanel {
        public VectorAddition(final Consumer<String> p_stringConsumer) {
            super(new GridBagLayout());
            final GridBagConstraints gridBagConstraints = new GridBagConstraints();
            gridBagConstraints.gridx = 0;

            final VectorInput vectorInput = new VectorInput();
            final JPanel plusPanel = new JPanel();
            final VectorInput vectorInputToAdd = new VectorInput();
            final JPanel addPanel = new JPanel();

            plusPanel.add(new JLabel("+"));

            final JButton addButton = new JButton("Add");
            final JLabel resultVectorLabel = new JLabel();

            addPanel.add(addButton);
            addPanel.add(resultVectorLabel);

            gridBagConstraints.gridy = 0;
            add(vectorInput, gridBagConstraints);

            gridBagConstraints.gridy = 1;
            add(plusPanel, gridBagConstraints);

            gridBagConstraints.gridy = 2;
            add(vectorInputToAdd, gridBagConstraints);

            gridBagConstraints.gridy = 3;
            add(addPanel, gridBagConstraints);

            addButton.addActionListener((e) -> {
                if (vectorInput.getVector() == null || vectorInputToAdd.getVector() == null) {
                    resultVectorLabel.setText("Enter all values");
                    return;
                }

                final PolarVector polarVector = vectorInput.getVector();
                final PolarVector polarVectorToAdd = vectorInputToAdd.getVector();

                final PolarVector resultVector = polarVector.add(polarVectorToAdd);

                resultVectorLabel.setText(resultVector.toString());
                p_stringConsumer.accept(resultVector.toString());
            });
        }
    }
}

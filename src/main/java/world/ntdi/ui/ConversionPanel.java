package world.ntdi.ui;

import world.ntdi.math.AxialVector;
import world.ntdi.math.PolarVector;
import world.ntdi.step.Step;
import world.ntdi.ui.components.StepOutput;

import javax.swing.*;
import java.awt.*;
import java.util.function.Consumer;

public class ConversionPanel extends JPanel {
    public ConversionPanel() {
        super(new GridBagLayout());
        final GridBagConstraints gridBagConstraints = new GridBagConstraints();

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;

        add(new JLabel("Convert between Axial and Polar notation"), gridBagConstraints);

        final StepOutput stepOutput = new StepOutput();

        final Consumer<String> convertSuccess = stepOutput::addSteps;

        gridBagConstraints.gridy = 1;
        add(new AxialToPolar(convertSuccess), gridBagConstraints);

        gridBagConstraints.gridy = 2;
        add(new PolarToAxial(convertSuccess), gridBagConstraints);

        gridBagConstraints.gridy = 3;
        add(stepOutput, gridBagConstraints);
    }

    private static class AxialToPolar extends JPanel {
        public AxialToPolar(final Consumer<String> p_convertConsumer) {
            setLayout(new GridBagLayout());
            final GridBagConstraints gridBagConstraints = new GridBagConstraints();

            final JPanel inputPanel = new JPanel();

            final JTextField textFieldX = new JTextField(3);
            final JTextField textFieldY = new JTextField(3);
            final JTextField textFieldUnit = new JTextField(5);

            inputPanel.add(new JLabel("("));
            inputPanel.add(textFieldX);
            inputPanel.add(new JLabel(", "));
            inputPanel.add(textFieldY);
            inputPanel.add(new JLabel(") "));
            inputPanel.add(textFieldUnit);

            final JPanel submitPanel = new JPanel();

            final JButton submitButton = new JButton("Convert");
            final JLabel convertedLabel = new JLabel();

            submitPanel.add(submitButton);
            submitPanel.add(convertedLabel);

            gridBagConstraints.gridx = 0;
            gridBagConstraints.gridy = 0;

            add(inputPanel, gridBagConstraints);

            gridBagConstraints.gridy = 1;

            add(submitPanel, gridBagConstraints);

            submitButton.addActionListener(e -> {
                if (textFieldX.getText().isEmpty() || textFieldY.getText().isEmpty() || textFieldUnit.getText().isEmpty()) {
                    convertedLabel.setText("Enter all values");
                    return;
                }

                final double x = Double.parseDouble(textFieldX.getText());
                final double y = Double.parseDouble(textFieldY.getText());
                final String unit = textFieldUnit.getText();

                final AxialVector axialVector = new AxialVector(x, y, unit);
                final PolarVector polarVector = axialVector.toPolar();

                convertedLabel.setText(polarVector.toString());

                p_convertConsumer.accept(polarVector.toString());
            });
        }
    }

    private static class PolarToAxial extends JPanel {
        public PolarToAxial(final Consumer<String> p_convertConsumer) {
            setLayout(new GridBagLayout());
            final GridBagConstraints gridBagConstraints = new GridBagConstraints();
            gridBagConstraints.anchor = GridBagConstraints.NORTH;

            final JPanel inputPanel = new JPanel();
            final JPanel submitPanel = new JPanel();

            final JTextField textFieldMagnitude = new JTextField(3);
            final JTextField textFieldUnit = new JTextField(3);
            final JTextField textFieldAngle = new JTextField(3);
            final JTextField textFieldDirection = new JTextField(10);

            inputPanel.add(textFieldMagnitude);
            inputPanel.add(new JLabel(" "));
            inputPanel.add(textFieldUnit);
            inputPanel.add(new JLabel(" @ "));
            inputPanel.add(textFieldAngle);
            inputPanel.add(new JLabel(" degrees "));
            inputPanel.add(textFieldDirection);

            final JButton submitButton = new JButton("Convert");
            final JLabel convertedLabel = new JLabel();

            submitPanel.add(submitButton);
            submitPanel.add(convertedLabel);

            gridBagConstraints.gridx = 0;
            gridBagConstraints.gridy = 0;

            add(inputPanel, gridBagConstraints);

            gridBagConstraints.gridy = 1;

            add(submitPanel, gridBagConstraints);

            submitButton.addActionListener(e -> {
                if (textFieldMagnitude.getText().isEmpty() || textFieldUnit.getText().isEmpty() || textFieldAngle.getText().isEmpty() || textFieldDirection.getText().isEmpty()) {
                    convertedLabel.setText("Enter all values");
                    return;
                }

                final double magnitude = Double.parseDouble(textFieldMagnitude.getText());
                final double angle = Double.parseDouble(textFieldAngle.getText());
                final String unit = textFieldUnit.getText();
                final String direction = textFieldDirection.getText();

                final PolarVector polarVector = new PolarVector(magnitude, unit, angle, direction);
                final AxialVector axialVector = polarVector.toAxial();

                convertedLabel.setText(axialVector.toString());

                p_convertConsumer.accept(axialVector.toString());
            });
        }
    }
}

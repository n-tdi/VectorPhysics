package world.ntdi.ui.components;

import world.ntdi.math.SpeedDistanceTime;

import javax.swing.*;
import java.awt.*;

public class AverageInput extends JPanel {
    public AverageInput() {
        super(new FlowLayout());

        final NPlaceholderTextField speedInput = new NPlaceholderTextField(5);
        speedInput.setPlaceholder("speed");

        final JLabel equalsLabel = new JLabel("=");
        final NPlaceholderTextField distanceInput = new NPlaceholderTextField(5);
        distanceInput.setPlaceholder("distance");

        final JLabel divideLabel = new JLabel("/");
        final NPlaceholderTextField timeInput = new NPlaceholderTextField(5);
        timeInput.setPlaceholder("time");

        final JButton solveButton = new JButton("Solve");

        add(speedInput);
        add(equalsLabel);
        add(distanceInput);
        add(divideLabel);
        add(timeInput);
        add(new JSeparator());
        add(solveButton);

        solveButton.addActionListener(e -> {
            if (speedInput.getText().isEmpty() && distanceInput.getText().isEmpty() && timeInput.getText().isEmpty()) {
                return;
            }

            final String speedInputText = speedInput.getText();
            final String distanceInputText = distanceInput.getText();
            final String timeInputText = timeInput.getText();

            final Double speed;
            Double speed1;
            try {
                speed1 = Double.parseDouble(speedInputText);
            } catch (NumberFormatException p_numberFormatException) {
                speed1 = null;
            }
            speed = speed1;

            final Double distance;
            Double distance1;
            try {
                distance1 = Double.parseDouble(distanceInputText);
            } catch (NumberFormatException p_numberFormatException) {
                distance1 = null;
            }
            distance = distance1;


            final Double time;
            Double time1;

            try {
                time1 = Double.parseDouble(timeInputText);
            } catch (NumberFormatException p_numberFormatException) {
                time1 = null;
            }
            time = time1;


            final SpeedDistanceTime speedDistanceTime = new SpeedDistanceTime(speed, distance, time);
            speedDistanceTime.solveForMissingValue();

            speedInput.setText(String.valueOf(speedDistanceTime.getSpeed()));
            distanceInput.setText(String.valueOf(speedDistanceTime.getDistance()));
            timeInput.setText(String.valueOf(speedDistanceTime.getTime()));
        });
    }
}

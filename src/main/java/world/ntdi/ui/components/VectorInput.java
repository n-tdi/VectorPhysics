package world.ntdi.ui.components;

import world.ntdi.math.PolarVector;

import javax.swing.*;
import java.awt.*;

public class VectorInput extends JPanel {
    private final JTextField m_textFieldMagnitude;
    private final JTextField m_textFieldUnit;
    private final JTextField m_textFieldAngle;
    private final JTextField m_textFieldDirection;

    public VectorInput() {
        setLayout(new FlowLayout());

        m_textFieldMagnitude = new JTextField(3);
        m_textFieldUnit = new JTextField(3);
        m_textFieldAngle = new JTextField(3);
        m_textFieldDirection = new JTextField(10);

        add(m_textFieldMagnitude);
        add(new JLabel(" "));
        add(m_textFieldUnit);
        add(new JLabel(" @ "));
        add(m_textFieldAngle);
        add(new JLabel(" degrees "));
        add(m_textFieldDirection);
    }

    public PolarVector getVector() {
        if (m_textFieldMagnitude.getText().isEmpty() || m_textFieldUnit.getText().isEmpty() || m_textFieldAngle.getText().isEmpty() || m_textFieldDirection.getText().isEmpty()) {
            return null;
        }

        final double magnitude = Double.parseDouble(m_textFieldMagnitude.getText());
        final double angle = Double.parseDouble(m_textFieldAngle.getText());
        final String unit = m_textFieldUnit.getText();
        final String direction = m_textFieldDirection.getText();

        return new PolarVector(magnitude, unit, angle, direction);
    }
}

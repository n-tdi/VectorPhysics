package world.ntdi.ui.components;

import world.ntdi.step.Step;

import javax.swing.*;
import java.awt.*;

public class StepOutput extends JPanel {

        private final JTextArea m_stepTextArea;

        public StepOutput() {
            super(new GridBagLayout());
            final GridBagConstraints gridBagConstraints = new GridBagConstraints();
            gridBagConstraints.gridx = 0;

            gridBagConstraints.gridy = 0;
            gridBagConstraints.gridwidth = 2;
            gridBagConstraints.fill = GridBagConstraints.BOTH;

            m_stepTextArea = new JTextArea(10, 30);
            m_stepTextArea.setEditable(false);

            JScrollPane stepScrollPane = new JScrollPane(m_stepTextArea);

            add(stepScrollPane, gridBagConstraints);
        }

        public void addSteps(final String p_result) {
            m_stepTextArea.setText("");

            final Step step = Step.getInstance();

            step.addStep("Our result: " + p_result);

            step.getStepList().stream().map(p_s -> p_s + "\n").forEach(m_stepTextArea::append);
        }
    }
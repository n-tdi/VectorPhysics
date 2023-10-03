package world.ntdi.step;

import java.util.ArrayList;
import java.util.List;

public class Step {
    private static Step instance;
    public static Step getInstance() {
        if (instance == null) {
            instance = new Step();
        }
        return instance;
    }

    private final List<String> m_stepList;

    private Step() {
        m_stepList = new ArrayList<>();
    }

    public void addStep(final String p_step) {
        final int currentStepNum = m_stepList.size() + 1;
        final String formattedStep = currentStepNum + ". " + p_step;

        m_stepList.add(formattedStep);
        System.out.println(formattedStep);
    }
}

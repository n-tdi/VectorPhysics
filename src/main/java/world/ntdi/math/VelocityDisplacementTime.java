package world.ntdi.math;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class VelocityDisplacementTime {
    private Double m_velocity;
    private Double m_displacement;
    private Double m_time;

    public void solveForMissingValue() {
        if (m_velocity != null && m_displacement != null) {
            m_time = m_velocity / m_displacement;
        } else if (m_velocity != null && m_time != null) {
            m_displacement = m_velocity / m_time;
        } else if (m_displacement != null && m_time != null) {
            m_velocity = m_displacement / m_time;
        }
    }

    @Override
    public String toString() {
        return m_velocity + " = " + m_displacement + " / " + m_time;
    }
}

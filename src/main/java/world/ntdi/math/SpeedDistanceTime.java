package world.ntdi.math;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class SpeedDistanceTime {
    private Double m_speed;
    private Double m_distance;
    private Double m_time;

    public void solveForMissingValue() {
        if (m_speed != null && m_distance != null) {
            m_time = m_distance / m_speed;
        } else if (m_speed != null && m_time != null) {
            m_distance = m_speed * m_time;
        } else if (m_distance != null && m_time != null) {
            m_speed = m_distance / m_time;
        }
    }

    @Override
    public String toString() {
        return m_speed + " = " + m_distance + " / " + m_time;
    }
}

package world.ntdi.math;

public class ComplexNumber {
    private double m_real;
    private double m_imaginary;

    public ComplexNumber(final double p_real, final double p_imaginary) {
        m_real = p_real;
        m_imaginary = p_imaginary;
    }

    public String toString() {
        return m_real + " " + m_imaginary + "i";
    }

    public double getReal() {
        return m_real;
    }

    public double getImaginary() {
        return m_imaginary;
    }


}

package world.ntdi.ui.components;

import javax.swing.*;
import javax.swing.text.Document;
import java.awt.*;

@SuppressWarnings("serial")
public class NPlaceholderTextField extends JTextField {
    private String placeholder;

    public NPlaceholderTextField() {
    }

    public NPlaceholderTextField(final Document p_doc, final String p_text, final int p_columns) {
        super(p_doc, p_text, p_columns);
    }

    public NPlaceholderTextField(final int p_columns) {
        super(p_columns);
    }

    public NPlaceholderTextField(final String p_text) {
        super(p_text);
    }

    public NPlaceholderTextField(final String p_text, final int p_columns) {
        super(p_text, p_columns);
    }

    public String getPlaceholder() {
        return placeholder;
    }

    @Override
    protected void paintComponent(final Graphics p_graphics) {
        super.paintComponent(p_graphics);

        if (placeholder == null || placeholder.length() == 0 || getText().length() > 0) {
            return;
        }

        final Graphics2D g = (Graphics2D) p_graphics;
        g.setRenderingHint(
            RenderingHints.KEY_ANTIALIASING,
            RenderingHints.VALUE_ANTIALIAS_ON);
        g.setColor(getDisabledTextColor());
        g.drawString(placeholder, getInsets().left, p_graphics.getFontMetrics()
            .getMaxAscent() + getInsets().top);
    }

    public void setPlaceholder(final String s) {
        placeholder = s;
    }

}
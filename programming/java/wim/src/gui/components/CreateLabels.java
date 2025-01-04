package gui.components;

import javax.swing.*;
import java.awt.*;

public class CreateLabels extends JPanel implements Scrollable {

    public CreateLabels(String text) {
        setLayout(new GridBagLayout());
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;

        System.out.println(text);
        String[] textArr = text.split("\n");

        for(String textLine : textArr) {
            JLabel label = new JLabel(textLine, SwingConstants.LEFT);
            add(label, gridBagConstraints);
            gridBagConstraints.gridy++;
        }
    }

    @Override
    public Dimension getPreferredScrollableViewportSize() {
        return new Dimension(100, 50);
    }

    @Override
    public int getScrollableUnitIncrement(Rectangle visibleRect, int orientation, int direction) {
        return 32;
    }

    @Override
    public int getScrollableBlockIncrement(Rectangle visibleRect, int orientation, int direction) {
        return 32;
    }

    @Override
    public boolean getScrollableTracksViewportWidth() {
        return getPreferredSize().width <= getWidth();
    }

    @Override
    public boolean getScrollableTracksViewportHeight() {
        return false;
    }

}
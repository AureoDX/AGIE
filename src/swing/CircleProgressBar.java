package swing;

import java.awt.Color;
import javax.swing.JProgressBar;

public class CircleProgressBar extends JProgressBar {

    public CircleProgressBar() {
        setOpaque(false);
        setBackground(new Color(220, 220, 220));
        setForeground(new Color(0,120,215));
        setStringPainted(true);
        setUI(new ProgressCircleUI(this));
    }

}

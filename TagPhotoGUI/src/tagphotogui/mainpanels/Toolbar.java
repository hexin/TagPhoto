package tagphotogui.mainpanels;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JPanel;

/**
 * @author Paweł Cińcio
 */
public class Toolbar extends JPanel {

    private JPanel leftUp, left, leftDown, up, down, right;
    private Toolbox toolbox;

    public Toolbar() {
        this.setLayout(new BorderLayout());
        preparePanels();

        leftDown.setBackground(Color.BLUE);
        leftUp.setBackground(Color.BLUE);
    }

    private void preparePanels() {
        // At first up and down edges.
        up = new JPanel();
        up.setLayout(new BorderLayout());
        this.add(up, BorderLayout.NORTH);

        down = new JPanel();
        down.setLayout(new BorderLayout());
        this.add(down, BorderLayout.SOUTH);

        // Add left corners to them
        leftUp = new JPanel();
        up.add(leftUp, BorderLayout.WEST);

        leftDown = new JPanel();
        down.add(leftDown, BorderLayout.WEST);

        // Left and right side.
        left = new JPanel();
        this.add(left, BorderLayout.WEST);

        right = new JPanel();
        this.add(right, BorderLayout.EAST);

        toolbox = new Toolbox();
        this.add(toolbox, BorderLayout.CENTER);
    }
}

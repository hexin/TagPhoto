package tagphotogui.mainpanels;

import com.sun.corba.se.spi.orbutil.fsm.Input;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import org.xml.sax.InputSource;

/**
 * @author Paweł Cińcio
 */
public class Toolbar extends JPanel {

    private JPanel leftUp, left, leftDown, up, down, right;
    private Toolbox toolbox;
    private int margin;

    private class LeftUp extends JPanel {

    }

    public Toolbar() {
        this.setLayout(new BorderLayout());
        preparePanels();
        margin = 45;

        leftDown.setBackground(Color.BLUE);
        leftUp.setBackground(Color.BLUE);
    }

    private void preparePanels() {
        Dimension dim = new Dimension(margin, margin);
        URL url = getClass().getResource("small-smile.gif");
        ImageIcon icon = new ImageIcon(url);

        // At first up and down edges.
        up = new JPanel();
        up.setLayout(new BorderLayout());
        this.add(up, BorderLayout.NORTH);

        down = new JPanel();
        down.setLayout(new BorderLayout());
        this.add(down, BorderLayout.SOUTH);

        // Add left corners to them
        leftUp = new JPanel();
        leftUp.add(new JLabel(icon));
        leftUp.setSize(margin, margin);
        up.add(leftUp, BorderLayout.WEST);

        leftDown = new JPanel();
        leftDown.setSize(margin, margin);
        down.add(leftDown, BorderLayout.WEST);

        // Left and right side.
        left = new JPanel();
        this.add(left, BorderLayout.WEST);

        right = new JPanel();
        this.add(right, BorderLayout.EAST);

        toolbox = new Toolbox();
        toolbox.add(new JLabel(icon));
        this.add(toolbox, BorderLayout.CENTER);
    }
}

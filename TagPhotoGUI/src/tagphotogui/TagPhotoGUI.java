package tagphotogui;

import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author Paweł Cińcio
 */
public class TagPhotoGUI {


    public static void main(String[] args) {
        JFrame mainFrame = new JFrame("TagPhoto");
        mainFrame.setBounds(200, 200, 300, 200);
        JLabel label = new JLabel("Puste okno...");
        mainFrame.add(label);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setVisible(true);
    }
}

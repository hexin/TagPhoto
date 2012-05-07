package tagphotogui;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;
import tagphotogui.mainpanels.Drawboard;
import tagphotogui.mainpanels.Lowerbar;
import tagphotogui.mainpanels.Toolbar;
import tagphotogui.mainpanels.Upperbar;

/**
 * @author Paweł Cińcio
 */
public class TagPhotoGUI {

    private static TagPhotoGUI gui;

    // Basic sizes of the GUI (minimal sizes!).
    static final int MARGIN = 10;
    static final int TOOLBAR_WIDTH = 110;
    static final int DRAWBOARD_WIDTH = 300;
    static final int DRAWBOARD_HEIGHT = 200;
    static final int UPPERBAR_HEIGHT = 50;
    static final int LOWERBAR_HEIGHT = 100;

    // Main components of the window.
    private JFrame mainFrame;
    private Toolbar toolbar;
    private Lowerbar lowerbar;
    private Upperbar upperbar;
    private Drawboard drawboard;

    public static void main(String[] args) {
        gui = new TagPhotoGUI();
        gui.setMainFrame();
    }

    private void setMainFrame() {
        mainFrame = new JFrame("TagPhoto");
        Toolkit theKit = mainFrame.getToolkit();
        mainFrame.setLayout(new MainLayout());
        Dimension size = mainFrame.getLayout().minimumLayoutSize(mainFrame);
        Dimension wndSize = theKit.getScreenSize();
        mainFrame.setBounds(wndSize.width / 4, wndSize.height / 4,
                size.width, size.height);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // The order of adding this components is very important.
        // If you chnage it, you should change MainLayout.
        toolbar = new Toolbar();
        mainFrame.add(toolbar);
        upperbar = new Upperbar();
        mainFrame.add(upperbar);
        drawboard = new Drawboard();
        mainFrame.add(drawboard);
        lowerbar = new Lowerbar();
        mainFrame.add(lowerbar);
        // Do this when the window is ready.
        mainFrame.setVisible(true);
    }
}

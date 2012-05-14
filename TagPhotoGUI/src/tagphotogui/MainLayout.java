package tagphotogui;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.LayoutManager;

/**
 * @author Paweł Cińcio
 */
public class MainLayout implements LayoutManager {

    private Dimension minimalDimension;
    private int minimalHeight;
    private int minimalWidth;
    private int margin;
    private Component toolbar;
    private Component lowerbar;
    private Component upperbar;
    private Component drawboard;
    private int toolbarWidth, width, height;
    private Dimension frameDimension;

    public MainLayout() {
        margin = TagPhotoGUI.MARGIN;
        minimalWidth = 4 * margin+
                TagPhotoGUI.TOOLBAR_WIDTH + TagPhotoGUI.DRAWBOARD_WIDTH;
        minimalHeight = 4 * margin + TagPhotoGUI.UPPERBAR_HEIGHT +
                TagPhotoGUI.DRAWBOARD_HEIGHT +TagPhotoGUI.LOWERBAR_HEIGHT;
        minimalDimension = new Dimension(minimalWidth, minimalHeight);
    }

    @Override
    public void addLayoutComponent(String name, Component comp) {
        // Useless
    }

    @Override
    public void removeLayoutComponent(Component comp) {
        // Useless
    }

    @Override
    public Dimension preferredLayoutSize(Container parent) {
        return minimalDimension;
    }

    @Override
    public Dimension minimumLayoutSize(Container parent) {
        return minimalDimension;
    }

    @Override
    public void layoutContainer(Container parent) {
        // The order: toolbar, upperbar, drawboard, lowerbar.
        if (toolbar == null) toolbar = parent.getComponent(0);
        if (upperbar == null) upperbar = parent.getComponent(1);
        if (drawboard == null) drawboard = parent.getComponent(2);
        if (lowerbar == null) lowerbar = parent.getComponent(3);

        frameDimension = parent.getSize();
        toolbarWidth = 2 * margin + TagPhotoGUI.TOOLBAR_WIDTH;

        if (frameDimension.width < minimalWidth) {
            width = minimalWidth - toolbarWidth;
        }
        else {
            width = frameDimension.width - toolbarWidth;
        }

        if (frameDimension.height < minimalHeight) {
            height = minimalHeight - TagPhotoGUI.UPPERBAR_HEIGHT -
                    TagPhotoGUI.LOWERBAR_HEIGHT;
        }
        else {
            height = frameDimension.height - TagPhotoGUI.UPPERBAR_HEIGHT -
                    TagPhotoGUI.LOWERBAR_HEIGHT;
        }

        toolbar.setBounds(0, 0, toolbarWidth, TagPhotoGUI.UPPERBAR_HEIGHT +
                    TagPhotoGUI.LOWERBAR_HEIGHT + height);
        upperbar.setBounds(toolbarWidth, 0, width, TagPhotoGUI.UPPERBAR_HEIGHT);
        drawboard.setBounds(toolbarWidth, TagPhotoGUI.UPPERBAR_HEIGHT,
                width, height);
        lowerbar.setBounds(toolbarWidth, TagPhotoGUI.UPPERBAR_HEIGHT + height,
                width, TagPhotoGUI.LOWERBAR_HEIGHT);
    }

}

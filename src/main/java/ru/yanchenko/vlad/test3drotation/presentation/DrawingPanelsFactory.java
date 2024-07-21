package ru.yanchenko.vlad.test3drotation.presentation;

import javax.swing.*;

/**
 * Defines and retrieves JPanels for drawing.
 */
public class DrawingPanelsFactory {
    private final JPanel cubeDrawingPanel;
    private final JPanel ballsDrawingPanel;

    /**
     * Public constructor. Sets params and creates an instance.
     *
     * @param ballsDrawingPanel to draw graphic model on
     * @param cubeDrawingPanel  to draw graphic model on
     */
    public DrawingPanelsFactory(JPanel ballsDrawingPanel, JPanel cubeDrawingPanel) {
        this.ballsDrawingPanel = ballsDrawingPanel;
        this.cubeDrawingPanel = cubeDrawingPanel;
    }

    /**
     * Define a JPanel to draw graphics on
     *
     * @param drawingType to define what kind of JPanel to use
     * @return JPanel to draw graphics on
     */
    public JPanel getDrawingPanel(DrawingType drawingType) {
        switch (drawingType) {
            case RIBBED_CUBE:
                return cubeDrawingPanel;
            case BALLS_IN_CUBE:
            case BALLS_ON_CUBE:
            case BALLS_IN_SPHERE:
            case BALLS_ON_SPHERE:
                return ballsDrawingPanel;
            default:
                throw new IllegalArgumentException("Invalid drawing type: " + drawingType);
        }
    }
}

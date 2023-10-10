package ru.yanchenko.vlad.test3drotation.listeners;

import java.awt.*;

/**
 * Callback for some mouse event.
 */
public interface MouseDraggedEventCallback {

    /**
     * @param mouseEvent mouse's offset from a previous position
     */
    void getMouseDelta(Point point);
}
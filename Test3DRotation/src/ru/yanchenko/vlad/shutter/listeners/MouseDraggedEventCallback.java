package ru.yanchenko.vlad.shutter.listeners;

import java.awt.*;
import java.awt.event.MouseEvent;

/**
 * Callback for some mouse event.
 */
public interface MouseDraggedEventCallback {

    /**
     * @param mouseEvent mouse's offset from a previous position
     */
    void getMouseDelta(Point point);
}

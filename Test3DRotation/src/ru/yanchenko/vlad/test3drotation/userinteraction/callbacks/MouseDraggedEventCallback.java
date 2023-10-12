package ru.yanchenko.vlad.test3drotation.userinteraction.callbacks;

import java.awt.*;

/**
 * Callback for some mouse event.
 */
public interface MouseDraggedEventCallback {

    /**
     * @param point mouse's offset from a previous position
     */
    void rotateByXAndY(Point point);
}

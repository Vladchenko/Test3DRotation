package ru.yanchenko.vlad.test3drotation.userinteraction.callbacks;

import java.awt.event.KeyEvent;

/**
 * Callback for a keyboard pressed key.
 */
public interface KeyEventCallback {

    /**
     * @param keyEvent some event of a keyboard button (pressed/typed/released)
     */
    void getKeyEvent(KeyEvent keyEvent);
}

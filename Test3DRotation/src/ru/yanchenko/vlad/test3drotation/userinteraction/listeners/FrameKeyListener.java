package ru.yanchenko.vlad.test3drotation.userinteraction.listeners;

import ru.yanchenko.vlad.test3drotation.userinteraction.callbacks.KeyEventCallback;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Keyboard buttons typing listener for a JFrame that graphics to be drawn on.
 */
public class FrameKeyListener implements KeyListener {

    private final KeyEventCallback callback;

    /**
     * Public constructor. Sets params and creates an instance.
     *
     * @param keyEventCallback of a keyboard buttons typing events
     */
    public FrameKeyListener(KeyEventCallback keyEventCallback) {
        this.callback = keyEventCallback;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // Not used
    }

    @Override
    public void keyPressed(KeyEvent e) {
        callback.getKeyEvent(e);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // Not used
    }

}

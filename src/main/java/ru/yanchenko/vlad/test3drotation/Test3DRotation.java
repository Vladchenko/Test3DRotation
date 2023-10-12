package ru.yanchenko.vlad.test3drotation;

import ru.yanchenko.vlad.test3drotation.di.DaggerTest3DRotationComponent;
import ru.yanchenko.vlad.test3drotation.di.Test3DRotationComponent;

/**
 * Entry point for an application
 */
public class Test3DRotation {

    public static void main(String[] args) {
        Test3DRotationComponent daggerComponent = DaggerTest3DRotationComponent.create();
        daggerComponent.getKeyboardInteractionProcessor();
        daggerComponent.getMouseInteractionProcessor();
    }
}

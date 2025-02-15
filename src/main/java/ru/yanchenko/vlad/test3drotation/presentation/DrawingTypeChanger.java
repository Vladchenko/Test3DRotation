package ru.yanchenko.vlad.test3drotation.presentation;

import static ru.yanchenko.vlad.test3drotation.presentation.DrawingType.*;

/**
 * Changes a type of content to be drawn present in DrawingType.
 */
public class DrawingTypeChanger {

    private DrawingType drawingType = RIBBED_CUBE;

    /**
     * Change drawing type. It is changed in loop.
     */
    public void changeDrawingType() {
        switch (drawingType) {
            case RIBBED_CUBE:
                drawingType = BALLS_IN_CUBE;
                break;
            case BALLS_IN_CUBE:
                drawingType = BALLS_ON_CUBE;
                break;
            case BALLS_ON_CUBE:
                drawingType = BALLS_IN_SPHERE;
                break;
            case BALLS_IN_SPHERE:
                drawingType = BALLS_ON_SPHERE;
                break;
            case BALLS_ON_SPHERE:
                drawingType = BALLS_IN_ORDERED_SPHERE;
                break;
            case BALLS_IN_ORDERED_SPHERE:
                drawingType = RIBBED_CUBE;
                break;
        }
    }

    public DrawingType getDrawingType() {
        return drawingType;
    }
}

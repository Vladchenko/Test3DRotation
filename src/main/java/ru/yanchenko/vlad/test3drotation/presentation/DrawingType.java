package ru.yanchenko.vlad.test3drotation.presentation;

/**
 * Defines type of drawing
 */
public enum DrawingType {
    /**
     * Draw scattered balls (colored points) within cube
     */
    BALLS_IN_CUBE,
    /**
     * Draw scattered balls (colored points) on each surface of a cube
     */
    BALLS_ON_CUBE,
    /**
     * Draw scattered balls (colored points) within a sphere
     */
    BALLS_IN_SPHERE,
    /**
     * Draw scattered balls (colored points) on a surface of a sphere
     */
    BALLS_ON_SPHERE,
    /**
     * Draw scattered balls in orderly fashion on a surface of a sphere
     */
    BALLS_IN_ORDERED_SPHERE,
    /**
     * Draw lines(ribs) that make up a cube
     */
    RIBBED_CUBE,
}

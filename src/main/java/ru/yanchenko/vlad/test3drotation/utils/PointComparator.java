package ru.yanchenko.vlad.test3drotation.utils;

import ru.yanchenko.vlad.test3drotation.data.ColoredPoint;

import java.util.Comparator;

/**
 * Compares two instances of {@link ColoredPoint}
 */
public class PointComparator implements Comparator<ColoredPoint> {

    @Override
    public int compare(ColoredPoint point1, ColoredPoint point2) {
        double z1 = point1.getDekartPoint().getZ();
        double z2 = point2.getDekartPoint().getZ();

        // Handle the case where Z-ordinates are equal.
        return Double.compare(z1, z2);
    }
}

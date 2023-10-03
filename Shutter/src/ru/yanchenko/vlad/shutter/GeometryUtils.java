package ru.yanchenko.vlad.shutter;

import ru.yanchenko.vlad.shutter.data.DekartPoint;
import ru.yanchenko.vlad.shutter.data.SphericalPoint;

/**
 * TODO
 */
public class GeometryUtils {

    /**
     * TODO
     * @param sphericalPoint
     * @return
     */
    public static DekartPoint convertToDekart(SphericalPoint sphericalPoint) {
        return new DekartPoint(
                sphericalPoint.getRadius() * Math.sin(sphericalPoint.getTheta()) * Math.sin(sphericalPoint.getPhi()),
                sphericalPoint.getRadius() * Math.sin(sphericalPoint.getTheta()) * Math.cos(sphericalPoint.getPhi()),
                sphericalPoint.getRadius() * Math.cos(sphericalPoint.getTheta())
        );
    }

    /**
     * TODO
     * @param dekartPoint
     * @return
     */
    public static SphericalPoint convertToSpherical(DekartPoint dekartPoint) {
        double radius = Math.sqrt(dekartPoint.getX() * dekartPoint.getX()
                + dekartPoint.getY() * dekartPoint.getY()
                + dekartPoint.getZ() * dekartPoint.getZ());
        return new SphericalPoint(
                radius,
                Math.acos(dekartPoint.getZ() / radius),
                Math.atan(dekartPoint.getX() / dekartPoint.getY())
        );
    }
}

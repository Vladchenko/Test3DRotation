package ru.yanchenko.vlad.shutter.generics;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by v.yanchenko on 26.06.2016.
 */
public class ExtDots {

    private int radiusInitial = 200;
    private int radius = radiusInitial;
    private double step = 0.002;

    private List<ExtDot> extDots1 = new ArrayList<ExtDot>();
    private List<ExtDot> extDots2 = new ArrayList<ExtDot>();
    private List<ExtDot> extDots3 = new ArrayList<ExtDot>();
    private List<ExtDot> extDots4 = new ArrayList<ExtDot>();

    public ExtDots(int number) {
        populateExtDots(number);
    }

    public void populateExtDots(int number) {
        for (int i = 0; i < number; i++) {
            extDots1.add(new ExtDot());
            extDots2.add(new ExtDot());
            extDots3.add(new ExtDot());
            extDots4.add(new ExtDot());
        }
    }

    public void placeExtDots(int initialX, int initialY) {
        double angle = (2 * Math.PI) / extDots1.size();
        for (int i = 0; i < extDots1.size(); i++) {
            extDots1.get(i).setAngle(angle * i);
            extDots1.get(i).setRadius(radiusInitial);
            extDots1.get(i).setX(
                    initialX
                            + Math.cos(extDots1.get(i).getAngle())
                            * extDots1.get(i).getRadius()
            );
            extDots1.get(i).setY(
                    initialY
                            - Math.sin(extDots1.get(i).getAngle())
                            * extDots1.get(i).getRadius()
            );
            extDots2.get(i).setAngle(angle * i);
            extDots2.get(i).setRadius(radiusInitial * 1.3);
            extDots2.get(i).setX(
                    initialX
                            + Math.cos(extDots2.get(i).getAngle())
                            * extDots2.get(i).getRadius()
            );
            extDots2.get(i).setY(
                    initialY
                            - Math.sin(extDots2.get(i).getAngle())
                            * extDots2.get(i).getRadius()
            );
            extDots3.get(i).setAngle(angle * i);
            extDots3.get(i).setRadius(radiusInitial * 1.6);
            extDots3.get(i).setX(
                    initialX
                            + Math.cos(getExtDots3().get(i).getAngle())
                            * getExtDots3().get(i).getRadius()
            );
            extDots3.get(i).setY(
                    initialY
                            - Math.sin(getExtDots3().get(i).getAngle())
                            * getExtDots3().get(i).getRadius()
            );
            extDots4.get(i).setAngle(angle * i);
            extDots4.get(i).setRadius(radiusInitial * 1.9);
            extDots4.get(i).setX(
                    initialX
                            + Math.cos(getExtDots3().get(i).getAngle())
                            * getExtDots3().get(i).getRadius()
            );
            extDots4.get(i).setY(
                    initialY
                            - Math.sin(getExtDots3().get(i).getAngle())
                            * getExtDots3().get(i).getRadius()
            );
        }
    }

    public void moveExtDots(int initialX, int initialY) {
        double stepRadiusCurrent = 0;
        for (int i = 0; i < extDots1.size(); i++) {
            extDots1.get(i).setX(
                    initialX
                            + Math.cos(extDots1.get(i).getAngle())
                            * extDots1.get(i).getRadius());
            extDots1.get(i).setY(
                    initialY
                            - Math.sin(extDots1.get(i).getAngle())
                            * extDots1.get(i).getRadius());
            extDots2.get(i).setX(
                    initialX
                            + Math.cos(extDots2.get(i).getAngle())
                            * extDots2.get(i).getRadius());
            extDots2.get(i).setY(
                    initialY
                            - Math.sin(extDots2.get(i).getAngle())
                            * extDots2.get(i).getRadius());
            extDots3.get(i).setX(
                    initialX
                            + Math.cos(extDots3.get(i).getAngle())
                            * extDots3.get(i).getRadius());
            extDots3.get(i).setY(
                    initialY
                            - Math.sin(extDots3.get(i).getAngle())
                            * extDots3.get(i).getRadius());
            extDots4.get(i).setX(
                    initialX
                            + Math.cos(extDots4.get(i).getAngle())
                            * extDots4.get(i).getRadius());
            extDots4.get(i).setY(
                    initialY
                            - Math.sin(extDots4.get(i).getAngle())
                            * extDots4.get(i).getRadius());
            extDots1.get(i).setAngle(
                    extDots1.get(i).getAngle() + step
            );
            extDots2.get(i).setAngle(
                    extDots2.get(i).getAngle() - step
            );
            extDots3.get(i).setAngle(
                    extDots3.get(i).getAngle() + step
            );
            extDots4.get(i).setAngle(
                    extDots4.get(i).getAngle() - step
            );
        }
    }

    public List<ExtDot> getExtDots2() {
        return extDots2;
    }

    public void setExtDots2(List<ExtDot> extDots2) {
        this.extDots2 = extDots2;
    }

    public List<ExtDot> getExtDots1() {
        return extDots1;
    }

    public void setExtDots1(List<ExtDot> extDots1) {
        this.extDots1 = extDots1;
    }

    public List<ExtDot> getExtDots3() {
        return extDots3;
    }

    public void setExtDots3(List<ExtDot> extDots3) {
        this.extDots3 = extDots3;
    }

    public List<ExtDot> getExtDots4() {
        return extDots4;
    }

    public void setExtDots4(List<ExtDot> extDots4) {
        this.extDots4 = extDots4;
    }
}

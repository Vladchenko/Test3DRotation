package ru.yanchenko.vlad.shutter;

import ru.yanchenko.vlad.shutter.data.SphericalPoint;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import javax.swing.Timer;

import static ru.yanchenko.vlad.shutter.GeometryUtils.convertToDekart;
import static ru.yanchenko.vlad.shutter.GeometryUtils.convertToSpherical;

//** This class is in charge of a logic of a program */
public class Logic {

    private static Repository oRepository;


    /**
     * Constructor is done private, for it could not be instantiated anywhere
     * besides "getInstance" method.
     */
    private Logic() {
        oRepository.setTmrRendering(tmrRendering());
        oRepository.getTmrRendering().start();
    }


    public static synchronized Logic getInstance(Repository Repository_) {
        oRepository = Repository_;
        if (Repository_.getoLogic() == null) {
            Repository_.setoLogic(new Logic());
        }
        return Repository_.getoLogic();
    }

    /**
     * Timer that runs the basic logic for a program.
     *
     * @return
     */
    private Timer tmrRendering() {

        class TimerImpl implements ActionListener {

            @Override
            public void actionPerformed(ActionEvent e) {

                //** Recording a time when a computations for each frame begin
                oRepository.setEndTime((new Date()).getTime());

                /**
                 * Put here a code done for each frame to be drawn in
                 * paintComponent (on a screen).
                 */
                oRepository.getExtDots().moveExtDots(
                        oRepository.getPntScreenCenter().x,
                        oRepository.getPntScreenCenter().y);
                //** Repainting a screen
                oRepository.getoDrawing().repaint();

                //** Increasing frames count in 1.
                oRepository.setFps(oRepository.getFps() + 1);
                if ((oRepository.getEndTime() - oRepository.getBeginTime())
                        >= oRepository.getFpsUpdateTimeOut()) {
                    //** Recording a time when a computations for each frame end
                    oRepository.setBeginTime((new Date()).getTime());
                    //** Such a calculation is required due to a variative fps measurement time
                    oRepository.getLblFPS().setText("FPS: " + oRepository.getFps()
                            * (1000 / oRepository.getFpsUpdateTimeOut()));
                    oRepository.setFps(0);
                }
            }
        }

        return new Timer(0, new TimerImpl());
    }

    /**
     * Rotates a points over z axis for angle.
     * Angle can be negative.
     */
    public void rotateByZ(double angle) {
        SphericalPoint sphericalPoint;
        for(int i =0; i < oRepository.getPoints().length; i++) {
            sphericalPoint = convertToSpherical(oRepository.getPoints()[i]);
            sphericalPoint.setPhi(sphericalPoint.getPhi() + angle);
//            if (sphericalPoint.getPhi() > Math.PI / 2) {
//                oRepository.inversionMultiplier *= -1;
//            }
//            if (sphericalPoint.getPhi() < -Math.PI / 2) {
//                oRepository.inversionMultiplier *= -1;
//            }
            System.out.println(sphericalPoint.getPhi() / 3.1415926 * 180);
            oRepository.getPoints()[i] = convertToDekart(sphericalPoint);
        }
    }

}

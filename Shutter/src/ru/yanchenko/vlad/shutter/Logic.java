package ru.yanchenko.vlad.shutter;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

//** This class is in charge of a logic of a program */
public class Logic {

    private static Repository repository;

    /**
     * Constructor is done private, for it could not be instantiated anywhere
     * besides "getInstance" method.
     */
    private Logic() {
        repository.setTmrRendering(tmrRendering());
        repository.getTmrRendering().start();
    }

    public static synchronized Logic getInstance(Repository Repository_) {
        repository = Repository_;
        if (Repository_.getoLogic() == null) {
            Repository_.setoLogic(new Logic());
        }
        return Repository_.getoLogic();
    }

    /** @return Timer that runs the basic logic for a program. */
    private Timer tmrRendering() {

        class TimerImpl implements ActionListener {

            @Override
            public void actionPerformed(ActionEvent e) {

                //* Put here a code done for each frame to be drawn in paintComponent (on a screen).

                //** Recording a time when a computations for each frame begin
                repository.setEndTime((new Date()).getTime());

                repository.getExtDots().moveExtDots(
                        repository.getPntScreenCenter().x,
                        repository.getPntScreenCenter().y);
                //* Repainting a screen
                repository.getDrawing().repaint();

                //* Increasing frames count in 1.
                repository.setFps(repository.getFps() + 1);
                if ((repository.getEndTime() - repository.getBeginTime())
                        >= repository.getFpsUpdateTimeOut()) {
                    //* Recording a time when a computations for each frame end
                    repository.setBeginTime((new Date()).getTime());
                    //* Such a calculation is required due to a variative fps measurement time
                    repository.getLblFPS().setText("FPS: " + repository.getFps()
                            * (1000 / repository.getFpsUpdateTimeOut()));
                    repository.setFps(0);
                }
            }
        }

        return new Timer(0, new TimerImpl());
    }

}

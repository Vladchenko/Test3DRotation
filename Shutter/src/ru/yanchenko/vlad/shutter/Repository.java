package ru.yanchenko.vlad.shutter;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;
import java.io.File;
import java.util.Date;
import javax.swing.Timer;
import javax.swing.JFrame;
import javax.swing.JLabel;

import ru.yanchenko.vlad.shutter.data.DekartPoint;
import ru.yanchenko.vlad.shutter.generics.ExtDots;
import ru.yanchenko.vlad.shutter.listeners.FrameKeyListener;
import ru.yanchenko.vlad.shutter.listeners.FrameMouseListener;
import ru.yanchenko.vlad.shutter.listeners.FrameMouseMotionListener;
import ru.yanchenko.vlad.shutter.listeners.FrameMouseWheelListener;

public class Repository {

    //<editor-fold defaultstate="collapsed" desc="System related fields">
//** Trigger used to check if an Alt key is pressed.
    private boolean keyAlt = false;
    //** Trigger used to check if a Ctrl key is pressed.
    private boolean keyCtrl = false;
    //** Trigger used to check if an Shift key is pressed.
    private boolean keyShift = false;
    //** Trigger used to check if a full screen is enabled.
    private boolean fullScreen = true;
    //** Trigger used to check if a window frame is to be seen.
    private boolean windowFrame = false;
    //** Fields used for a FPS representation
    private int fps;
    //** Following 2 fields are in charge of a size of a fps label in a screen
    private int lblFPSWidth = 60;
    private int lblFPSHeight = 15;
    //** Updating FPS every nth milliseconds
    private int fpsUpdateTimeOut = 200;     // in millisecs
    private Color clrFPSLabel = new Color(150, 150, 150);
    private JLabel lblFPS = new JLabel("FPS:");
    //** Values used for fps computation
    private long beginTime;
    private long endTime = (new Date()).getTime();
    //** Field used to find out a size of a screen
    private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    //** Width of a screen
    private int screenWidth = (int) screenSize.getWidth();
    //** Height of a screen
    private int screenHeight = (int) screenSize.getHeight();
    //** Center of a plane (screen)
    private Point pntScreenCenter
            = new Point(screenWidth / 2, screenHeight / 2);    
    /**
     * When full screen is off, then following fields stand for a size of a
     * window
     */
    private int ScreenWidth = 1200;
    private int ScreenHeight = 800;
    private Color clrWindowBackground = new Color(0, 0, 0);
    private static Repository oRepository;
    private static frmDrawingBoard oFrmDrawingBoard;
    private static Logic oLogic;
    private static Drawing oDrawing;
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="User related fields">
    /**
     * Put to this area a fields that has to do with a problem realised in a 
     * program itself.
     */
    //** Number of dots present in one circle.
    private int dotsNumber = 150;
    private int range = 900;

    /**
     * Timer that is in charge of computations done while balls are converging,
     * i.e. scatterred balls going towards the destination balls.
     */
    private Timer tmrRendering;

    //** In charge of an actual file that is to hold an image of a ball.
    private File fileImg;

    private ExtDots extDots = new ExtDots(dotsNumber);
    private final DekartPoint[] dekartPoints = new DekartPoint[dotsNumber];
    private final Color[] colors = new Color[dotsNumber];
    public int inversionMultiplier = 1;

    public Color[] getColors() {
        return colors;
    }

    public int getRange() {
        return range;
    }
    //</editor-fold>

    //** Used to paint a canvas on.
    private static class frmDrawingBoard extends JFrame { }

    private Repository() { }
    
    //** Retrieving an object of a Repository
    public static Repository getInstance() {

        if (oRepository == null) {

            oRepository = new Repository();
            Repository.oLogic = Logic.getInstance(oRepository);
            Repository.oDrawing = Drawing.getInstance(oRepository);
            Repository.oFrmDrawingBoard = new frmDrawingBoard();

            oRepository.initializeData();

        }
        return oRepository;

    }

    //** Adding a listeners to a frame
    private void addListeners(JFrame frame) {
        frame.addKeyListener(new FrameKeyListener());
        frame.addMouseListener(new FrameMouseListener());
        frame.addMouseMotionListener(new FrameMouseMotionListener());
        frame.addMouseWheelListener(new FrameMouseWheelListener());
    }

    //** Initializing a JFrame
    private void initializeFrame(JFrame frame) {
        frame.setSize(oRepository.getScreenWidth(),
                oRepository.getScreenHeight());
        frame.setLocationRelativeTo(null);
        frame.setContentPane(oRepository.getoDrawing());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        if (!oRepository.isWindowFrame()) {
            frame.setUndecorated(true);
        }
        frame.setLayout(null);
        oRepository.getLblFPS().setBounds(
                frame.getWidth() - oRepository.getLblFPSWidth(),
                5,
                oRepository.getLblFPSWidth(),
                oRepository.getLblFPSHeight());
        frame.add(oRepository.getLblFPS());
        oRepository.getLblFPS().setForeground(oRepository.getClrFPSLabel());
        frame.setBackground(oRepository.getClrWindowBackground());
        frame.setVisible(true);
        this.addListeners(oFrmDrawingBoard);
        frame.requestFocus();
    }

    //** Initializing some data - images, frame, adding listeners.
    private void initializeData() {

        //** Put an initialization code here */
        if (oRepository.isFullScreen()) {
            Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
            oRepository.pntScreenCenter.x = (int) 
                    screenSize.getWidth() / 2;
            oRepository.pntScreenCenter.y = (int) 
                    screenSize.getHeight() / 2;
            oRepository.setScreenWidth((int) screenSize.getWidth());
            oRepository.setScreenHeight((int) screenSize.getHeight());
        } else {
            oRepository.pntScreenCenter.x = oRepository.getScreenWidth() / 2;
            oRepository.pntScreenCenter.y = oRepository.getScreenHeight() / 2;
        }

        this.initializeFrame(oFrmDrawingBoard);

        //** Setting a background for a canvas (screen)
        oDrawing.setBackground(
                oRepository.getClrWindowBackground()
        );

        // Placing a dots to a center of a screen
        extDots.placeExtDots(
                oRepository.getPntScreenCenter().x,
                oRepository.getPntScreenCenter().y);
        
        //** Hiding mouse cursor
//        oRepository.getoDrawing().setCursor(
//                    oRepository.getoDrawing().getToolkit().createCustomCursor(
//                            new BufferedImage(3, 3, BufferedImage.TYPE_INT_ARGB),
//                            new Point(0, 0),
//                            "null"));
        initPoints();
    }

    //<editor-fold defaultstate="collapsed" desc="Getters & Setters">

    public DekartPoint[] getPoints() {
        return dekartPoints;
    }

    private void initPoints() {
        for(int i=0; i < dekartPoints.length;i++) {
            dekartPoints[i] = new DekartPoint(
                    Math.random() * getRange() - getRange() /2,
                    Math.random() * getRange() - getRange() /2,
                    Math.random() * getRange() - getRange() /2,
                    1);
            colors[i] = new Color((int)(Math.random() * 255),
                    (int)(Math.random() * 255),
                    (int)(Math.random() * 255));
        }
    }

    public ExtDots getExtDots() {
        return extDots;
    }

    public void setExtDots(ExtDots extDots) {
        this.extDots = extDots;
    }

    public Timer getTmrRendering() {
        return tmrRendering;
    }

    public void setTmrRendering(Timer tmrRendering) {
        this.tmrRendering = tmrRendering;
    }

    public File getFileImg() {
        return fileImg;
    }

    public void setFileImg(File fileImg) {
        this.fileImg = fileImg;
    }

    public Logic getoLogic() {
        return oLogic;
    }

    public void setoLogic(Logic oLogic) {
        this.oLogic = oLogic;
    }

    public Drawing getoDrawing() {
        return oDrawing;
    }

    public void setoDrawing(Drawing oDrawing) {
        this.oDrawing = oDrawing;
    }

    public Point getPntScreenCenter() {
        return pntScreenCenter;
    }

    public void setPntScreenCenter(Point pntScreenCenter) {
        this.pntScreenCenter = pntScreenCenter;
    }

    public JLabel getLblFPS() {
        return lblFPS;
    }

    public void setLblFPS(JLabel lblFPS) {
        this.lblFPS = lblFPS;
    }

    public int getLblFPSWidth() {
        return lblFPSWidth;
    }

    public void setLblFPSWidth(int lblFPSWidth) {
        this.lblFPSWidth = lblFPSWidth;
    }

    public int getLblFPSHeight() {
        return lblFPSHeight;
    }

    public void setLblFPSHeight(int fpsLabelHeight) {
        this.lblFPSHeight = fpsLabelHeight;
    }

    public Color getClrFPSLabel() {
        return clrFPSLabel;
    }

    public void setClrFPSLabel(Color clrFPSLabel) {
        this.clrFPSLabel = clrFPSLabel;
    }

    public int getFpsUpdateTimeOut() {
        return fpsUpdateTimeOut;
    }

    public void setFpsUpdateTimeOut(int fpsUpdateTimeOut) {
        this.fpsUpdateTimeOut = fpsUpdateTimeOut;
    }

    public int getFps() {
        return fps;
    }

    public void setFps(int fps) {
        this.fps = fps;
    }

    public Color getClrWindowBackground() {
        return clrWindowBackground;
    }

    public void setClrWindowBackground(Color clrWindowBackground) {
        this.clrWindowBackground = clrWindowBackground;
    }

    public static Repository getRepository() {
        return oRepository;
    }

    public static void setRepository(Repository Repository) {
        Repository.oRepository = Repository;
    }

    public boolean isFullScreen() {
        return fullScreen;
    }

    public void setFullScreen(boolean fullScreen) {
        this.fullScreen = fullScreen;
    }

    public boolean isWindowFrame() {
        return windowFrame;
    }

    public void setWindowFrame(boolean windowFrame) {
        this.windowFrame = windowFrame;
    }

    public int getScreenWidth() {
        return ScreenWidth;
    }

    public void setScreenWidth(int ScreenWidth) {
        this.ScreenWidth = ScreenWidth;
    }

    public int getScreenHeight() {
        return ScreenHeight;
    }

    public void setScreenHeight(int ScreenHeight) {
        this.ScreenHeight = ScreenHeight;
    }

    public frmDrawingBoard getoFrmDrawingBoard() {
        return Repository.oFrmDrawingBoard;
    }

    public void setoFrmDrawingBoard(frmDrawingBoard aoFrmDrawingBoard) {
        Repository.oFrmDrawingBoard = aoFrmDrawingBoard;
    }

    public boolean isKeyAlt() {
        return keyAlt;
    }

    public void setKeyAlt(boolean keyAlt) {
        this.keyAlt = keyAlt;
    }

    public boolean isKeyCtrl() {
        return keyCtrl;
    }

    public void setKeyCtrl(boolean keyCtrl) {
        this.keyCtrl = keyCtrl;
    }

    public boolean isKeyShift() {
        return keyShift;
    }

    public void setKeyShift(boolean keyShift) {
        this.keyShift = keyShift;
    }

    public long getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(long beginTime) {
        this.beginTime = beginTime;
    }

    public long getEndTime() {
        return endTime;
    }

    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }
   
//</editor-fold>    
}

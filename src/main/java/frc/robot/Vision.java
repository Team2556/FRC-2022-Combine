package frc.robot;

import org.opencv.core.Rect;
import org.opencv.imgproc.Imgproc;
import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.cscore.UsbCamera;
import edu.wpi.first.vision.VisionThread;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Vision {
    
    private VisionThread visionThread;
    private double centerX = 0.0;

    private final Object imgLock = new Object();

    public void visionInit() {
        UsbCamera camera = CameraServer.startAutomaticCapture();
        camera.setResolution(Constants.IMG_WIDTH, Constants.IMG_HEIGHT);

        visionThread = new VisionThread(camera, new RedCargoPipeline(), pipeline -> {
            if (!pipeline.filterContoursOutput().isEmpty()) {
                Rect r = Imgproc.boundingRect(pipeline.filterContoursOutput().get(0));
                synchronized (imgLock) {
                    centerX = r.x + (r.width / 2);
                }
            }
        });

        visionThread.start();
        
    }

    public double visionPeriodic() {
        double centerX;
        synchronized (imgLock) {
            centerX = this.centerX;
          }
          SmartDashboard.putNumber("Center X", centerX);
        return centerX;
    }

    public double visionTurn() {
        SmartDashboard.putNumber("Center X", centerX);
        return visionPeriodic() - (Constants.IMG_WIDTH / 2);
    }
}

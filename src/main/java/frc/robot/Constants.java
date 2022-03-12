package frc.robot;

// import edu.wpi.first.math.geometry.Pose2d;
// import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.math.kinematics.DifferentialDriveKinematics;
import edu.wpi.first.math.kinematics.MecanumDriveKinematics;
// import edu.wpi.first.math.kinematics.MecanumDriveOdometry;

public class Constants {
    
    // Drive Constants
    public static final int rFMotorPort = 1;
    public static final int rRMotorPort = 3;
    public static final int lFMotorPort = 2;
    public static final int lRMotorPort = 4;


    public static final double kTrackWidth = 0.5588;
    // Distance between centers of right and left wheels on robot
    public static final double kWheelBase = 0.762;
    // Distance between centers of front and back wheels on robot

    public static final MecanumDriveKinematics DriveKinematics =
        new MecanumDriveKinematics(
            new Translation2d(kWheelBase / 2, kTrackWidth / 2),
            new Translation2d(kWheelBase / 2, -kTrackWidth / 2),
            new Translation2d(-kWheelBase / 2, kTrackWidth / 2),
            new Translation2d(-kWheelBase / 2, -kTrackWidth / 2));

    // Shooter Constants
    public static final int ShooterMotorPort = 7;
    public static final int hoodMotorPort = 8; 

    // Intake and Feeder Constants
    public static final int intakeMotorPort = 5; //low intake
    public static final int feederMotorPort = 6; //mid intake
    public static final int translateMotorPort = 0; 


    // Climber Constants
    public static final int winchMotorID = 9; //climber motor port 
    

    // Vision Constants
    public static final int IMG_WIDTH = 320;
    public static final int IMG_HEIGHT = 240;


    // PathWeaver Constants - FIND THESE BEFORE USING
    public static final double ksVolts = 0.22;
    public static final double kvVoltSecondsPerMeter = 1.98;
    public static final double kaVoltSecondsSquaredPerMeter = 0.2;
    public static final double kPDriveVel = 8.5;
    //public static final double kTrackwidthMeters = 0.69; we already have this B)
    public static final DifferentialDriveKinematics kDriveKinematics =
        new DifferentialDriveKinematics(kTrackWidth);
    public static final double kMaxSpeedMetersPerSecond = 3;
    public static final double kMaxAccelerationMetersPerSecondSquared = 3;
    public static final double kRamseteB = 2;
    public static final double kRamseteZeta = 0.7;

    public static final int[] kLeftEncoderPorts = {10, 20}; 
    public static final boolean kLeftEncoderReversed = false; 
    

    public static final int[] kRightEncoderPorts = {30, 40}; 
    public static final boolean kRightEncoderReversed = false; 
    public static final double kEncoderDistancePerPulse = 0.00; 

    public static final int kDriverControllerPort = 100; 
  }

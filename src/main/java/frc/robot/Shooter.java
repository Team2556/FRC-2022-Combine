package frc.robot;

import com.ctre.phoenix.motorcontrol.can.TalonFX;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import com.ctre.phoenix.motorcontrol.TalonFXFeedbackDevice;
import com.ctre.phoenix.motorcontrol.TalonFXControlMode;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;


public class Shooter {
    OI oi = new OI();

    NetworkTable table = NetworkTableInstance.getDefault().getTable("limelight");
    NetworkTableEntry ty = table.getEntry("ty");


    private final TalonFX shooterMotor = new TalonFX(Constants.ShooterMotorPort);
    private final TalonFX hoodMotor = new TalonFX(Constants.hoodMotorPort);

    public void shooterInit() {
        shooterMotor.configSelectedFeedbackSensor(TalonFXFeedbackDevice.IntegratedSensor, 0, 10);
        hoodMotor.configSelectedFeedbackSensor(TalonFXFeedbackDevice.IntegratedSensor, 0, 10);
    }

    public void setShooterSpeed() {
        shooterMotor.set(TalonFXControlMode.Velocity, oi.shooterSpeed());
        SmartDashboard.putNumber("Shooter Motor Set Velocity", oi.shooterSpeed());
    }
/*
    public double getShooterSpeed() {
        SmartDashboard.putNumber("Shooter Motor Current Velocity", shooterMotor.getSelectedSensorVelocity());
        return shooterMotor.getSelectedSensorVelocity();
    }

    public boolean atSetpoint() {
        double setValue = SmartDashboard.getNumber("Shooter Motor Current Velocity", 0);
        double currentValue = SmartDashboard.getNumber("Shooter Motor Set Velocity", 1);
        double diff = Math.abs(setValue - currentValue);
        return (diff < 0.1);
    }*/
    //isn't it kind of redundant to read the values, put them on smartdashboard, then read it back?

    public boolean atSetpoint() {
        double setValue = oi.shooterSpeed();
        double currentValue = shooterMotor.getSelectedSensorVelocity();
        SmartDashboard.putNumber("Shooter Motor Current Velocity", currentValue);
        SmartDashboard.putNumber("Shooter Motor Current Velocity", setValue);
        double diff = Math.abs(setValue - currentValue);
        return (diff < 0.1);
    }


    public void  hoodAdjust() {
        double adjust = ty.getDouble(0.0);
        hoodMotor.set(TalonFXControlMode.Velocity, adjust);
        SmartDashboard.putNumber("Hood Motor Adjustment", adjust); 
    }
}

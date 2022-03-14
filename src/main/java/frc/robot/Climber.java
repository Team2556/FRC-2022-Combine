package frc.robot;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DutyCycleEncoder;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
//import edu.wpi.first.wpilibj.PneumaticsControlModule;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Climber {
    //Drive drive = new Drive();
    OI oi = new OI();

    private DoubleSolenoid yellowLeft  = new DoubleSolenoid(Constants.PCMLPort, PneumaticsModuleType.CTREPCM, Constants.yLForwardChannel, Constants.yLReverseChannel);
    private DoubleSolenoid yellowRight = new DoubleSolenoid(Constants.PCMLPort, PneumaticsModuleType.CTREPCM, Constants.yRForwardChannel, Constants.yRReverseChannel);
    private DoubleSolenoid clampPiston = new DoubleSolenoid(Constants.PCMRPort, PneumaticsModuleType.CTREPCM, Constants.clampForwardChannel, Constants.clampReverseChannel); //double solenoid 4,5
    private TalonSRX winchMotor = new TalonSRX(Constants.winchMotorPort);
    private DutyCycleEncoder winchEncoder = new DutyCycleEncoder(Constants.winchEncoderPort);

    public void climbInit(){
        yellowLeft.set(Value.kReverse);
        yellowRight.set(Value.kReverse);
        clampPiston.set(Value.kReverse);
        winchMotor.configFactoryDefault();
        winchMotor.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder);
        winchMotor.setSelectedSensorPosition(0);
    }

    public void climbTeleop(){
        winchMotor(oi.winchSpeed());
        winchPistons(oi.winchUp());
        clampPiston(oi.clampOut());
    }


    public void winchMotor(double winchSpeed){
        winchMotor.set(ControlMode.PercentOutput, winchSpeed);
        } // temp b button and y button
        // y in b out. negative speed in, positive speed out.



    public void winchPistons(boolean winchUp){
             
        if (winchUp){
            yellowLeft.set(Value.kForward);
            yellowRight.set(Value.kForward);
            }
        else {
            yellowLeft.set(Value.kReverse);
            yellowRight.set(Value.kReverse);
            }
    }
           
    public void clampPiston(boolean clampOn){
        // false is the clamps not being clamped on
        // reverse is not being clamped on
        if (clampOn){
            clampPiston.set(Value.kForward);
        }
        else{
            clampPiston.set(Value.kReverse);
        }
    }
}


/*
starts with little hooks down winch in yellow in.
1. big hooks up, (yellow
2. big hooks down
3.small hooks attach (clamp
4.winch motor goes out completely 
5.big hooks out, 
6.winch in 
7.small hooks open
8.big hooks in
9. winch in
10. repeat steps 3-7
*/
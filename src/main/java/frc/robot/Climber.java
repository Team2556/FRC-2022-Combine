package frc.robot;
//import com.ctre.phoenix.motorcontrol.ControlMode;
//import com.ctre.phoenix.motorcontrol.FeedbackDevice;
//import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.DoubleSolenoid;
//import edu.wpi.first.wpilibj.DutyCycleEncoder;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
//import edu.wpi.first.wpilibj.PneumaticsControlModule;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
//import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
//random
public class Climber {
    //Drive drive = new Drive();
    OI oi = new OI();

    private DoubleSolenoid yellowLeft  = new DoubleSolenoid(Constants.PCMLPort, PneumaticsModuleType.CTREPCM, Constants.yLForwardChannel, Constants.yLReverseChannel);
    private DoubleSolenoid yellowRight = new DoubleSolenoid(Constants.PCMLPort, PneumaticsModuleType.CTREPCM, Constants.yRForwardChannel, Constants.yRReverseChannel);
    private DoubleSolenoid clampPiston = new DoubleSolenoid(Constants.PCMRPort, PneumaticsModuleType.CTREPCM, Constants.clampForwardChannel, Constants.clampReverseChannel); //double solenoid 4,5
    //private TalonSRX winchMotor = new TalonSRX(Constants.winchMotorPort);
    //private DutyCycleEncoder winchEncoder = new DutyCycleEncoder(Constants.winchEncoderPort);
    private CANSparkMax winchMotor = new CANSparkMax(Constants.yellowMotorPort, MotorType.kBrushless);
    RelativeEncoder winchEncoder = winchMotor.getEncoder();

    public void climbInit(){
        yellowLeft.set(Value.kReverse);
        yellowRight.set(Value.kReverse);
        winchMotor.set(0);
        clampPiston.set(Value.kReverse);
        //winchMotor.configFactoryDefault();
        //winchMotor.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder);
        //winchMotor.setSelectedSensorPosition(0);
    }

    public void climbTeleop(){
        winchMotor(oi.winchSpeed()); //left/right triggers
        yellowRun(oi.winchUp()); // x button
        clampPiston(oi.clampOut()); // a button
        /*
        yellowrun(oi.winchUp()); //1. yellow (big hooks) up
        yellowrun(false); //2. yellow down
        clampPiston(oi.clampOut()); //3. clamp on
        winchMotor(oi.winchSpeed()); //4. winch out
        yellowrun(oi.winchUp()); //5. yellow (big hooks) up
        winchMotor(oi.winchSpeed()); //6. winch in
        clampPiston(oi.clampOut()); //7. clamp out
        yellowrun(false); //8. big hooks in 
        winchMotor(oi.winchSpeed()); //9. winch in
        */
    }

    public void automatedClimb(){
        winchEncoder.setPosition(0); //set encoder to 0
        for (int i = 0; i < 3; i++){ //run winch twice 
            while (winchEncoder.getPosition() <= 5){ //only run while encoder is within range
                yellowRun(oi.winchUp); 
            }}
    
        yellowRun(oi.winchUp()); //big hooks down 
        clampPiston(true); 
    }

    public void winchMotor(double winchSpeed){
        winchMotor.set(winchSpeed);
        } // temp b button and y button
        // y in b out. negative speed in, positive speed out.


    public void yellowRun(boolean winchUp){
             
        if (winchUp){
            yellowLeft.set(Value.kForward);
            yellowRight.set(Value.kForward);
           
                
            //double yellowUp = winchEncoder.get(); //get vertical distance needed
            }
        else {
            yellowLeft.set(Value.kReverse);
            yellowRight.set(Value.kReverse);
        }
/*
        if (winchEncoder.get() > yellowUp){ //dummy value
            yellowLeft.set(Value.kOff);
            yellowRight.set(Value.kOff);
        }*/
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
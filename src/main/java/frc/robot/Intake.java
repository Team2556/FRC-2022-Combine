package frc.robot;

// import javax.print.CancelablePrintJob;

import com.revrobotics.CANSparkMax;
// import com.revrobotics.CANSparkMaxLowLevel;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

//import edu.wpi.first.wpilibj.PneumaticsModuleType;
//import edu.wpi.first.wpilibj.Solenoid;

public class Intake {
    OI oi = new OI();

    //INTAKE
    private CANSparkMax intake = new CANSparkMax(Constants.intakeMotorPort, MotorType.kBrushless);
    private CANSparkMax translate = new CANSparkMax(Constants.translateMotorPort, MotorType.kBrushless);

    // Solenoid intakeSolenoid = new Solenoid(1, PneumaticsModuleType.CTREPCM, 1);


    public void intakeMotor(){
        intake.set(oi.intakeSpeed());
    }
    public void translateMotor(){
        translate.set(oi.translateSpeed()); //what
    }
    public void intakeSolenoid(){
        // intakeSolenoid.set(oi.intakeSolenoid());
    }

    //FEEDER
    private final CANSparkMax feederMotor = new CANSparkMax(Constants.feederMotorPort, MotorType.kBrushless);

    public void runFeeder() {
        feederMotor.set(oi.feederSpeed());
    }
}

package frc.robot;
//import com.fasterxml.jackson.databind.ser.std.StdKeySerializers.Default;

import edu.wpi.first.wpilibj.XboxController;

public class OI {
    
    
    //Xbox object
    XboxController Xbox1 = new XboxController(0);
    XboxController Xbox2 = new XboxController(1);

   
    //drive piston drops
    boolean dropped = true;
    boolean dropped(){
       
        if(Xbox1.getBButtonReleased()){
            dropped = !dropped;
        }
        return dropped;
    }


    //mecanum drive values
    double mForward(){
        return Xbox1.getLeftY();
    }
    double mStrafe(){
        return Xbox1.getLeftX();
    }
    double mRotate(){
        return Xbox1.getRightX();
    }


    //tank drive values
    double tLeft(){
        return Xbox1.getLeftY();
    }
    double tRight(){
        return Xbox1.getRightY();
    }


    //climber values
    double winchSpeed(){
        if(Xbox1.getLeftTriggerAxis() == 1){
            return -1;
        }

        else if(Xbox1.getRightTriggerAxis() == 1){
            return 1;
        }

        else{
            return 0;
        }
    }

    boolean winchUp = false;
    boolean winchUp(){
       
        if(Xbox1.getXButtonReleased()){
            winchUp = !winchUp;
        }
        return winchUp;
    }


    //intake values
    double intakeSpeed(){
        if(Xbox1.getLeftBumper()){
            return -1;
        }
        else if(Xbox1.getRightBumper()){
            return 1;
        }
        else{
            return 0;
        }
      }

    double translateSpeed(){
        if(Xbox2.getLeftBumper()){
            return -1;
        }   
        else if(Xbox2.getRightBumper()){
            return 1;
        }
        else{
            return 0;
        }
    }

    boolean intakeSolenoid(){
        return Xbox2.getAButton();
    }

    double feederSpeed(){
        if(Xbox2.getLeftBumper()){
            return -1;
        }
        else if(Xbox2.getRightBumper()){
            return 1;
        }
        else{
            return 0;
        }
      }


    //shooter values
    double shooterSpeed(){
        if(Xbox1.getYButton()){
              return 1;
        }
        else{
               return 0;
        }
      }
    double hoodSpeed = 1.0; 
    

    //limelight values
    boolean limeLightTurn = false;
    boolean limeLightTurn(){
        if(Xbox1.getAButton()){
            limeLightTurn = true;
        }    
        else{
            limeLightTurn = false;
        }
        return limeLightTurn;
    }


}

/*
CONTROLS

XBox 1
A: limelight
B: drop drive
Y: shooter
X: winch

joysticks
left: mecanum forward/strafe; tank left
right: mecanum rotate; tank right

triggers
left: climber up
right: climber down

bumpers
left: intake in
right: intake down 

XBox 2
A: intake solenoid

bumpers
left: translate; feeder speed
right: translate; feeder speed


*/

    



















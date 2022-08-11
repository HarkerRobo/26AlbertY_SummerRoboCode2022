package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import harkerrobolib.wrappers.HSTalon;

public class Intake extends SubsystemBase {
    private boolean intaking;

    private static Intake instance;
    private HSTalon motor;
    
    private DoubleSolenoid intake;
    private static final int DIRECT_ID_F = 1; //forward
    private static final int DIRECT_ID_B = 0; //backwards

    private static final int MOTOR_ID = 0; //0 TBD
    private static final boolean INVERT = false; 

    public Intake() {
        motor = new HSTalon(MOTOR_ID);
        intake = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, DIRECT_ID_F, DIRECT_ID_B);
    }

    public void initMotors() {
        motor.setInverted(INVERT);
    }

    public HSTalon getMotor() {
        return motor;
    }

    public void setOutput(double output) {
        if(output > 0.1) {
            intaking = true;
        } else {
            intaking = false;
        }
        motor.set(ControlMode.PercentOutput, output);
    }
    public boolean getIntake() {
        return intaking;
    }
    public void toggle() {
        if(intake.get() == Value.kForward) {
            intake.set(Value.kReverse);
        }
        
        else {
            intake.set(Value.kForward);
        
        }
    } 
    

    public static Intake getInstance() {
        if (instance == null) {
            instance = new Intake();
        }

        return instance;
    }
    
    
}
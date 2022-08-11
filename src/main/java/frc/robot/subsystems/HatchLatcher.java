package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import harkerrobolib.wrappers.HSGamepad;

public class HatchLatcher extends SubsystemBase{
    private static HatchLatcher instance;

    private static DoubleSolenoid flower;
    private static DoubleSolenoid extender;

    private static final int F_FLOWER_ID = 0;
    private static final int R_FLOWER_ID = 0;
    private static final int F_EXTENDER_ID = 0;
    private static final int R_EXTENDER_ID = 0;

    public HatchLatcher() {
        flower = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, F_FLOWER_ID, R_FLOWER_ID);
        extender = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, F_EXTENDER_ID, R_EXTENDER_ID);
    }

    public void ToggleFlower() {
        if(flower.get() == Value.kForward) {
            flower.set(Value.kReverse);
        }
        
        else {
            flower.set(Value.kForward);
        
        }
    }

    public void ToggleExtender() {
        if(extender.get() == Value.kForward) {
            extender.set(Value.kReverse);
        }
        
        else {
            extender.set(Value.kForward);
        
        }
    }
    
    public static HatchLatcher getInstance() {
        if (instance == null) {
            instance = new HatchLatcher();
        }

        return instance;
    }    
}

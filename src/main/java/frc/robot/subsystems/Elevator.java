package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import harkerrobolib.wrappers.HSTalon;

public class Elevator extends SubsystemBase{
    private static Elevator instance;

    private HSTalon MF0;
    private static final int MF0_ID = 0; //0 TBD
    private static final boolean MF0_INVERT = false;

    private HSTalon MF1;
    private static final int MF1_ID = 0; //0 TBD
    private static final boolean MF1_INVERT = false;

    private VictorSPX MF2;
    private static final int MF2_ID = 0; //0 TBD
    private static final boolean MF2_INVERT = false;

    private VictorSPX MF3;
    private static final int MF3_ID = 0; //0 TBD
    private static final boolean MF3_INVERT = false;

    public Elevator() {
        MF0 = new HSTalon(MF0_ID); //original
        MF0.setInverted(MF0_INVERT);

        MF1 = new HSTalon(MF1_ID); //second one, follow original
        MF1.setInverted(MF1_INVERT);
        MF1.follow(MF0);

        MF2 = new VictorSPX(MF2_ID); //third, follow second
        MF2.setInverted(MF2_INVERT);
        MF2.follow(MF1);

        MF3 = new VictorSPX(MF3_ID); //fourth, follow third
        MF3.setInverted(MF3_INVERT);
        MF3.follow(MF2);
    }
    public void setOutput(double output) {
        MF0.set(ControlMode.PercentOutput, output);
    }
    public static Elevator getInstance() {
        if (instance == null) {
            instance = new Elevator();
        }

        return instance;
    }
}

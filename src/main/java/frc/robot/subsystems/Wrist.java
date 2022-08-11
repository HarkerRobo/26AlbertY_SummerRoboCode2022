package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import harkerrobolib.wrappers.HSTalon;

public class Wrist extends SubsystemBase {
    private static Wrist instance;

    private HSTalon master;
    private static final int M_ID = 0;
    private static final boolean M_Invert = false;

    private VictorSPX follower;
    private static final int F_ID = 0;
    private static final boolean F_Invert = false;

    public Wrist() {
        master = new HSTalon(M_ID);
        master.setInverted(M_Invert);

        follower = new VictorSPX(F_ID);
        follower.setInverted(F_Invert);
        follower.follow(master);
    }

    public void setOutput(double output) {
        master.set(ControlMode.PercentOutput, output);
    }
    public static Wrist getInstance() {
        if (instance == null) {
            instance = new Wrist();
        }
        return instance;
    }
}

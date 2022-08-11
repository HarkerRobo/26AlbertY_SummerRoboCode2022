package frc.robot.subsystems; 
 
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import org.ejml.dense.row.SpecializedOps_DDRM;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import harkerrobolib.wrappers.HSTalon;

public class Drivetrain extends SubsystemBase {
    private static Drivetrain instance;

    private HSTalon rightMaster;
    private static final int R_M_MOTOR_ID = 0; //0 TBD
    private static final boolean R_M_INVERT = false;

    private HSTalon leftMaster;
    private static final int L_M_MOTOR_ID = 0; //0 TBD
    private static final boolean L_M_INVERT = false;

    private VictorSPX rightFollow;
    private static final int R_F_MOTOR_ID = 0; //0 TBD
    private static final boolean R_F_INVERT = false;

    private VictorSPX leftFollow;
    private static final int L_F_MOTOR_ID = 0; //0 TBD
    private static final boolean L_F_INVERT = false;

    
    public Drivetrain() {
        rightMaster = new HSTalon(R_M_MOTOR_ID);
        rightMaster.setInverted(R_M_INVERT);

        leftMaster = new HSTalon(L_M_MOTOR_ID);
        leftMaster.setInverted(L_M_INVERT);

        rightFollow = new VictorSPX(R_F_MOTOR_ID);
        rightFollow.setInverted(R_F_INVERT);
        rightFollow.follow(rightMaster);

        leftFollow = new VictorSPX(L_F_MOTOR_ID);
        leftFollow.setInverted(L_F_INVERT);
        leftFollow.follow(leftMaster);
    }

    public void setArcadeDrive(double turn, double speed) {
        rightMaster.set(ControlMode.PercentOutput, speed-turn);
        leftMaster.set(ControlMode.PercentOutput, speed+turn);
    }

    public static Drivetrain getInstance() {
        if (instance == null) {
            instance = new Drivetrain();
        }

        return instance;
    }
}


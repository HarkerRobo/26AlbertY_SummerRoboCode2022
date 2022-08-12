package frc.robot.commands;

import frc.robot.OI;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.WristRollers;
import harkerrobolib.commands.IndefiniteCommand;

public class WristRollersManual extends IndefiniteCommand {
    public WristRollersManual() {
        addRequirements(WristRollers.getInstance());
    }

    public void execute() {
        double output = OI.getInstance().getDriver().getRightTrigger();
        if (output > 0.5) {
            output = -0.3;
        }else if (Intake.getInstance().getIntake()){
            output = 0.2;
        }else {
            output = 0;
        }
        WristRollers.getInstance().setOutput(output);
    }

    public void end(boolean interrupted) {
        WristRollers.getInstance().setOutput(0);
    }
}

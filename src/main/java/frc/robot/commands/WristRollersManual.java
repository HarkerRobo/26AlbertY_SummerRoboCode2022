package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.OI;
import frc.robot.subsystems.WristRollers;

public class WristRollersManual extends CommandBase {
    public WristRollersManual() {
        addRequirements(WristRollers.getInstance());
    }

    public void execute() {
        double output = OI.getInstance().getDriver().getRightTrigger();
        if (Math.abs(output) < 0.2) {
            output = 0;
        }
        WristRollers.getInstance().setOutput(output);
    }

    public void end(boolean interrupted) {
        WristRollers.getInstance().setOutput(0);
    }
}

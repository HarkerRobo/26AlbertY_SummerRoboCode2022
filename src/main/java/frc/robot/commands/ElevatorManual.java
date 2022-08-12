package frc.robot.commands;

import frc.robot.OI;
import frc.robot.subsystems.Elevator;
import harkerrobolib.commands.IndefiniteCommand;

public class ElevatorManual extends IndefiniteCommand {
    public ElevatorManual() {
        addRequirements(Elevator.getInstance());
    }

    public void execute() {
        double output = OI.getInstance().getDriver().getRightY();
        if (Math.abs(output) < 0.1) {
            output = 0.1;
        }

        Elevator.getInstance().setOutput(output);
    }

    public void end(boolean interrupted) {
        Elevator.getInstance().setOutput(0);
    }


}

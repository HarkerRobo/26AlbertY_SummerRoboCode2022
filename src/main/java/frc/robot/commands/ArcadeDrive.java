package frc.robot.commands;

import frc.robot.OI;
import frc.robot.subsystems.Drivetrain;
import harkerrobolib.commands.IndefiniteCommand;


public class ArcadeDrive extends IndefiniteCommand{
    private double turn;
    private double drive;
    public ArcadeDrive () {
        addRequirements(Drivetrain.getInstance());
    }
    public void execute() {
        turn = OI.getInstance().getDriver().getLeftX();
        drive = OI.getInstance().getDriver().getLeftY();
        Drivetrain.getInstance().setArcadeDrive(turn, drive);
    }
    public void end(boolean interrupted) {
        turn = 0;
        drive = 0;
        Drivetrain.getInstance().setArcadeDrive(turn, drive);
    }

}

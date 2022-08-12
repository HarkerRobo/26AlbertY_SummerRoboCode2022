package frc.robot.commands;

import frc.robot.OI;
import frc.robot.subsystems.Intake;
import harkerrobolib.commands.IndefiniteCommand;

public class IntakeManual extends IndefiniteCommand {
    public IntakeManual() {
        addRequirements(Intake.getInstance());

    }
    
    public void execute() {
        double output = 0;
        if(OI.getInstance().getDriver().getRightTrigger() > 0.5) {
            output = 0.3;
        }
        else{
            output = 0;
        }
        Intake.getInstance().setOutput(output);
    }
    
    
    public void end(boolean interrupted) {
        Intake.getInstance().setOutput(0);
    }


}
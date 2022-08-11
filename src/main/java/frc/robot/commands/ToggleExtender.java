package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.HatchLatcher;

public class ToggleExtender extends CommandBase {
    public ToggleExtender () {
        addRequirements(HatchLatcher.getInstance());
    }
    
    public void initialize() {
        HatchLatcher.getInstance().ToggleExtender();
    }
    
    public boolean isFinished() {
        return false;
    }

    public void end(boolean interrupted) {
        
    }
    
}

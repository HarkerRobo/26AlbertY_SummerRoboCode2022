package frc.robot;

import frc.robot.commands.ToggleExtender;
import frc.robot.commands.ToggleFlower;
import frc.robot.commands.ToggleIntake;
import harkerrobolib.wrappers.HSGamepad;
import harkerrobolib.wrappers.XboxGamepad;

public class OI {
    private static OI instance;
    private HSGamepad driver;
    private static final int DRIVER_ID = 0; //for now

    private OI () {
        driver = new XboxGamepad(DRIVER_ID);
        //commands
        driver.getButtonA().whenPressed(new ToggleFlower());
        driver.getButtonB().whenPressed(new ToggleExtender());
        driver.getButtonX().whenPressed(new ToggleIntake());
    }

    public HSGamepad getDriver() {
        return driver;
    }
    public static OI getInstance() {
        if (instance == null) {
            instance = new OI();
        }

        return instance;
    }
}

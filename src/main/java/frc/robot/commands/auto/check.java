package frc.robot.commands.auto;

import frc.util.SuperNavX;
import frc.util.commands.TurnInPlace;
import frc.util.pathGenerator.commandAuto.AutoGenerator;
import frc.robot.subsystems.DriveSystem;

public class check extends AutoGenerator {
    public check(DriveSystem driveSystem, SuperNavX navX) {
            super("check", driveSystem.getAutoGains(), driveSystem, navX, 0);
            addCommands(new TurnInPlace(driveSystem, navX, 90));

    }
}


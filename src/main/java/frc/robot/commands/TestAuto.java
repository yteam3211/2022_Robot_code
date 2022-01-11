package frc.robot.commands;

import frc.robot.Constants;
import frc.util.SuperNavX;
import frc.util.pathGenerator.commandAuto.AutoGenerator;
import frc.robot.subsystems.DriveSystem;

public class TestAuto extends AutoGenerator {
        public TestAuto(DriveSystem driveSystem, SuperNavX navX) {
                super("TestAuto", driveSystem.getAutoGains(), driveSystem, navX);
                addCommands(addFollowPathCommand(Constants.auto1));

        }
}

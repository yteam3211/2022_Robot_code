package frc.robot.commands.auto;

import frc.robot.Constants;
import frc.util.SuperNavX;
import frc.util.pathGenerator.commandAuto.AutoGenerator;
import frc.util.pathGenerator.drive_controls.EncoderDriveControl;
import frc.robot.subsystems.DriveSystem;

public class forwardAuto extends AutoGenerator {
        public forwardAuto(DriveSystem driveSystem, SuperNavX navX) {
                super("forwardAuto", driveSystem.getAutoGains(), driveSystem, navX);
                Constants.forward.inReverse();
                addCommands(addFollowPathCommand(Constants.forward, new EncoderDriveControl(driveSystem)));

        }
}

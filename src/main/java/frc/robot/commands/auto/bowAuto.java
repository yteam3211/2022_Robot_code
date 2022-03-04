package frc.robot.commands.auto;


import frc.robot.Constants;
import frc.util.SuperNavX;
import frc.util.pathGenerator.commandAuto.AutoGenerator;
import frc.util.pathGenerator.drive_controls.EncoderAndNavxDriveControl;
import frc.robot.subsystems.DriveSystem;

public class bowAuto extends AutoGenerator {
    public bowAuto(DriveSystem driveSystem, SuperNavX navX) {
            super("bowAuto", driveSystem.getAutoGains(), driveSystem, navX);
            addCommands(addFollowPathCommand(Constants.bow, new EncoderAndNavxDriveControl(driveSystem, navX)));

    }
}

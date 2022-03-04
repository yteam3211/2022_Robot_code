package frc.robot.commands.auto;


import frc.robot.Constants;
import frc.util.SuperNavX;
import frc.util.pathGenerator.commandAuto.AutoGenerator;
import frc.util.pathGenerator.drive_controls.EncoderDriveControl;
import frc.robot.subsystems.DriveSystem;



public class check extends AutoGenerator {
    public check(DriveSystem driveSystem, SuperNavX navX) {
            super("check", driveSystem.getAutoGains(), driveSystem, navX, 175);
            addCommands(addFollowPathCommand(Constants.L3, new EncoderDriveControl(driveSystem)));

    }
}


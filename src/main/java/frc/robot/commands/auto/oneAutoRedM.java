package frc.robot.commands.auto;


import frc.robot.Constants;
import frc.util.SuperNavX;
import frc.util.pathGenerator.commandAuto.AutoGenerator;
import frc.util.pathGenerator.drive_controls.EncoderAndNavxDriveControl;
import frc.robot.subsystems.DriveSystem;

public class oneAutoRedM extends AutoGenerator {
    public oneAutoRedM(DriveSystem driveSystem, SuperNavX navX) {
            super("oneAutoRedM", driveSystem.getAutoGains(), driveSystem, navX);
            addCommands(addFollowPathCommand(Constants.forward, new EncoderAndNavxDriveControl(driveSystem, navX)));

    }
}

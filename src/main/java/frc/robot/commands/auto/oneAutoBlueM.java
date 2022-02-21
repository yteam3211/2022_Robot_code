package frc.robot.commands.auto;


import frc.robot.Constants;
import frc.util.SuperNavX;
import frc.util.pathGenerator.commandAuto.AutoGenerator;
import frc.util.pathGenerator.drive_controls.EncoderAndNavxDriveControl;
import frc.robot.subsystems.DriveSystem;

public class oneAutoBlueM extends AutoGenerator {
    public oneAutoBlueM(DriveSystem driveSystem, SuperNavX navX) {
            super("oneAutoBlueM", driveSystem.getAutoGains(), driveSystem, navX);
            addCommands(addFollowPathCommand(Constants.forward, new EncoderAndNavxDriveControl(driveSystem, navX)));

    }
}

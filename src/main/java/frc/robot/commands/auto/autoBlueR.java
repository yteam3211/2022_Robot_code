package frc.robot.commands.auto;


import frc.robot.Constants;
import frc.util.SuperNavX;
import frc.util.pathGenerator.commandAuto.AutoGenerator;
import frc.util.pathGenerator.drive_controls.EncoderAndNavxDriveControl;
import frc.robot.subsystems.DriveSystem;

public class autoBlueR extends AutoGenerator {
    public autoBlueR(DriveSystem driveSystem, SuperNavX navX) {
            super("autoBlueR", driveSystem.getAutoGains(), driveSystem, navX);
            addCommands(addFollowPathCommand(Constants.forward, new EncoderAndNavxDriveControl(driveSystem, navX)));

    }
}

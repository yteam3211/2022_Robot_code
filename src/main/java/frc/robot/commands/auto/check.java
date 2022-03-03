package frc.robot.commands.auto;


import edu.wpi.first.wpilibj2.command.ParallelDeadlineGroup;
import frc.robot.Constants;
import frc.util.SuperNavX;
import frc.util.commands.TurnInPlace;
import frc.util.pathGenerator.commandAuto.AutoGenerator;
import frc.util.pathGenerator.drive_controls.EncoderAndNavxDriveControl;
import frc.util.pathGenerator.drive_controls.EncoderDriveControl;
import frc.robot.subsystems.DriveSystem;



public class check extends AutoGenerator {
    public check(DriveSystem driveSystem, SuperNavX navX) {
            super("check", driveSystem.getAutoGains(), driveSystem, navX, 175);
            addCommands(addFollowPathCommand(Constants.L3, new EncoderDriveControl(driveSystem)));

    }
}


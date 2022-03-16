package frc.robot.commands.auto;


import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import frc.robot.Constants;
import frc.util.SuperNavX;
import frc.util.commands.TimeCommand;
import frc.util.pathGenerator.commandAuto.AutoGenerator;
import frc.util.pathGenerator.drive_controls.EncoderAndNavxDriveControl;
import frc.robot.subsystems.DriveSystem;

public class bowAuto extends AutoGenerator {
    public bowAuto(DriveSystem driveSystem, SuperNavX navX) {
            super("bowAuto", driveSystem.getAutoGains(), driveSystem, navX);
            addCommands(new ParallelCommandGroup(new TimeCommand(5000), addFollowPathCommand(Constants.bow, new EncoderAndNavxDriveControl(driveSystem, navX))));
    }
}

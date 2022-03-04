package frc.robot.commands.auto;


import edu.wpi.first.wpilibj2.command.ParallelDeadlineGroup;
import frc.robot.Constants;
import frc.robot.commands.ShootingCommand;
import frc.robot.commands.collect.changeSelenoidCommand;
import frc.util.SuperNavX;
import frc.util.commands.SolenoidChangePositionCommand;
import frc.util.commands.TimeCommand;
import frc.util.pathGenerator.commandAuto.AutoGenerator;
import frc.util.pathGenerator.drive_controls.EncoderAndNavxDriveControl;
import frc.robot.subsystems.CartridgeSystem;
import frc.robot.subsystems.CollectSystem;
import frc.robot.subsystems.DriveSystem;
import frc.robot.subsystems.ShootingSystem;

public class oneBall extends AutoGenerator {
    public oneBall(DriveSystem driveSystem, SuperNavX navX, ShootingSystem shootingSystem, CartridgeSystem cartridgeSystem, CollectSystem collectSystem) {
            super("1ball", driveSystem.getAutoGains(), driveSystem, navX);
            Constants.oneBall.inReverse();

            addCommands(new ParallelDeadlineGroup(new TimeCommand(5000),
             new changeSelenoidCommand(collectSystem, false) ,
             new ShootingCommand(shootingSystem, cartridgeSystem, true)));
             addCommands(new ParallelDeadlineGroup(addFollowPathCommand(Constants.oneBall, new EncoderAndNavxDriveControl(driveSystem, navX)),new changeSelenoidCommand(collectSystem, true)));
;
            // addCommands(new TimeCommand(3000));
            // addCommands();

    }
}

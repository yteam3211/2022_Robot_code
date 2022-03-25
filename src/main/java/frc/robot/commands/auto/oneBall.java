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
import frc.robot.subsystems.collectSelnoid;
import frc.robot.subsystems.ShootingSystem.gains;

public class oneBall extends AutoGenerator {
    public oneBall(DriveSystem driveSystem, SuperNavX navX, ShootingSystem shootingSystem, CartridgeSystem cartridgeSystem, CollectSystem collectSystem, collectSelnoid collectSelnoid) {
            super("1ball", driveSystem.getAutoGains(), driveSystem, navX);
            Constants.forward.inReverse();

            addCommands(new ParallelDeadlineGroup(new TimeCommand(4000),
             new changeSelenoidCommand(collectSelnoid, false) ,
             new ShootingCommand(shootingSystem, cartridgeSystem, driveSystem, gains.high, true)));
             addCommands(new ParallelDeadlineGroup(addFollowPathCommand(Constants.forward, new EncoderAndNavxDriveControl(driveSystem, navX)),new changeSelenoidCommand(collectSelnoid, true)));
;
            // addCommands(new TimeCommand(3000));
            // addCommands();

    }
}

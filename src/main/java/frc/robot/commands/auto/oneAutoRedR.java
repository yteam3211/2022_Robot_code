package frc.robot.commands.auto;


import frc.robot.Constants;
import frc.robot.commands.collect.CollectCommand;
import frc.robot.commands.shooting.ShootingCommand;
import frc.util.SuperNavX;
import frc.util.commands.SetOutputCommand;
import frc.util.commands.TimeCommand;
import frc.util.pathGenerator.commandAuto.AutoGenerator;
import frc.util.pathGenerator.drive_controls.EncoderAndNavxDriveControl;
import frc.robot.subsystems.DriveSystem;
import frc.robot.subsystems.CartridgeSystem;
import frc.robot.subsystems.CollectSystem;
import frc.robot.subsystems.ShootingSystem;

public class oneAutoRedR extends AutoGenerator {
    public oneAutoRedR(DriveSystem driveSystem, SuperNavX navX, CollectSystem collectSystem,
            EncoderAndNavxDriveControl navxDriveControl,
            CartridgeSystem cartridgeSystem, ShootingSystem shootingSystem) {
        super("oneAutoRedR", driveSystem.getAutoGains(), driveSystem, navX);
        addCommands(
                deadline(new TimeCommand(3000), new ShootingCommand(shootingSystem, cartridgeSystem)),
                addFollowPathCommand(Constants.forward, navxDriveControl),
                deadline(addFollowPathCommand(Constants.forward, navxDriveControl), 
                new CollectCommand(cartridgeSystem, collectSystem)),
                deadline(addFollowPathCommand(Constants.forward), 
                new SetOutputCommand(shootingSystem, Constants.CLOSE_SHOOT_RPM),
                deadline(new TimeCommand(3000), new ShootingCommand(shootingSystem, cartridgeSystem))));
    }
}

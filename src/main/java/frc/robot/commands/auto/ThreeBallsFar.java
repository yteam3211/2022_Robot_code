package frc.robot.commands.auto;


import edu.wpi.first.wpilibj2.command.ParallelDeadlineGroup;
import edu.wpi.first.wpilibj2.command.ParallelRaceGroup;
import frc.robot.Constants;
import frc.robot.commands.collect.changeSelenoidCommand;
import frc.robot.commands.ShootingCommand;
import frc.robot.commands.collect.CollectCommand;
import frc.util.SuperNavX;
import frc.util.commands.ResetSensorsCommand;
import frc.util.commands.SetOutputCommand;
import frc.util.commands.TimeCommand;
import frc.util.commands.TurnInPlace;
import frc.util.pathGenerator.commandAuto.AutoGenerator;
import frc.util.pathGenerator.drive_controls.EncoderAndNavxDriveControl;
import frc.util.pathGenerator.drive_controls.EncoderDriveControl;
import frc.robot.subsystems.DriveSystem;
import frc.robot.subsystems.CartridgeSystem;
import frc.robot.subsystems.CollectSystem;
import frc.robot.subsystems.ShootingSystem;
import frc.robot.subsystems.collectSelnoid;

public class ThreeBallsFar extends AutoGenerator {
    public ThreeBallsFar(DriveSystem driveSystem, SuperNavX navX, CollectSystem collectSystem,
            EncoderAndNavxDriveControl navxDriveControl, collectSelnoid collectSelnoid,
            CartridgeSystem cartridgeSystem, ShootingSystem shootingSystem) {
        super("ThreeBallsFar", driveSystem.getAutoGains(), driveSystem, navX, 110);
        
        Constants.ThreeL1.inReverse();
        Constants.ThreeL3.inReverse();
        // Constants.ThreeL4.inReverse();
        addCommands(new ParallelDeadlineGroup(new TimeCommand(2000), new changeSelenoidCommand(collectSelnoid, false), new ShootingCommand(shootingSystem, cartridgeSystem, driveSystem ,true)));
        addCommands(new ParallelDeadlineGroup(addFollowPathCommand(Constants.ThreeL1, new EncoderAndNavxDriveControl(driveSystem, navX)), new changeSelenoidCommand(collectSelnoid, true)));
        addCommands(new ParallelRaceGroup(new TimeCommand(4000), new TurnInPlace(driveSystem, navX, 350, 0.7), new changeSelenoidCommand(collectSelnoid, false)));
        addCommands(new ParallelDeadlineGroup(addFollowPathCommand(Constants.ThreeL2, new EncoderAndNavxDriveControl(driveSystem, navX)),new CollectCommand(cartridgeSystem, collectSystem)));
        // addCommands(new ParallelDeadlineGroup(addFollowPathCommand(Constants.ThreeL3, new EncoderAndNavxDriveControl(driveSystem, navX)), new changeSelenoidCommand(collectSelnoid, true)));
        // addCommands(new ParallelRaceGroup(new TimeCommand(2000), new TurnInPlace(driveSystem, navX, 135, 0.7),new SetOutputCommand(shootingSystem,Constants.HIGH_SHOOT_RPM)));
        // addCommands(new ResetSensorsCommand(navX, 90));
        // addCommands(new ParallelDeadlineGroup(addFollowPathCommand(Constants.ThreeL4, new EncoderAndNavxDriveControl(driveSystem, navX)),new SetOutputCommand(shootingSystem,Constants.HIGH_SHOOT_RPM)));
        // addCommands(new ParallelDeadlineGroup(new TimeCommand(3000), new changeSelenoidCommand(collectSelnoid, false), new ShootingCommand(shootingSystem, cartridgeSystem, driveSystem ,true)));

    }
}

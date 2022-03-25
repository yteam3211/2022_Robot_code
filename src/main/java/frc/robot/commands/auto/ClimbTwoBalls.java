package frc.robot.commands.auto;


import edu.wpi.first.wpilibj2.command.ParallelDeadlineGroup;
import edu.wpi.first.wpilibj2.command.ParallelRaceGroup;
import frc.robot.Constants;
import frc.robot.commands.collect.changeSelenoidCommand;
import frc.robot.commands.ShootingCommand;
import frc.robot.commands.collect.CollectCommand;
import frc.util.SuperNavX;
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
import frc.robot.subsystems.ShootingSystem.gains;

public class ClimbTwoBalls extends AutoGenerator {
    public ClimbTwoBalls(DriveSystem driveSystem, SuperNavX navX, CollectSystem collectSystem, collectSelnoid collectSelnoid,
            EncoderAndNavxDriveControl navxDriveControl,
            CartridgeSystem cartridgeSystem, ShootingSystem shootingSystem) {
        super("CloseToClimb", driveSystem.getAutoGains(), driveSystem, navX, 200);
        Constants.LRED1.inReverse();
        addCommands(new ParallelDeadlineGroup(new TimeCommand(2500), new changeSelenoidCommand(collectSelnoid, false), new ShootingCommand(shootingSystem, cartridgeSystem, driveSystem, gains.high ,true)));
        // addCommands(new TimeCommand(500));
        addCommands(addFollowPathCommand(Constants.LRED1 ,new EncoderDriveControl(driveSystem)));
        // addCommands(new TimeCommand(500));
        addCommands(new ParallelRaceGroup(new TimeCommand(2000), new TurnInPlace(driveSystem, navX, 55, 0.5),new CollectCommand(cartridgeSystem, collectSystem)));
        addCommands(new ParallelDeadlineGroup(addFollowPathCommand(Constants.LRED2, new EncoderDriveControl(driveSystem)),new CollectCommand(cartridgeSystem, collectSystem)));
        addCommands(new ParallelRaceGroup(new TimeCommand(2000), new TurnInPlace(driveSystem, navX, 220, 0.5),new CollectCommand(cartridgeSystem, collectSystem)));
        addCommands(new ParallelDeadlineGroup(addFollowPathCommand(Constants.LRED3, new EncoderAndNavxDriveControl(driveSystem, navX)),new SetOutputCommand(shootingSystem,Constants.HIGH_SHOOT_RPM),new changeSelenoidCommand(collectSelnoid, true)));
        addCommands(new ParallelDeadlineGroup(new
         TimeCommand(7000), new ShootingCommand(shootingSystem, cartridgeSystem, driveSystem, gains.high, true), new SetOutputCommand(driveSystem, 0)));
}
}

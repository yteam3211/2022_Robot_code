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
import frc.robot.subsystems.DriveSystem;
import frc.robot.subsystems.CartridgeSystem;
import frc.robot.subsystems.CollectSystem;
import frc.robot.subsystems.ShootingSystem;

public class AutoRedL extends AutoGenerator {
    public AutoRedL(DriveSystem driveSystem, SuperNavX navX, CollectSystem collectSystem,
            EncoderAndNavxDriveControl navxDriveControl,
            CartridgeSystem cartridgeSystem, ShootingSystem shootingSystem) {
        super("CloseToClimb", driveSystem.getAutoGains(), driveSystem, navX, 200);
        Constants.LRED1.inReverse();
        addCommands(new ParallelDeadlineGroup(new TimeCommand(2500),new changeSelenoidCommand(collectSystem, false), new ShootingCommand(shootingSystem, cartridgeSystem,true)));
        addCommands(addFollowPathCommand(Constants.LRED1, new EncoderAndNavxDriveControl(driveSystem, navX)));
        addCommands(new ParallelRaceGroup(new TimeCommand(2500), new TurnInPlace(driveSystem, navX, 50)));
        addCommands(new ParallelDeadlineGroup(addFollowPathCommand(Constants.LRED2, new EncoderAndNavxDriveControl(driveSystem, navX)),new CollectCommand(cartridgeSystem, collectSystem)));
        addCommands(new ParallelRaceGroup(new TimeCommand(2500), new TurnInPlace(driveSystem, navX, 220),new changeSelenoidCommand(collectSystem, true)));
        addCommands(new ParallelDeadlineGroup(addFollowPathCommand(Constants.LRED3, new EncoderAndNavxDriveControl(driveSystem, navX)),new SetOutputCommand(shootingSystem,Constants.CLOSE_SHOOT_RPM)));
        addCommands(new ParallelDeadlineGroup(new TimeCommand(7000), new ShootingCommand(shootingSystem, cartridgeSystem, true)));
}
}

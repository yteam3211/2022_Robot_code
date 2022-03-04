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

public class ThreeBallFar extends AutoGenerator {
    public ThreeBallFar(DriveSystem driveSystem, SuperNavX navX, CollectSystem collectSystem,
            EncoderAndNavxDriveControl navxDriveControl,
            CartridgeSystem cartridgeSystem, ShootingSystem shootingSystem) {
        super("ThreeBallFar", driveSystem.getAutoGains(), driveSystem, navX, 200);
        Constants.TP1.inReverse();
        Constants.TP3.inReverse();
        addCommands(new ParallelDeadlineGroup(new TimeCommand(2500),new changeSelenoidCommand(collectSystem, false), new ShootingCommand(shootingSystem, cartridgeSystem,true)));
        addCommands(new ParallelDeadlineGroup(addFollowPathCommand(Constants.TP1, new EncoderAndNavxDriveControl(driveSystem, navX)),new changeSelenoidCommand(collectSystem, true)));
        addCommands(new ParallelRaceGroup(new TimeCommand(2500), new TurnInPlace(driveSystem, navX, 320), new changeSelenoidCommand(collectSystem, false)));
        addCommands(new ParallelDeadlineGroup(addFollowPathCommand(Constants.TP2, new EncoderAndNavxDriveControl(driveSystem, navX)),new CollectCommand(cartridgeSystem, collectSystem)));
        addCommands(addFollowPathCommand(Constants.TP3, new EncoderAndNavxDriveControl(driveSystem, navX)),new changeSelenoidCommand(collectSystem, true));
        addCommands(new ParallelRaceGroup(new TimeCommand(2000), new TurnInPlace(driveSystem, navX, 90)));
        addCommands(new ParallelDeadlineGroup(addFollowPathCommand(Constants.TP4, new EncoderAndNavxDriveControl(driveSystem, navX)), new SetOutputCommand(shootingSystem, Constants.CLOSE_SHOOT_RPM)));
        addCommands(new ParallelDeadlineGroup(new TimeCommand(7000), new ShootingCommand(shootingSystem, cartridgeSystem, true)));
    }
}

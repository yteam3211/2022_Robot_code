package frc.robot.commands.auto;


import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.ParallelDeadlineGroup;
import edu.wpi.first.wpilibj2.command.ParallelRaceGroup;
import frc.robot.Constants;
import frc.robot.commands.collect.changeSelenoidCommand;
import frc.robot.commands.ShootingCommand;
import frc.robot.commands.collect.CollectCommand;
import frc.util.SuperNavX;
import frc.util.commands.TimeCommand;
import frc.util.commands.TurnInPlace;
import frc.util.pathGenerator.commandAuto.AutoGenerator;
import frc.util.pathGenerator.drive_controls.EncoderAndNavxDriveControl;
import frc.robot.subsystems.CartridgeSystem;
import frc.robot.subsystems.CollectSystem;
import frc.robot.subsystems.DriveSystem;
import frc.robot.subsystems.ShootingSystem;

public class RightTwoBalls extends AutoGenerator {
    public RightTwoBalls(DriveSystem driveSystem, SuperNavX navX, ShootingSystem shootingSystem, CartridgeSystem cartridgeSystem, CollectSystem collectSystem) {
            super("RightTwoBalls", driveSystem.getAutoGains(), driveSystem, navX, 110);
            
            Constants.RTB1.inReverse();
            addCommands(new ParallelDeadlineGroup(new TimeCommand(2500),new changeSelenoidCommand(collectSystem, false), new ShootingCommand(shootingSystem, cartridgeSystem,true)));
            addCommands(new ParallelDeadlineGroup(addFollowPathCommand(Constants.RTB1, new EncoderAndNavxDriveControl(driveSystem, navX)),new changeSelenoidCommand(collectSystem, true)));
            addCommands(new ParallelRaceGroup(new TimeCommand(2000), new TurnInPlace(driveSystem, navX, 340)),new changeSelenoidCommand(collectSystem, false));
            addCommands(new ParallelDeadlineGroup(addFollowPathCommand(Constants.RTB2, new EncoderAndNavxDriveControl(driveSystem, navX)),new CollectCommand(cartridgeSystem, collectSystem)));
            addCommands(new ParallelRaceGroup(new TimeCommand(2000), new TurnInPlace(driveSystem, navX, 150)),new changeSelenoidCommand(collectSystem, true));
            addCommands(new ParallelDeadlineGroup(addFollowPathCommand(Constants.RTB3, new EncoderAndNavxDriveControl(driveSystem, navX)),new changeSelenoidCommand(collectSystem, true)));
            addCommands(new ParallelDeadlineGroup(new TimeCommand(2500), new ShootingCommand(shootingSystem, cartridgeSystem, true)));

    }
}

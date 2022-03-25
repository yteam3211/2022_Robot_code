package frc.robot.commands.auto;


import edu.wpi.first.wpilibj2.command.ParallelDeadlineGroup;
import edu.wpi.first.wpilibj2.command.ParallelRaceGroup;
import frc.robot.Constants;
import frc.robot.commands.collect.changeSelenoidCommand;
import frc.robot.commands.ShootingCommand;
import frc.robot.commands.VisionCommand;
import frc.robot.commands.collect.CollectCommand;
import frc.util.SuperNavX;
import frc.util.commands.ResetSensorsCommand;
import frc.util.commands.SetOutputCommand;
import frc.util.commands.TimeCommand;
import frc.util.commands.TurnInPlace;
import frc.util.pathGenerator.commandAuto.AutoGenerator;
import frc.util.pathGenerator.drive_controls.EncoderAndNavxDriveControl;
import frc.util.vision.Limelight;
import frc.robot.subsystems.DriveSystem;
import frc.robot.subsystems.CartridgeSystem;
import frc.robot.subsystems.CollectSystem;
import frc.robot.subsystems.ShootingSystem;
import frc.robot.subsystems.collectSelnoid;
import frc.robot.subsystems.ShootingSystem.gains;

public class ThreeBallsFar extends AutoGenerator {
    public ThreeBallsFar(DriveSystem driveSystem, SuperNavX navX, CollectSystem collectSystem,
            EncoderAndNavxDriveControl navxDriveControl, collectSelnoid collectSelnoid,
            CartridgeSystem cartridgeSystem, ShootingSystem shootingSystem, Limelight limelight) {
        super("ThreeBallsFar", driveSystem.getAutoGains(), driveSystem, navX, 110);
        
        Constants.ThreeL1.inReverse();
        Constants.ThreeL3.inReverse();
        // Constants.ThreeL4.inReverse();
        addCommands(new ParallelDeadlineGroup(new TimeCommand(1300), new changeSelenoidCommand(collectSelnoid, false), new ShootingCommand(shootingSystem, cartridgeSystem, driveSystem ,true)));
        addCommands(new ParallelDeadlineGroup(addFollowPathCommand(Constants.ThreeL1, new EncoderAndNavxDriveControl(driveSystem, navX)), new changeSelenoidCommand(collectSelnoid, true)));
        addCommands(new ParallelRaceGroup(new TimeCommand(4000), new TurnInPlace(driveSystem, navX, -10, 0.7), new changeSelenoidCommand(collectSelnoid, false)));
        addCommands(new ResetSensorsCommand(navX, 350));
        addCommands(new ParallelDeadlineGroup(addFollowPathCommand(Constants.ThreeL2, new EncoderAndNavxDriveControl(driveSystem, navX)),new CollectCommand(cartridgeSystem, collectSystem)));
        addCommands(new ResetSensorsCommand(navX, 350));
        addCommands(new ParallelDeadlineGroup(addFollowPathCommand(Constants.ThreeL3, new EncoderAndNavxDriveControl(driveSystem, navX)), new changeSelenoidCommand(collectSelnoid, true)));
        addCommands(new ParallelRaceGroup(new TimeCommand(2000), new TurnInPlace(driveSystem, navX, 165, 0.7), new SetOutputCommand(shootingSystem, 13200)));
        addCommands(new VisionCommand(limelight, shootingSystem, cartridgeSystem, driveSystem, navX, true));
        // addCommands(new ParallelDeadlineGroup(addFollowPathCommand(Constants.ThreeL4, new EncoderAndNavxDriveControl(driveSystem, navX))));
        // addCommands(new ParallelDeadlineGroup(new TimeCommand(3000), new ShootingCommand(shootingSystem, cartridgeSystem, driveSystem ,true)));

    }
}

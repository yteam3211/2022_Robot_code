package frc.robot.commands.auto;

import frc.robot.Constants;
import frc.robot.commands.ShootingCommand;
import frc.util.SuperNavX;
import frc.util.pathGenerator.commandAuto.AutoGenerator;
import frc.util.pathGenerator.drive_controls.EncoderAndNavxDriveControl;
import frc.robot.subsystems.CartridgeSystem;
import frc.robot.subsystems.CollectSystem;
import frc.robot.subsystems.DriveSystem;
import frc.robot.subsystems.ShootingSystem;

public class TestAuto extends AutoGenerator {
        public TestAuto(DriveSystem driveSystem, SuperNavX navX,
        CartridgeSystem cartridgeSystem, ShootingSystem shootingSystem) {
                super("TestAuto", driveSystem.getAutoGains(), driveSystem, navX);
                addCommands( new ShootingCommand(shootingSystem, cartridgeSystem, driveSystem,true));
        }
}

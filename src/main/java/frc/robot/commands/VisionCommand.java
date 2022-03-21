// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.ParallelRaceGroup;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.Constants;
import frc.robot.subsystems.CartridgeSystem;
import frc.robot.subsystems.DriveSystem;
import frc.robot.subsystems.ShootingSystem;
import frc.util.SuperNavX;
import frc.util.commands.SetOutputCommand;
import frc.util.commands.TurnInPlace;
import frc.util.vision.Limelight;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class VisionCommand extends SequentialCommandGroup {
  public VisionCommand(Limelight limelight, ShootingSystem shootingSystem, CartridgeSystem cartridgeSystem, DriveSystem driveSystem, SuperNavX navX) {
    if (!limelight.isValid()){
      addCommands(new ShootingCommand(shootingSystem, cartridgeSystem, driveSystem, false));
    }
    else{
      addCommands(new ParallelRaceGroup(new TurnInPlace(driveSystem, navX, 30, 0.7), new SetOutputCommand(shootingSystem, Constants.HIGH_SHOOT_RPM)));
      addCommands(new ShootingCommand(shootingSystem, cartridgeSystem, driveSystem, limelight));
    }
  }
}

// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import java.util.Map;

import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.ParallelDeadlineGroup;
import edu.wpi.first.wpilibj2.command.ParallelRaceGroup;
import edu.wpi.first.wpilibj2.command.SelectCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.Constants;
import frc.robot.subsystems.CartridgeSystem;
import frc.robot.subsystems.DriveSystem;
import frc.robot.subsystems.ShootingSystem;
import frc.util.SuperNavX;
import frc.util.commands.ResetSensorsCommand;
import frc.util.commands.SetOutputCommand;
import frc.util.commands.TimeCommand;
import frc.util.commands.TurnInPlace;
import frc.util.commands.TurnInPlaceLimelight;
import frc.util.vision.Limelight;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class VisionCommand extends SequentialCommandGroup {
  Limelight limelight;
  public VisionCommand(Limelight limelight, ShootingSystem shootingSystem, CartridgeSystem cartridgeSystem, DriveSystem driveSystem, SuperNavX navX) {
    this.limelight =limelight;
    addCommands(new SelectCommand(Map.ofEntries(
      Map.entry(0, new ShootingCommand(shootingSystem, cartridgeSystem, driveSystem, false)),
      Map.entry(1, new SequentialCommandGroup( new ParallelRaceGroup(new TimeCommand(1500),new TurnInPlaceLimelight(driveSystem, limelight)), new ShootingCommand(shootingSystem, cartridgeSystem, driveSystem, limelight)))),
      this::select));
      addCommands();
  }
  public int select(){
    return limelight.isValid() ? 1 : 0;
  };
}

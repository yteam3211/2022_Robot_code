// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.collect;

import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.CollectSystem;
import frc.util.commands.SetOutputCommand;
import frc.util.commands.SolenoidChangePositionCommand;

public class DefueltCollectCommand extends SequentialCommandGroup {
  public DefueltCollectCommand(CollectSystem collect) {
    super(
        new ParallelCommandGroup(
            new SetOutputCommand(collect, 0),
            new SolenoidChangePositionCommand(collect.SOLENOID, true)));
  }
}

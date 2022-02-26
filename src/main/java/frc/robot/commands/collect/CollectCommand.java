// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.collect;

import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import frc.robot.commands.CartridgeCommand;
import frc.robot.subsystems.CartridgeSystem;
import frc.robot.subsystems.CollectSystem;
import frc.util.commands.SetOutputCommand;
import frc.util.commands.SolenoidChangePositionCommand;

public class CollectCommand extends ParallelCommandGroup {
  public CollectCommand(CartridgeSystem cartridge, CollectSystem collect) {
    addCommands(
        new SolenoidChangePositionCommand(collect.SOLENOID, false),
        new SetOutputCommand(collect, -1),
        new CartridgeCommand(cartridge));
  }
}

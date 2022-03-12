// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.collect;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.CollectSystem;

public class CollectAndOpen extends CommandBase {
  CollectSystem collectSystem;
  Joystick joystick;
  public CollectAndOpen(CollectSystem collectSystem, Joystick joystick) {
    this.collectSystem = collectSystem;
    this.joystick = joystick;
    addRequirements(collectSystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    collectSystem.SOLENOID.changePosition(false);
    if ( joystick.getRawAxis(2) > 0.02) collectSystem.setOutput(-1);
    else collectSystem.setOutput(0);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}

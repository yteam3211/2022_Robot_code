// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.collect;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.CollectSystem;

public class changeSelenoidCommand extends CommandBase {
  /** Creates a new CloseCollectCommand. */
  CollectSystem collectSystem;
  boolean open;
  public changeSelenoidCommand(CollectSystem collectSystem, boolean open) {
    addRequirements(collectSystem);
    this.collectSystem = collectSystem;
    this.open = open;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {

  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    collectSystem.SOLENOID.changePosition(open);

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

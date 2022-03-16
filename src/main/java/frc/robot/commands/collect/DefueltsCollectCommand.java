// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.collect;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.CollectSystem;
import frc.robot.subsystems.collectSelnoid;

public class DefueltsCollectCommand extends CommandBase {
  /** Creates a new DefueltsCollectCommand. */
  collectSelnoid collectSystem; 
  public DefueltsCollectCommand(collectSelnoid collectSystem) {
    addRequirements(collectSystem);
    this.collectSystem = collectSystem;
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    collectSystem.SOLENOID.changePosition(true);
    collectSystem.getTab().putInDashboard("Closed", true, false);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {}

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}

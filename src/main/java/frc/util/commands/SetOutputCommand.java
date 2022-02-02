// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.util.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.util.OutputSystem;

public class SetOutputCommand extends CommandBase {
  /** Creates a new SetOutputCommand. */
  OutputSystem outputSystem;
  double output;
  public SetOutputCommand(OutputSystem outputSystem, double output) {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(outputSystem);
    this.outputSystem = outputSystem;
    this.output = output;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    outputSystem.setOutput(output);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    outputSystem.setOutput(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}

// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.util.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveSystem;
import frc.util.vision.Limelight;

public class TurnInPlaceLimelight extends CommandBase {
  /** Creates a new TurnInPlaceLimelight. */
  DriveSystem driveSystem;
   Limelight limelight;
   int count = 0;
  public TurnInPlaceLimelight(DriveSystem driveSystem, Limelight limelight) {
    addRequirements(driveSystem);
    this.driveSystem = driveSystem;
    this.limelight = limelight;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double x =  limelight.getX();
    double output = 0.00022 * x * x + 0.02259 * x + 0.06250;
    output = x > 0 ? output : -output;
    driveSystem.tank(output, -output);
  
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    driveSystem.setOutput(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    if(Math.abs(limelight.getX()) < 1) count++;
    else count = 0;
    return count > 5;
  }
}

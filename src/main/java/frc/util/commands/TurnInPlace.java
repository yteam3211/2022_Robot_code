// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.util.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveSystem;
import frc.util.SuperNavX;
import frc.util.PID.Gains;

public class TurnInPlace extends CommandBase {
  DriveSystem driveSystem;
  SuperNavX navX;
  double angle;
  int count, reverse;
  Gains gains;
  double LastAngle;
  public TurnInPlace(DriveSystem driveSystem, SuperNavX navX, double angle) {
    addRequirements(driveSystem);
    this.angle = angle;
    this.driveSystem = driveSystem;
    this.navX = navX;
    this.gains = driveSystem.getTurnGains();
    count = 0;
    // this.reverse = reverse ? -1 : 1;
    this.reverse = 1;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double errorAngle = navX.getAngle360() - angle;
    driveSystem.tank(reverse * ( gains.kp * errorAngle + gains.kd * (errorAngle - LastAngle)), 
    -1 * reverse *  (gains.kp * errorAngle + gains.kd * (errorAngle - LastAngle)));
    LastAngle = errorAngle; 
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    System.out.println(angle);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    if(Math.abs(angle - navX.getAngle360()) < 1) count++;
    else count = 0;
    return count > 10;
  }
}

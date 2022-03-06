// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.RobotButtons;
import frc.robot.RobotContainer;
import frc.robot.subsystems.CartridgeSystem;
import frc.robot.subsystems.ShootingSystem;


public class ShootingCommand extends CommandBase {
  /** Creates a new ShootingCommand. */

  ShootingSystem shootingSystem;
  CartridgeSystem cartridgeSystem;



  final int rpmDist = 1;
  private boolean auto;
  private boolean high;

  public ShootingCommand(ShootingSystem shootingSystem, CartridgeSystem cartridgeSystem, boolean auto) {
    addRequirements(cartridgeSystem, shootingSystem);
    this.cartridgeSystem = cartridgeSystem;
    this.shootingSystem = shootingSystem;
    this.auto = auto;
    this.high = true;
  }

  public ShootingCommand(ShootingSystem shootingSystem, CartridgeSystem cartridgeSystem,Boolean high, boolean auto) {
    addRequirements(cartridgeSystem, shootingSystem);
    this.cartridgeSystem = cartridgeSystem;
    this.shootingSystem = shootingSystem;
    this.auto = auto;
    this.high = high;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    int output = high? RobotContainer.RPMHigh : RobotContainer.RPMLow;
    shootingSystem.setOutput(output);
    double error = shootingSystem.getFrontVelocity() - output;
    if(error < 100 && error > -100
     && (RobotButtons.coPilotJoystick.getRawButton(6) ||
      RobotButtons.coPilotJoystick.getRawButton(7) || auto)){
      cartridgeSystem.setOutput(Constants.CARITAGE_SPEED); 
    }
    else {
      cartridgeSystem.setOutput(0.2);
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    cartridgeSystem.setOutput(0);
    shootingSystem.setOutput(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}

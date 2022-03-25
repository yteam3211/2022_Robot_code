// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import com.revrobotics.CANSparkMax.IdleMode;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.RobotButtons;
import frc.robot.RobotContainer;
import frc.robot.subsystems.CartridgeSystem;
import frc.robot.subsystems.DriveSystem;
import frc.robot.subsystems.ShootingSystem;
import frc.robot.subsystems.ShootingSystem.gains;
import frc.util.vision.Limelight;

public class ShootingCommand extends CommandBase {
  /** Creates a new ShootingCommand. */

  ShootingSystem shootingSystem;
  CartridgeSystem cartridgeSystem;

  final int rpmDist = 1;
  private boolean auto;
  private gains mode;
  private DriveSystem driveSystem;
  private Limelight  limelight = null;
  private double output = 0;

  public ShootingCommand(ShootingSystem shootingSystem, CartridgeSystem cartridgeSystem, DriveSystem driveSystem , boolean auto) {
    addRequirements(cartridgeSystem, shootingSystem);
    this.driveSystem = driveSystem;
    this.cartridgeSystem = cartridgeSystem;
    this.shootingSystem = shootingSystem;
    this.auto = auto;
    this.mode = Constants.DEFULT_SHOOT;
  }

  public ShootingCommand(ShootingSystem shootingSystem, CartridgeSystem cartridgeSystem,DriveSystem driveSystem ,gains mode, boolean auto) {
    addRequirements(cartridgeSystem, shootingSystem);
    this.driveSystem = driveSystem;
    this.cartridgeSystem = cartridgeSystem;
    this.shootingSystem = shootingSystem;
    this.auto = auto;
    this.mode = mode;
  }

  public ShootingCommand(ShootingSystem shootingSystem, CartridgeSystem cartridgeSystem,DriveSystem driveSystem, Limelight limelight) {
    addRequirements(cartridgeSystem, shootingSystem);
    this.driveSystem = driveSystem;
    this.cartridgeSystem = cartridgeSystem;
    this.shootingSystem = shootingSystem;
    this.auto = false;
    this.mode = gains.lime;
    this.limelight = limelight;
  }

  public ShootingCommand(ShootingSystem shootingSystem, CartridgeSystem cartridgeSystem,DriveSystem driveSystem, Limelight limelight, boolean auto) {
    addRequirements(cartridgeSystem, shootingSystem);
    this.driveSystem = driveSystem;
    this.cartridgeSystem = cartridgeSystem;
    this.shootingSystem = shootingSystem;
    this.auto = auto;
    this.mode = gains.lime;
    this.limelight = limelight;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    if (mode == gains.lime && !limelight.isValid()) {
      mode = gains.high;
    }
    shootingSystem.changeStation(mode);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if (limelight != null && limelight.isValid()) {
      double y = limelight.getY();
      // output = 19500 + 985 * y + 55.2 * Math.pow(y, 2) + 1.13 * Math.pow(y , 3);
      output = 19500 + 985 * y + 55.2 * Math.pow(y, 2) + 1.13 * Math.pow(y , 3);
      // output = 15642 + 177 * y;
      // output = 14988 + 141 * y;
    }
    else {
      output = (mode == gains.low ? RobotContainer.RPMLow : RobotContainer.RPMHigh);
    }
    shootingSystem.setOutput(output);

    double error = shootingSystem.getFrontVelocity() - output;
    if(error < 100 && error > -50 && (RobotButtons.coPilotJoystick.getRawButton(6) ||
                                  RobotButtons.coPilotJoystick.getRawButton(7) || auto)){
      cartridgeSystem.setOutput(mode == gains.high ? Constants.CARITAGE_SPEED : Constants.CARITAGE_SPEED_LOW); 
      driveSystem.changeIdleMode(IdleMode.kBrake);
    }
    else {
      cartridgeSystem.setOutput(0);
      if(!auto) driveSystem.changeIdleMode(IdleMode.kCoast);
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    if(!auto) driveSystem.changeIdleMode(IdleMode.kCoast);
    cartridgeSystem.setOutput(0);
    shootingSystem.setOutput(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
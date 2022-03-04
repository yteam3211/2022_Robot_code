// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.TalonFXControlMode;

import frc.robot.Constants;
import frc.robot.RobotContainer;
import frc.util.OutputSystem;
import frc.util.PID.Gains;
import frc.util.motor.SuperTalonFX;

public class ShootingSystem extends OutputSystem {
  private Gains shootGains = new Gains("shoot", 0,0,0.16, 0.0005, 0.1, Constants.CLOSE_SHOOT_RPM /  615000.0,0);

  private SuperTalonFX masterMotor = new SuperTalonFX(Constants.CAN_SHOOT_MASTER_MOTOR, 30, true,
      false, NeutralMode.Coast, shootGains, TalonFXControlMode.Velocity);
  private SuperTalonFX salveMotor = new SuperTalonFX(masterMotor, Constants.CAN_SHOOT_SLAVE_MOTOR, 30, false);
  // private SuperTalonFX backMotor = new SuperTalonFX(Constants.CAN_SHOOT_BACK_MOTOR, 10, true, false, NeutralMode.Coast,
      // shootGains, TalonFXControlMode.Velocity);

  public ShootingSystem() {
    super("Shooting");
  }

  @Override
  public void periodic() {
    getTab().putInDashboard("Velocity", masterMotor.getVelocity(), true);
    getTab().putInDashboard("SHOOT?", Math.abs(getFrontVelocity() - RobotContainer.RPM) < 100 , false);
    // getTab().putInDashboard("VelocityB", backMotor.getVelocity(), false);
  }

  @Override
  public void setOutput(double output) {
    if (output == 0) {
      masterMotor.set(TalonFXControlMode.PercentOutput, 0);
    } else {
      masterMotor.setOutput(output);
    }
  }

  public double getFrontVelocity() {
    return masterMotor.getVelocity();
  }

  public Gains getGains(){
    return shootGains;
  }
}
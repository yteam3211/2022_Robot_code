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
  private Gains shootGains = new Gains("shoot", 0.15, 0.001, 0.4);

  private SuperTalonFX frountMotor = new SuperTalonFX(Constants.CAN_SHOOT_FROUNT_MOTOR, 10, true,
      false, NeutralMode.Coast, shootGains, TalonFXControlMode.Velocity);
  private SuperTalonFX backMotor = new SuperTalonFX(Constants.CAN_SHOOT_BACK_MOTOR, 10, true, false, NeutralMode.Coast,
      shootGains, TalonFXControlMode.Velocity);

  public ShootingSystem() {
    super("ShootingSystem");
  }

  @Override
  public void periodic() {
    getTab().putInDashboard("VelocityF", frountMotor.getVelocity(), true);
    getTab().putInDashboard("VelocityB", backMotor.getVelocity(), true);
  }

  @Override
  public void setOutput(double output) {
    if (output == 0) {
      frountMotor.set(TalonFXControlMode.PercentOutput, 0);
      backMotor.set(TalonFXControlMode.PercentOutput, 0);
    } else {
      frountMotor.setOutput(output);
      backMotor.setOutput(output * RobotContainer.ratio);
    }
  }
}
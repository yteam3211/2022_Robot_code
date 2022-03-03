// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.TalonFXControlMode;

import frc.robot.Constants;
import frc.util.OutputSystem;
import frc.util.PID.Gains;
import frc.util.motor.SuperTalonFX;

public class ShootingSystem extends OutputSystem {
  private Gains shootGains = new Gains("shoot", 0.22, 0.0005, 0.7);

  private SuperTalonFX frontMotor = new SuperTalonFX(Constants.CAN_SHOOT_FRONT_MOTOR, 10, true,
      false, NeutralMode.Coast, shootGains, TalonFXControlMode.Velocity);
  //private SuperTalonFX frontMotorSlave = new SuperTalonFX(Constants.CAN_SHOOT_FRONT_MOTOR_SLAVE, 10, false,
  //    false, NeutralMode.Coast, shootGains, TalonFXControlMode.Velocity);
  // private SuperTalonFX backMotor = new SuperTalonFX(Constants.CAN_SHOOT_BACK_MOTOR, 10, true, false, NeutralMode.Coast,
      // shootGains, TalonFXControlMode.Velocity);

  public ShootingSystem() {
    super("Shooting");
  }

  @Override
  public void periodic() {
    getTab().putInDashboard("VelocityF", frontMotor.getVelocity(), true);
    getTab().putInDashboard("SHOOT?", Math.abs(getFrontVelocity() - Constants.CLOSE_SHOOT_RPM) < 100 , false);
    // getTab().putInDashboard("VelocityB", backMotor.getVelocity(), false);
  }

  @Override
  public void setOutput(double output) {
    if (output == 0) {
      frontMotor.set(TalonFXControlMode.PercentOutput, 0);
    } else {
      frontMotor.setOutput(output);
    }
  }

  public double getFrontVelocity() {
    return frontMotor.getVelocity();
  }

  public Gains getGains(){
    return shootGains;
  }
}
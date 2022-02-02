// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.TalonFXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.util.OutputSystem;
import frc.util.PID.Gains;
import frc.util.motor.SuperTalonFX;

public class ShootingSystem extends OutputSystem {
  /** Creates a new ShootingSystem. */
  Gains shootGains = new Gains("shoot", 0, 0, 0);
  SuperTalonFX appM = new SuperTalonFX(Constants.CAN_SHOOT_UP_MOTOR, 10, false/* inverted */,
      false/* sensor inverted */, NeutralMode.Coast, shootGains, TalonFXControlMode.Velocity);
  SuperTalonFX downM = new SuperTalonFX(Constants.CAN_SHOOT_DOWN_MOTOR, 10, false/* inverted */,
      false/* sensor inverted */, NeutralMode.Coast, shootGains, TalonFXControlMode.Velocity);
  double outputRatio;

  public ShootingSystem() {
    super("ShootingSystem");
  }

  @Override
  public void periodic() {
    outputRatio = getTab().getFromDashboard("ratio", 0);
    // This method will be called once per scheduler run
  }

  @Override
  public void setOutput(double output) {
    appM.setOutput(output);
    downM.setOutput(output * outputRatio);
  }
}

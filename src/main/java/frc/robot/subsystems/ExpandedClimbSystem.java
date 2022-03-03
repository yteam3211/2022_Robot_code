// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.util.OutputSystem;

public class ExpandedClimbSystem extends OutputSystem{
   
  private VictorSPX climbMotorLeft;
  private TalonSRX climbMotorRight;
  public ExpandedClimbSystem() {
    super("ExClimb");
    climbMotorLeft = new VictorSPX(Constants.CAN_CLIMB_MOTOR_LEFT);
    climbMotorLeft.setNeutralMode(NeutralMode.Brake);
    climbMotorRight = new TalonSRX(Constants.CAN_CLIMB_MOTOR_RIGHT);
    climbMotorRight.setNeutralMode(NeutralMode.Brake);
    climbMotorLeft.follow(climbMotorRight);
  }

  @Override
  public void periodic() {
    
  }

  @Override
  public void setOutput(double output) {
     climbMotorRight.set(ControlMode.PercentOutput, output);
  }
}

// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.util.OutputSystem;

public class ExpandedClimbSystem extends OutputSystem{
   
  private TalonSRX climbMotorLeft;
  private TalonSRX climbMotorRight;
  private DigitalInput magnetExClimb = new DigitalInput(Constants.MAGNET_SENSOR_EXCLIMB);

  public ExpandedClimbSystem() {
    super("ExClimb");
    climbMotorLeft = new TalonSRX(Constants.CAN_CLIMB_MOTOR_LEFT);
    climbMotorLeft.setNeutralMode(NeutralMode.Brake);
    climbMotorRight = new TalonSRX(Constants.CAN_CLIMB_MOTOR_RIGHT);
    climbMotorRight.setNeutralMode(NeutralMode.Brake);
  }
  @Override
  public void periodic() {
    
  }

  @Override
  public void setOutput(double output) {
    if(getMagnetMode() && output < 0) output = 0;
     climbMotorRight.set(ControlMode.PercentOutput, output);
     climbMotorLeft.set(ControlMode.PercentOutput, -output);
  }

  public boolean getMagnetMode(){
    return !magnetExClimb.get();
  }
}

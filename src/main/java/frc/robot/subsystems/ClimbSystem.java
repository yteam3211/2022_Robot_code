// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.util.OutputSystem;
import frc.util.motor.SuperTalonSRX;

public class ClimbSystem extends OutputSystem {
  
  
  private SuperTalonSRX climbMotor;
  public ClimbSystem() {
    super("climbSystem");
    climbMotor = new SuperTalonSRX(Constants.CAN_CLIMB_MOTOR, Constants.AMPER_LIMIT_CLIMB , false);
    climbMotor.setNeutralMode(NeutralMode.Brake);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  @Override
  public void setOutput(double output) {
    climbMotor.set(TalonSRXControlMode.PercentOutput, output);    
  }

  public void setPosition(double position) {
    climbMotor.set(TalonSRXControlMode.Position, position);    
  }


}

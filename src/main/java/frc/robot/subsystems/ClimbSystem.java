// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.util.OutputSystem;
import frc.util.motor.SuperTalonSRX;

public class ClimbSystem extends OutputSystem {
  
  private DigitalInput magnetSensorUp = new DigitalInput(Constants.MAGNET_SENSOR_UP);
  private DigitalInput magnetSensorDown = new DigitalInput(Constants.MAGNET_SENSOR_DOWN);
  private DigitalInput swichSensorDown = new DigitalInput(Constants.SWICH_SENSOR_DOWN);
  private VictorSPX climbMotor;

  public ClimbSystem() {
    super("climb");
    climbMotor = new VictorSPX(Constants.CAN_CLIMB_MOTOR);
    climbMotor.setNeutralMode(NeutralMode.Brake);
  }

  @Override
  public void periodic() {
    getTab().putInDashboard("upSensor", getMagnetModeUp(), false);
    getTab().putInDashboard("downSensor", getMagnetModeDown(), false);
    getTab().putInDashboard("swichSensor", getSwichModeDown(), false);
  }

  @Override
  public void setOutput(double output) {
    if(getMagnetModeUp() && output < 0) output = 0;
    if( (getSwichModeDown() || getMagnetModeDown()) && output > 0) output = 0;
    climbMotor.set(ControlMode.PercentOutput, output); 
  }
  
  public boolean getMagnetModeUp(){
    return !magnetSensorUp.get();
  }
  public boolean getMagnetModeDown(){
    return !magnetSensorDown.get();
  }


  public boolean getSwichModeDown(){
    return !swichSensorDown.get();
  }


}

// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.VictorSP;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.util.OutputSystem;
import frc.util.SuperSolenoid;

public class CollectingSystem extends OutputSystem {
  /** Creates a new CollectingSystem. */
  VictorSP collectMotor = new VictorSP(Constants.CAN_COLLECT_MOTOR);
  SuperSolenoid collectSolenoid = new SuperSolenoid("collectSolenoid", Constants.COLLECT_SOLENOID, false);
  public CollectingSystem() {
    super("CollectingSystem");
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  @Override
  public void setOutput(double output) {
    collectMotor.set(output);
  }


  public void changeSolenoid(){
    collectSolenoid.changePosition();
  }



  public SuperSolenoid getSolenoid(){
    return collectSolenoid;
  }
}

// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.commands.collect.DefueltsCollectCommand;
import frc.util.OutputSystem;
import frc.util.SuperSolenoid;

public class collectSelnoid extends OutputSystem {
  /** Creates a new collectSelnoid. */
  public static final SuperSolenoid SOLENOID = new SuperSolenoid("collectSolenoid", Constants.COLLECT_SOLENOID, false);
  public collectSelnoid() {
    super("collectSelnoid");
    setDefaultCommand(new DefueltsCollectCommand(this));
  }

  @Override
  public void periodic() {
    getTab().putInDashboard("Closed", SOLENOID.isForward(), true);
  }

  @Override
  public void setOutput(double output) {
      // CollectSystem.    
  }
}

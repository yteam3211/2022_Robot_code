/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.subsystems.CartridgeSystem;
import frc.robot.subsystems.CollectingSystem;
import frc.robot.subsystems.ShootingSystem;
import frc.util.commands.SetOutputCommand;
import frc.util.commands.SolenoidChangePositionCommand;

public class RobotButtons {
    // all joysticks:
    public static Joystick driverJoystick = new Joystick(0);
    public Trigger shootButton = new Trigger(() -> driverJoystick.getRawButton(4));
    public Trigger cartridgeButton = new Trigger(() -> driverJoystick.getRawButton(1));
    public Trigger collectButton = new Trigger(() -> driverJoystick.getRawButton(2));
    public Trigger collectSolenoidButton = new Trigger(() -> driverJoystick.getRawButton(3));

    public void loadButtons(ShootingSystem shoot, CartridgeSystem cartridge, CollectingSystem collect) {
        shootButton.whileActiveOnce(new SetOutputCommand(shoot, shoot.getTab().getFromDashboard("RPM", 0)));
        cartridgeButton.whileActiveOnce(new SetOutputCommand(cartridge, cartridge.getTab().getFromDashboard("speed", 0)));
        collectButton.whileActiveOnce(new SetOutputCommand(collect, 0.7));
        collectSolenoidButton.whenActive(new SolenoidChangePositionCommand(collect.getSolenoid()));
    }
}

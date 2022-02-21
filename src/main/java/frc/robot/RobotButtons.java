/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.commands.collect.CollectCommand;
import frc.robot.commands.shooting.ShootingCommand;
import frc.robot.subsystems.CartridgeSystem;
import frc.robot.subsystems.CollectSystem;
import frc.robot.subsystems.ShootingSystem;
import frc.util.commands.SetOutputCommand;
import frc.util.commands.SolenoidChangePositionCommand;

public class RobotButtons {
    // all joysticks:
    public static Joystick driverJoystick = new Joystick(0);
    public static Joystick coPilotJoystick = new Joystick(1);

    public Trigger shootButton = new Trigger(() -> coPilotJoystick.getRawAxis(3) > 0.02);
    public Trigger cartridgeButton = new Trigger(() -> coPilotJoystick.getRawButton(6));
    // public Trigger collectButton = new Trigger(() -> driverJoystick.getRawAxis(2)
    // > 0.02);
    // public Trigger collectSolenoidButton = new Trigger(() -> driverJoystick.getRawButton(5));
    public Trigger collectButton = new Trigger(() -> coPilotJoystick.getRawButton(5));

    // public Trigger shootWithCartridgeButton = new Trigger(() -> coPilotJoystick.getRawAxis(2) > 0.05);

    public void loadButtons(ShootingSystem shoot, CartridgeSystem cartridge, CollectSystem collect) {
        // shootButton.whileActiveOnce(new ShootingCommand(shoot, cartridge));// (new
        shootButton.whileActiveOnce(new SetOutputCommand(shoot,() -> RobotContainer.RPM));
        // (new
                                                                                        //    SetOutputCommand(shoot,
                                                                                           // shoot.getTab().getFromDashboard("RPM",
        // shootWithCartridgeButton.whileActiveContinuous(new ShootingCommand(shoot, cartridge));                                                                                           // 0)));
        cartridgeButton.whileActiveOnce(new SetOutputCommand(cartridge, -0.2));
        collectButton.whileActiveOnce(new CollectCommand(cartridge, collect));
        // collectSolenoidButton.whenActive(new SolenoidChangePositionCommand(collect.SOLENOID));
    }
}

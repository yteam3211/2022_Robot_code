/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.commands.ShootingCommand;
import frc.robot.commands.VisionCommand;
import frc.robot.commands.collect.changeSelenoidCommand;
import frc.robot.subsystems.CartridgeSystem;
import frc.robot.subsystems.ClimbSystem;
import frc.robot.subsystems.CollectSystem;
import frc.robot.subsystems.DriveSystem;
import frc.robot.subsystems.ExpandedClimbSystem;
import frc.robot.subsystems.ShootingSystem;
import frc.robot.subsystems.collectSelnoid;
import frc.robot.subsystems.ShootingSystem.gains;
import frc.util.SuperNavX;
import frc.util.commands.SetOutputCommand;
import frc.util.commands.SolenoidChangePositionCommand;
import frc.util.vision.Limelight;

public class RobotButtons {
    // all joysticks:
    public static Joystick driverJoystick = new Joystick(0);
    public static Joystick coPilotJoystick = new Joystick(1);

    public Trigger shootHighButton = new Trigger(() -> coPilotJoystick.getRawAxis(3) > 0.02);
    public Trigger shootLowButton = new Trigger(() -> coPilotJoystick.getRawButton(3));
    public Trigger cartridgeShootOutButton = new Trigger(() -> coPilotJoystick.getRawButton(8));
    public Trigger collectOutButton = new Trigger(() -> coPilotJoystick.getRawButton(2));
    public Trigger climbOpen = new Trigger(() -> coPilotJoystick.getPOV() == 180);
    public Trigger climbClose = new Trigger(() -> coPilotJoystick.getPOV() == 0);
    public Trigger climbExpandedClose = new Trigger(() -> driverJoystick.getRawButton(1) || coPilotJoystick.getRawButton(1));
    public Trigger climbExpandedOpen = new Trigger(() -> driverJoystick.getRawButton(4) || coPilotJoystick.getRawButton(4));
    public Trigger openCollectButton = new Trigger(() -> coPilotJoystick.getRawButton(5));
    public Trigger collectButton = new Trigger(() -> coPilotJoystick.getRawAxis(2) > 0.02);
    // public Trigger collectSolenoidButton = new Trigger(() -> driverJoystick.getRawButton(5));
    // public Trigger collectButton = new Trigger(() -> driverJoystick.getRawAxis(2) > 0.02);
    // public Trigger shootWithCartridgeButton = new Trigger(() -> coPilotJoystick.getRawAxis(2) > 0.05);

    public void loadButtons(DriveSystem driveSystem,ShootingSystem shoot, collectSelnoid collectSelnoid, CartridgeSystem cartridge, CollectSystem collect, ClimbSystem climbSystem, ExpandedClimbSystem expandedClimbSystem, Limelight limelight, SuperNavX superNavX) {
        shootHighButton.whileActiveOnce(new ShootingCommand(shoot, cartridge, driveSystem, 
        gains.high, false));// (new
        shootLowButton.whileActiveOnce(new ShootingCommand(shoot, cartridge, driveSystem, gains.low, false));// (new
        climbOpen.whileActiveOnce(new SetOutputCommand(climbSystem, 1));
        climbClose.whileActiveOnce(new SetOutputCommand(climbSystem, -1));
        collectOutButton.whileActiveOnce(new ParallelCommandGroup(new SetOutputCommand(collect, -1), new SolenoidChangePositionCommand(collectSelnoid.SOLENOID, false)));  
        cartridgeShootOutButton.whileActiveOnce(new ParallelCommandGroup(new SetOutputCommand(cartridge, 0.4),new SetOutputCommand(shoot, -3000)));
        collectButton.whileActiveOnce(new SetOutputCommand(collect, 1));
        openCollectButton.whileActiveOnce(new changeSelenoidCommand(collectSelnoid, false));
        climbExpandedClose.whileActiveOnce(new SetOutputCommand(expandedClimbSystem, 0.7));
        climbExpandedOpen.whileActiveOnce(new SetOutputCommand(expandedClimbSystem, -0.7));

        //ARCHIVE:
        // collectSolenoidButton.whenActive(new SolenoidChangePositionCommand(collect.SOLENOID));
        // cartridgeOutButton.whileActiveContinuous(new SetOutputCommand(cartridge, 0.2));                                                                                           
        // openCollectButton.whileActiveOnce(new CollectAndOpen(collect, coPilotJoystick));
        // shootWithCartridgeButton.whileActiveContinuous(new ShootingCommand(shoot, cartridge));                                                                                           
        // shootButton.whileActiveOnce(new SetOutputCommand(shoot,() -> RobotContainer.RPM));  
    }
}
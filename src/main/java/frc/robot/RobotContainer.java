// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.commands.auto.TestAuto;
import frc.robot.commands.auto.autoBlueL;
import frc.robot.commands.auto.autoBlueR;
import frc.robot.commands.auto.autoRedL;
import frc.robot.commands.auto.autoRedR;
import frc.robot.commands.auto.bowAuto;
import frc.robot.commands.auto.check;
import frc.robot.commands.auto.forwardAuto;
import frc.robot.commands.auto.oneAutoBlueL;
import frc.robot.commands.auto.oneAutoBlueM;
import frc.robot.commands.auto.oneAutoRedL;
import frc.robot.commands.auto.oneAutoRedM;
import frc.robot.subsystems.CartridgeSystem;
import frc.robot.subsystems.CollectSystem;
import frc.robot.subsystems.DriveSystem;
import frc.robot.subsystems.ShootingSystem;
import frc.util.SuperNavX;
import frc.util.pathGenerator.commandAuto.AutoChooser;
import frc.util.pathGenerator.commandAuto.AutoGenerator;
import frc.util.vision.Limelight;

/**
 * This class is where the bulk of the robot should be declared. Since
 * Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in
 * the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of
 * the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  // private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();
  public static double ratio = 0;
  public static double speed = 0;
  public static int RPM = 0; //4300 is recommended
  public static int RPM1 = 0; //4300 is recommended

  public final Limelight limelight = new Limelight.Builder().build();
  public final DriveSystem driveSystem = new DriveSystem();
  static public final CollectSystem collectingSystem = new CollectSystem();
  public final CartridgeSystem cartridgeSystem = new CartridgeSystem();
  public final ShootingSystem shootingSystem = new ShootingSystem();
  static public final SuperNavX navx = new SuperNavX();
  public final TestAuto testAuto = new TestAuto(driveSystem, navx);
  public final forwardAuto forwardAuto = new forwardAuto(driveSystem, navx);
  public final bowAuto bowAuto = new bowAuto(driveSystem, navx);
  public final check check = new check(driveSystem, navx);
  // public final autoBlueL autoBlueL = new autoBlueL(driveSystem, navx);
  // public final autoBlueR autoBlueR = new autoBlueR(driveSystem, navx);
  // public final autoRedL autoRedL = new autoRedL(driveSystem, navx);
  // public final autoRedR autoRedR = new autoRedR(driveSystem, navx);
  public final AnalogInput analogInput = new AnalogInput(Constants.ANALOG_PRESSURE);
  // public final oneAutoRedL oneAutoRedL = new oneAutoRedL(driveSystem, navx);
  // public final oneAutoRedM oneAutoRedM = new oneAutoRedM(driveSystem, navx);
  // public final oneAutoBlueL oneAutoBlueL = new oneAutoBlueL(driveSystem, navx);
  // public final oneAutoBlueM oneAutoBlueM = new oneAutoBlueM(driveSystem, navx);
public final AutoGenerator[] autoCommands = {forwardAuto, bowAuto, check/*, autoRedL, autoRedR, autoBlueL, autoBlueR, oneAutoRedL, oneAutoRedM, oneAutoBlueL, oneAutoBlueM*/};
  public final AutoChooser autoChooser = new AutoChooser(testAuto, autoCommands);
  public final RobotButtons robotButtons = new RobotButtons();
  // private final ExampleCommand m_autoCommand = new

  /**
   * The container for the robot. Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be
   * created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing
   * it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    robotButtons.loadButtons(shootingSystem,cartridgeSystem,collectingSystem);
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    // return m_autoCommand;
    return autoChooser.getAutoCommand();
    // return null;
  }
}

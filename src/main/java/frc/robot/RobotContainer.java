// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.commands.auto.TestAuto;
import frc.robot.commands.auto.ThreeBallFar;
import frc.robot.commands.auto.bowAuto;
import frc.robot.commands.auto.check;
import frc.robot.commands.auto.forwardAuto;
import frc.robot.commands.auto.ClimbTwoBalls;
import frc.robot.commands.auto.LeftTwoBalls;
import frc.robot.commands.auto.oneBall;
import frc.robot.commands.auto.RightTwoBalls;
import frc.robot.subsystems.CartridgeSystem;
import frc.robot.subsystems.ClimbSystem;
import frc.robot.subsystems.CollectSystem;
import frc.robot.subsystems.DriveSystem;
import frc.robot.subsystems.ExpandedClimbSystem;
import frc.robot.subsystems.ShootingSystem;
import frc.util.SuperNavX;
import frc.util.pathGenerator.commandAuto.AutoChooser;
import frc.util.pathGenerator.commandAuto.AutoGenerator;
import frc.util.pathGenerator.drive_controls.EncoderAndNavxDriveControl;
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
  public static int RPMHigh = Constants.HIGH_SHOOT_RPM; // 4300 is recommended
  public static int RPMLow = Constants.LOW_SHOOT_RPM; // 4300 is recommended

  public final Limelight limelight = new Limelight.Builder().build();
  public final DriveSystem driveSystem = new DriveSystem();
  static public final CollectSystem collectSystem = new CollectSystem();
  public final CartridgeSystem cartridgeSystem = new CartridgeSystem();
  public final ShootingSystem shootingSystem = new ShootingSystem();
  public final ClimbSystem climbSystem = new ClimbSystem();
  public final ExpandedClimbSystem expandedClimbSystem = new ExpandedClimbSystem();
  static public final SuperNavX navx = new SuperNavX();

  public final EncoderAndNavxDriveControl navxDriveControl = new EncoderAndNavxDriveControl(driveSystem, navx);
  public final TestAuto testAuto = new TestAuto(driveSystem, navx,
  cartridgeSystem, shootingSystem);
  public final forwardAuto forwardAuto = new forwardAuto(driveSystem, navx);
  public final bowAuto bowAuto = new bowAuto(driveSystem, navx);
  public final check check = new check(driveSystem, navx);
  public final oneBall oneBall = new oneBall(driveSystem, navx, shootingSystem, cartridgeSystem, collectSystem);
  public final RightTwoBalls twoBall = new RightTwoBalls(driveSystem, navx, shootingSystem, cartridgeSystem, collectSystem);
  public final ThreeBallFar threeBallFar = new ThreeBallFar(driveSystem, navx, collectSystem, navxDriveControl, cartridgeSystem, shootingSystem);
  public final LeftTwoBalls leftTwoBalls = new LeftTwoBalls(driveSystem, navx, collectSystem, cartridgeSystem, shootingSystem);
  public final ClimbTwoBalls autoRedL = new ClimbTwoBalls(driveSystem, navx, collectSystem, navxDriveControl, cartridgeSystem, shootingSystem);
  public final AnalogInput analogInput = new AnalogInput(Constants.ANALOG_PRESSURE);
  // public final oneAutoRedR oneAutoRedR = new oneAutoRedR(driveSystem, navx, collectSystem, navxDriveControl,
      // cartridgeSystem, shootingSystem);
  // public final oneAutoRedM oneAutoRedM = new oneAutoRedM(driveSystem, navx, collectSystem, navxDriveControl,
      // cartridgeSystem, shootingSystem);
  // public final oneAutoBlueL oneAutoBlueL = new oneAutoBlueL(driveSystem, navx);
  // public final oneAutoBlueM oneAutoBlueM = new oneAutoBlueM(driveSystem, navx);
  public final AutoGenerator[] autoCommands =  { forwardAuto, bowAuto, check, oneBall, twoBall, autoRedL, threeBallFar, leftTwoBalls};
  public final AutoChooser autoChooser = new AutoChooser(oneBall, autoCommands);
  public final RobotButtons robotButtons = new RobotButtons();
  public SendableChooser<Boolean> High;

  /**
   * The container for the robot. Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    High = new SendableChooser<>();
    High.addOption("high", Boolean.TRUE);
    High.setDefaultOption("low", Boolean.FALSE);
    SmartDashboard.putData("High", High);
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
    robotButtons.loadButtons(shootingSystem, cartridgeSystem, collectSystem, climbSystem, expandedClimbSystem);
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    return autoChooser.getAutoCommand();
  }
}

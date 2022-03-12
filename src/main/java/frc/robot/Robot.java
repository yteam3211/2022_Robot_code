// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.cscore.UsbCamera;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  private Command m_autonomousCommand;

  private RobotContainer m_robotContainer;
  UsbCamera cam1 ;
  UsbCamera cam2 ;
  /**
   * This function is run when the robot is first started up and should be used
   * for any initialization code.
   */
  @Override
  public void robotInit() {    
    // Instantiate our RobotContainer. This will perform all our button bindings,
    // and put our
    // autonomous chooser on the dashboard.''
    cam1 = CameraServer.startAutomaticCapture(0);
    cam2 = CameraServer.startAutomaticCapture(1);
    m_robotContainer = new RobotContainer();
    m_robotContainer.analogInput.setAverageBits(4);

  }

  /**
   * This function is called every robot packet, no matter the mode. Use this for
   * items like diagnostics that you want ran during disabled, autonomous,
   * teleoperated and test.
   *
   * <p>
   * This runs after the mode specific periodic functions, but before LiveWindow
   * and SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {
    // Runs the Scheduler. This is responsible for polling buttons, adding
    // newly-scheduled
    // commands, running already-scheduled commands, removing finished or
    // interrupted commands,
    // and running subsystem periodic() methods. This must be called from the
    // robot's periodic
    // block in order for anything in the Command-based framework to work.
    
    m_robotContainer.driveSystem.periodic();
    m_robotContainer.shootingSystem.periodic();
    m_robotContainer.cartridgeSystem.periodic();
    m_robotContainer.collectSystem.periodic();
    m_robotContainer.climbSystem.periodic();
    // SuperSolenoid.tab.add("pressure", 250 * (m_robotContainer.analogInput.getAverageVoltage() / 5) - 25).withPosition(3, 1);
    // SuperSolenoid.tab.add("pressureDefult",  m_robotContainer.analogInput.getAverageVoltage()).withPosition(4, 1);
    // SuperSystem.periodics();

    CommandScheduler.getInstance().run();
  }

  /** This function is called once each time the robot enters Disabled mode. */
  @Override
  public void disabledInit() {
  }

  @Override
  public void disabledPeriodic() {
  }

  /**
   * This autonomous runs the autonomous command selected by your
   * {@link RobotContainer} class.
   */
  @Override
  public void autonomousInit() {
    m_autonomousCommand = m_robotContainer.getAutonomousCommand();
    // schedule the autonomous command (example)
    if (m_autonomousCommand != null) {
      m_autonomousCommand.schedule();
    }
  }

  /** This function is called periodically during autonomous. */
  @Override
  public void autonomousPeriodic() {
  }

  @Override
  public void teleopInit() {
    m_robotContainer.shootingSystem.getTab().putInDashboard("RPM Low", Constants.LOW_SHOOT_RPM,true);
    m_robotContainer.shootingSystem.getTab().putInDashboard("RPM High", Constants.HIGH_SHOOT_RPM,true);
    // This makes sure that the autonomous stops running when
    // teleop starts running. If you want the autonomous to
    // continue until interrupted by another command, remove
    // this line or comment it out.
    if (m_autonomousCommand != null) {
      m_autonomousCommand.cancel();
    }
  }

  /** This function is called periodically during operator control. */
  @Override
  public void teleopPeriodic() {
    // System.out.println("a" + RobotContainer.RPM);
    // System.out.println("b" + RobotContainer.speed);
    RobotContainer.RPMHigh =  (int)m_robotContainer.shootingSystem.getTab().getFromDashboard("RPM High", Constants.HIGH_SHOOT_RPM);
    RobotContainer.RPMLow =  (int)m_robotContainer.shootingSystem.getTab().getFromDashboard("RPM Low", Constants.LOW_SHOOT_RPM);
  }

  @Override
  public void testInit() {
    // Cancels all running commands at the start of test mode.
    CommandScheduler.getInstance().cancelAll();
  }

  /** This function is called periodically during test mode. */
  @Override
  public void testPeriodic() {
  }
}

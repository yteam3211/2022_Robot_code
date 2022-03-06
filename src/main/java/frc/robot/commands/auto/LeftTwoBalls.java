// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.auto;

import edu.wpi.first.wpilibj2.command.ParallelDeadlineGroup;
import edu.wpi.first.wpilibj2.command.ParallelRaceGroup;
import frc.robot.Constants;
import frc.robot.commands.ShootingCommand;
import frc.robot.commands.collect.CollectCommand;
import frc.robot.commands.collect.changeSelenoidCommand;
import frc.robot.subsystems.CartridgeSystem;
import frc.robot.subsystems.CollectSystem;
import frc.robot.subsystems.DriveSystem;
import frc.robot.subsystems.ShootingSystem;
import frc.util.SuperNavX;
import frc.util.commands.SetOutputCommand;
import frc.util.commands.TimeCommand;
import frc.util.commands.TurnInPlace;
import frc.util.pathGenerator.commandAuto.AutoGenerator;
import frc.util.pathGenerator.drive_controls.EncoderDriveControl;


public class LeftTwoBalls extends AutoGenerator {
  public LeftTwoBalls(DriveSystem driveSystem, SuperNavX navX, CollectSystem collectSystem, CartridgeSystem cartridgeSystem, ShootingSystem shootingSystem) {
          super("LeftTwoBalls", driveSystem.getAutoGains(), driveSystem, navX, 110);
          Constants.LTB1.inReverse();
          Constants.LTB3.inReverse();
          addCommands(new ParallelDeadlineGroup(new TimeCommand(2500), new changeSelenoidCommand(collectSystem, false), 
          new ShootingCommand(shootingSystem, cartridgeSystem,true))/*, new SetOutputCommand(driveSystem, 0)*/);
          addCommands(new ParallelDeadlineGroup(addFollowPathCommand(Constants.LTB1, new EncoderDriveControl(driveSystem))));
          addCommands(new ParallelRaceGroup(new TimeCommand(1750), new TurnInPlace(driveSystem, navX, -45), new changeSelenoidCommand(collectSystem, false)));
          addCommands(new ParallelDeadlineGroup(addFollowPathCommand(Constants.LTB2, new EncoderDriveControl(driveSystem)), new CollectCommand(cartridgeSystem, collectSystem)));
          addCommands(new ParallelDeadlineGroup(addFollowPathCommand(Constants.LTB3, new EncoderDriveControl(driveSystem)), new CollectCommand(cartridgeSystem, collectSystem)));
          addCommands(new ParallelRaceGroup(new TimeCommand(2500), new TurnInPlace(driveSystem, navX, 45), new changeSelenoidCommand(collectSystem, false)));
          addCommands(new ParallelDeadlineGroup(addFollowPathCommand(Constants.LTB4, new EncoderDriveControl(driveSystem)), new changeSelenoidCommand(collectSystem, true)));
          addCommands(new ParallelDeadlineGroup(new TimeCommand(2500),new changeSelenoidCommand(collectSystem, false), 
          new ShootingCommand(shootingSystem, cartridgeSystem,true)), new SetOutputCommand(driveSystem, 0));
  }
}
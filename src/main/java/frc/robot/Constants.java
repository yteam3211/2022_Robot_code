// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.util.pathGenerator.Path;


public final class Constants {
    public static final int CAN_DRIVE_LM_MOTOR = 2;
    public static final int CAN_DRIVE_LS_MOTOR = 1;
    public static final int CAN_DRIVE_RM_MOTOR = 4;
    public static final int CAN_DRIVE_RS_MOTOR = 3;

    public static final Path auto1 = new Path("auto1");
    public static final Path forward = new Path("forward");
    public static final Path bow = new Path("TEST");
    public static final Path check = new Path("check");

    public static final double ROBOT_WIDTH = 0.7;
}

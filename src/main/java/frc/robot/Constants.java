// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.util.pathGenerator.Path;


public final class Constants {

    //_______________CAN_________________
    public static final int CAN_DRIVE_LM_MOTOR = 2;
    public static final int CAN_DRIVE_LS1_MOTOR = 1;
    public static final int CAN_DRIVE_LS2_MOTOR = 0;
    public static final int CAN_DRIVE_RM_MOTOR = 4;
    public static final int CAN_DRIVE_RS1_MOTOR = 3;
    public static final int CAN_DRIVE_RS2_MOTOR = 0;
    public static final int CAN_SHOOT_UP_MOTOR = 0;
    public static final int CAN_SHOOT_DOWN_MOTOR = 0;
    public static final int CAN_COLLECT_MOTOR = 0;
    public static final int CAN_CARTRIDGE1_MOTOR = 0;
    public static final int CAN_CARTRIDGE2_MOTOR = 0;


    //_______________SOLENOIDS_________________
    public static final int COLLECT_SOLENOID = 0;



    //_______________PATH_________________
    public static final Path auto1 = new Path("auto1");
    public static final Path forward = new Path("forward");
    public static final Path bow = new Path("TEST");
    public static final Path check = new Path("check");


    //_______________OTHER_________________
    public static final double ROBOT_WIDTH = 0.7;
}

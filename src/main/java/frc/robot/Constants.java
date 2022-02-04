// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.util.pathGenerator.Path;


public final class Constants {

    //_______________CAN_________________
    public static final int CAN_DRIVE_LM_MOTOR = 6;
    public static final int CAN_DRIVE_LS1_MOTOR = 5;
    public static final int CAN_DRIVE_LS2_MOTOR = 4;
    public static final int CAN_DRIVE_RM_MOTOR = 3;
    public static final int CAN_DRIVE_RS1_MOTOR = 2;
    public static final int CAN_DRIVE_RS2_MOTOR = 1;
    public static final int CAN_SHOOT_BACK_MOTOR = 7;
    public static final int CAN_SHOOT_FROUNT_MOTOR = 8;




    //_______________PWM_________________
    public static final int PWM_COLLECT_MOTOR = 9;
    public static final int PWM_CARTRIDGE1_MOTOR = 8;
    public static final int PWM_CARTRIDGE2_MOTOR = 7;


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
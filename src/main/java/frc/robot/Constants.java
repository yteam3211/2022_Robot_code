package frc.robot;

import frc.util.pathGenerator.Path;

public final class Constants {

    // _______________CAN___________________
    public static final int CAN_DRIVE_LM_MOTOR = 6;
    public static final int CAN_DRIVE_LS1_MOTOR = 5;
    public static final int CAN_DRIVE_LS2_MOTOR = 4;
    public static final int CAN_DRIVE_RM_MOTOR = 3;
    public static final int CAN_DRIVE_RS1_MOTOR = 2;
    public static final int CAN_DRIVE_RS2_MOTOR = 1;
    public static final int CAN_SHOOT_BACK_MOTOR = 7;
    public static final int CAN_SHOOT_FRONT_MOTOR = 8;
    public static final int CAN_CLIMB_MOTOR = 9;

    // _______________PWM___________________
    // public static final int PWM_COLLECT_MOTOR = 9;
    // public static final int PWM_CARTRIDGE1_MOTOR = 8;
    // public static final int PWM_CARTRIDGE2_MOTOR = 7;

    // _______________SOLENOIDS_____________
    public static final int COLLECT_SOLENOID = 0;


    // _______________ANALOG_____________
    public static final int ANALOG_PRESSURE = 0;

    // _______________PATH__________________
    public static final Path auto1 = new Path("auto1");
    public static final Path forward = new Path("forward");
    public static final Path bow = new Path("TEST");
    public static final Path check = new Path("check");
    public static final Path RRED1 = new Path("RRED1");
    public static final Path RRED2 = new Path("RRED2");
    public static final Path RRED3 = new Path("RRED3");
    public static final Path MRED1 = new Path("MRED1");
    public static final Path MRED2 = new Path("MRED2");
    public static final Path MRED3 = new Path("MRED3");
    public static final Path autoBlueR = new Path("autoBlueR");
    public static final Path autoRedL = new Path("autoRedL");
    public static final Path autoRedR = new Path("autoRedR");
    // public static final Path oneAutoRedL = new Path("oneAutoRedL");
    // public static final Path oneAutoRedM = new Path("oneAutoRedM");
    // public static final Path oneAutoBlueL = new Path("oneAutoBlueL");
    // public static final Path oneAutoBlueM = new Path("oneAutoBlueM");

    // _______________OTHER_________________
    public static final double ROBOT_WIDTH = 0.7;
    public static final int AMPER_LIMIT = 60;
    public static final int AMPER_LIMIT_CLIMB = 60;
    public static final int CLOSE_SHOOT_RPM = 13500;

    // ______________Changers_______________ 
    // Main robot:
    public static final boolean reverse = true; 
    public static final int PWM_COLLECT_MOTOR = 2;
    public static final int PWM_CARTRIDGE1_MOTOR = 1;
    public static final int PWM_CARTRIDGE2_MOTOR = 3;
    public static final int DIRCTION = 1;
    

    // Prototype:
    /* 
    public static final boolean reverse = true;
    public static final int PWM_COLLECT_MOTOR = 9;
    public static final int PWM_CARTRIDGE2_MOTOR = 7;
    public static final int PWM_CARTRIDGE1_MOTOR = 8;
    public static final int DIRCTION = -1;
    */
}
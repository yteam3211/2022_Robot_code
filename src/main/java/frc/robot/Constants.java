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
    public static final int CAN_SHOOT_MASTER_MOTOR = 8;
    public static final int CAN_SHOOT_SLAVE_MOTOR = 7;
    public static final int CAN_CLIMB_MOTOR = 9;
    public static final int CAN_CLIMB_MOTOR_LEFT = 11;
    public static final int CAN_CLIMB_MOTOR_RIGHT = 10;

    // _______________PWM___________________
    // public static final int PWM_COLLECT_MOTOR = 9;
    // public static final int PWM_CARTRIDGE1_MOTOR = 8;
    // public static final int PWM_CARTRIDGE2_MOTOR = 7;

    // _______________SOLENOIDS_____________
    public static final int COLLECT_SOLENOID = 0;


    // _______________ANALOG_____________
    public static final int ANALOG_PRESSURE = 0;
    public static final int MAGNET_SENSOR_UP = 2;
    public static final int MAGNET_SENSOR_DOWN = 1;

    // _______________PATH__________________
    public static final Path turn180 = new Path("180");
    public static final Path turn90 = new Path("90");
    public static final Path forward = new Path("forword");
    public static final Path bow = new Path("bow");
    public static final Path oneBall = new Path("1ball");
    public static final Path TP1 = new Path("3P1", 200);
    public static final Path TP2 = new Path("3P2", 320);
    public static final Path TP3 = new Path("3P3", 320);
    public static final Path TP4 = new Path("3P4", 90);
    public static final Path L3 = new Path("L3", 175);
    public static final Path RTB1 = new Path("RTB1", 110);
    public static final Path RTB2 = new Path("RTB2", 340);
    public static final Path RTB3 = new Path("RTB3", 150);
    public static final Path LTB1 = new Path("LTB1", 110);
    public static final Path LTB2 = new Path("LTB2", 270);
    public static final Path LTB3 = new Path("LTB3", 0);
    public static final Path LRED1 = new Path("LRed1", 200);
    public static final Path LRED2 = new Path("LRed2", 40);
    public static final Path LRED3 = new Path("LRed3", 220);

    

    // _______________OTHER_________________
    public static final double ROBOT_WIDTH = 0.653;
    public static final int AMPER_LIMIT = 60;
    public static final int AMPER_LIMIT_CLIMB = 30;
    public static final int CLOSE_SHOOT_RPM = 12300;
    public static final double CARITAGE_SPEED = -0.2;

    // ______________Changers_______________ 
    // Main robot:
    public static final boolean reverse = true; 
    public static final int PWM_COLLECT_MOTOR = 7;
    public static final int PWM_CARTRIDGE1_MOTOR = 6;
    public static final int PWM_CARTRIDGE2_MOTOR = 5;
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
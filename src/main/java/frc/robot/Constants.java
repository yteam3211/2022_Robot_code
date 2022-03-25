package frc.robot;

import frc.robot.subsystems.ShootingSystem.gains;
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
    public static final int SHOOTING_SOLENOID = 1;


    // _______________ANALOG_____________
    public static final int ANALOG_PRESSURE = 0;
    public static final int MAGNET_SENSOR_UP = 2;
    public static final int MAGNET_SENSOR_DOWN = 1;
    public static final int SWICH_SENSOR_DOWN = 3;
    public static final int MAGNET_SENSOR_EXCLIMB = 4;

    // _______________PATH__________________
    public static final Path turn180 = new Path("180");
    public static final Path turn90 = new Path("90");
    public static final Path forward = new Path("forword");
    public static final Path bow = new Path("bow");
    public static final Path oneBall = new Path("1ball");
    // public static final Path TP1 = new Path("3P1", 200);
    // public static final Path TP2 = new Path("3P2", 320);
    // public static final Path TP3 = new Path("3P3", 320);
    // public static final Path TP4 = new Path("3P4", 90);
    public static final Path L3 = new Path("L3", 175);
    public static final Path RTB1 = new Path("RTB1", 110);
    public static final Path RTB2 = new Path("RTB2", 0);
    public static final Path RTB3 = new Path("RTB3", 180);
    public static final Path LTB1 = new Path("LTB1", 110);
    public static final Path LTB2 = new Path("LTB2", 300);
    public static final Path LTB2V2 = new Path("LTB2V2", 268);
    public static final Path LTB3 = new Path("LTB3", 180);
    public static final Path LTB4 = new Path("LTB4", 45);
    public static final Path LRED1 = new Path("LRed1", 200);
    public static final Path LRED2 = new Path("LRed2", 55);
    public static final Path LRED3 = new Path("LRed3", 220);
    // Three balls
    public static final Path ThreeC1 = new Path("3CLS1", 110);
    public static final Path ThreeC2 = new Path("3CLS2", 0);
    public static final Path ThreeC3 = new Path("3CLS3", 180);
    public static final Path ThreeL1 = new Path("3LEFT1", 110);
    public static final Path ThreeL2 = new Path("3LEFT2", 350);
    public static final Path ThreeL3 = new Path("3LEFT3", 340);
    public static final Path ThreeL3V2 = new Path("3LEFT3V2", 320);
    public static final Path ThreeL4 = new Path("3LEFT4", 90);
    

    // _______________OTHER_________________
    public static final double ROBOT_WIDTH = 0.653;
    public static final int AMPER_LIMIT = 40;
    public static final int AMPER_LIMIT_CLIMB = 30;
    public static final int LOW_SHOOT_RPM = 6600;
    public static final int HIGH_SHOOT_RPM = 12100;
    public static final double CARITAGE_SPEED_LOW = -1;
    public static final double CARITAGE_SPEED = -0.5;
    public static final gains DEFULT_SHOOT = gains.high;//true to high false to low

    // ______________Changers_______________ 
    // Main robot:
    public static final boolean reverse = true; 
    public static final int PWM_COLLECT_MOTOR = 1;
    public static final int PWM_CARTRIDGE1_MOTOR = 8;
    public static final int PWM_CARTRIDGE2_MOTOR = 6;
    public static final int DIRCTION = 1;
    // public static final double kEncoderDistancePerPulse = 0;
    // public static DigitalSource[] kRightEncoderPorts;
    // public static DigitalSource kRightEncoderReversed;
    // public static DigitalSource[] kLeftEncoderPorts;
    // public static DigitalSource kLeftEncoderReversed;
    

    // Prototype:
    /* 
    public static final boolean reverse = true;
    public static final int PWM_COLLECT_MOTOR = 9;
    public static final int PWM_CARTRIDGE2_MOTOR = 7;
    public static final int PWM_CARTRIDGE1_MOTOR = 8;
    public static final int DIRCTION = -1;
    */
}
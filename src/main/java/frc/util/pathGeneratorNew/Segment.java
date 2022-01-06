/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.util.pathGeneratorNew;

/**
 * Add your docs here.
 */
public class Segment {
    public double velocity, acceleration, pos;

    public Segment(double pos, double velocity, double acceleration) {
        this.velocity = velocity;
        this.acceleration = acceleration;
        this.pos = pos;
    }
}
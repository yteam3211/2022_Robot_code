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
public class PointSegments {
    public double angle;
    public Segment leftPoint, rightPoint, change;

    public PointSegments(Segment leftPoint, Segment rightPoint, double angle) {
        this.leftPoint = leftPoint;
        this.rightPoint = rightPoint;
        this.angle = angle;
    }

    public void setOtherSide() {
        change = leftPoint;
        leftPoint = rightPoint;
        rightPoint = change;
        angle *= -1;
    }
}
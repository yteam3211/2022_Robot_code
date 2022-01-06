package frc.util.pathGenerator.drive_controls;

import frc.util.SuperNavX;
import frc.util.pathGeneratorNew.DrivePosition;
import frc.util.pathGeneratorNew.PointSegments;
import frc.robot.subsystems.DriveSystem;

/**
 * @author Matan Steinmetz
 */
public class EncoderAndNavxDriveControl extends DriveControl {
    private DrivePosition errorPosition = new DrivePosition();
    private double errorAngle;
    private SuperNavX navX;

    public EncoderAndNavxDriveControl(DriveSystem driveSystem, SuperNavX navX) {
        super(driveSystem);
        this.navX = navX;
    }

    @Override
    public DrivePosition getRobotErrorPosition(Point point) {
        errorAngle = angle2Distance(point.angle - navX.getSuperAngle());

        errorPosition.left = point.leftPoint.pos - getLeftPosition() + errorAngle;
        errorPosition.right = point.rightPoint.pos - getRightPosition() - errorAngle;

        return errorPosition;
    }
}

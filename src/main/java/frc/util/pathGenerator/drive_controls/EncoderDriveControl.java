package frc.util.pathGenerator.drive_controls;

import frc.util.pathGenerator.Point;
import frc.util.pathGeneratorNew.DrivePosition;
import frc.util.pathGeneratorNew.PointSegments;
import frc.robot.subsystems.DriveSystem;

/**
 * Add your docs here.
 */
public class EncoderDriveControl extends DriveControl {
    private DrivePosition errorPosition = new DrivePosition();

    public EncoderDriveControl(DriveSystem driveSystem) {
        super(driveSystem);
    }

    @Override
    public double getRobotErrorLeftPosition(Point point) {
        return point.pos - getLeftPosition();
    }

    @Override
    public double getRobotErrorRightPosition(Point point) {
        return point.pos - getRightPosition();
    }
}

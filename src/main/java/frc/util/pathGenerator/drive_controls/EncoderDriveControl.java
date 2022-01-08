package frc.util.pathGenerator.drive_controls;

import frc.util.pathGenerator.Path;
import frc.robot.subsystems.DriveSystem;

/**
 * Add your docs here.
 */
public class EncoderDriveControl extends DriveControl {

    public EncoderDriveControl(DriveSystem driveSystem) {
        super(driveSystem);
    }

    @Override
    public double getRobotErrorLeftPosition(int index) {
        return path.left[index].pos - getLeftPosition();
    }

    @Override
    public double getRobotErrorRightPosition(int index) {
        return path.right[index].pos - getRightPosition();
    }
}

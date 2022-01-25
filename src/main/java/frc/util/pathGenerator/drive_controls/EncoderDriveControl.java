package frc.util.pathGenerator.drive_controls;

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
        System.out.println(path.left[index].pos + " a " + getLeftEncoderDistance() + 
        (path.left[index].pos - getLeftEncoderDistance()));
        return path.left[index].pos - getLeftEncoderDistance();        
    }

    @Override
    public double getRobotErrorRightPosition(int index) {
        return path.right[index].pos - getRightEncoderDistance();
    }
}

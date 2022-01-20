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
        driveSystem.getTab().putInDashboard("left path pos", path.left[index].pos);
        return path.left[index].pos - getLeftEncoderDistance();        
    }

    @Override
    public double getRobotErrorRightPosition(int index) {
        return path.right[index].pos - getRightEncoderDistance();
    }
}

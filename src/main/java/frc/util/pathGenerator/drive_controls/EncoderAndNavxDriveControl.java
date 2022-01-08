package frc.util.pathGenerator.drive_controls;

import frc.util.SuperNavX;
import frc.util.pathGenerator.Path;
import frc.util.pathGenerator.Point;
import frc.robot.subsystems.DriveSystem;

/**
 * @author Matan Steinmetz
 */
public class EncoderAndNavxDriveControl extends DriveControl {
    private double errorAngle;
    private SuperNavX navX;

    public EncoderAndNavxDriveControl(DriveSystem driveSystem, SuperNavX navX) {
        super(driveSystem);
        this.navX = navX;
    }
    
    @Override
    public double getRobotErrorRightPosition(int index){
        errorAngle = angle2Distance(path.getAngle(index) - navX.getSuperAngle());
        return path.right[index].pos - getRightPosition() - errorAngle;

    }
    @Override
    public  double getRobotErrorLeftPosition(int index){
        errorAngle = angle2Distance(path.getAngle(index) - navX.getSuperAngle());
        return path.left[index].pos - getLeftPosition() + errorAngle;
    }
}

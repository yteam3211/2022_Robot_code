package frc.util.pathGenerator.commandAuto;

import edu.wpi.first.networktables.NTSendableBuilder;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.commands.auto.oneBall;
import frc.robot.commands.auto.twoBall;

public class AutoChooser {
    private CommandBase autoCommand = null;
    SendableChooser<CommandBase> autoChooser = new SendableChooser<>();

    public AutoChooser(oneBall oneBall, AutoGenerator[] autoCommands) {

        for (AutoGenerator command : autoCommands) {
            System.out.println(command.getNamePath());
            autoChooser.addOption(command.getNamePath(), command);
        }
        autoChooser.setDefaultOption("1 ball", oneBall);

        SmartDashboard.putData("Auto Chooser", autoChooser);
        
    }

    public Command getAutoCommand() {
        return autoChooser.getSelected();
    }


    public void stopAuto() {
        if (autoCommand != null) {
            autoCommand.cancel();
        }
    }
}

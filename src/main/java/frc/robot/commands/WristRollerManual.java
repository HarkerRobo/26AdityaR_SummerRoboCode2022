package frc.robot.commands;
import frc.robot.OI;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.WristRoller;
import harkerrobolib.commands.IndefiniteCommand;

public class WristRollerManual extends IndefiniteCommand{

    public WristRollerManual() {
        addRequirements(WristRoller.getInstance());
    }


    public void execute() {
        if (Intake.getInstance().isIntaking()){
            Intake.getInstance().setPercentageOutput(0.3);
        }
        else if (OI.getInstance().getDriver().getLeftTrigger() > 0.5){
            Intake.getInstance().setPercentageOutput(0.3);
        }
        else {
            Intake.getInstance().setPercentageOutput(0.1);
        }
    }

    public void end(Boolean interrupt) {
        WristRoller.getInstance().setPercentageOutput(0);
    }
}

package frc.robot.commands;
import frc.robot.OI;
import frc.robot.subsystems.Wrist;
import harkerrobolib.commands.IndefiniteCommand;
public class WristManual extends IndefiniteCommand {

    public WristManual() {
        addRequirements(Wrist.getInstance());
    }

    public void execute() {
        if(OI.getInstance().getDriver().getUpDPadButton().get()){
            Wrist.getInstance().setPercentageOutput(0.7);
        }
        else if(OI.getInstance().getDriver().getDownDPadButton().get()){
            Wrist.getInstance().setPercentageOutput(-0.7);
        }
        else {
            Wrist.getInstance().setPercentageOutput(0.2);
        }
    }

    public void end(Boolean interrupt) {
        Wrist.getInstance().setPercentageOutput(0);
    }
}

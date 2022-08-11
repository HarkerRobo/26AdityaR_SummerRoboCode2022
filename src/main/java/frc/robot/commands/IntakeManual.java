package frc.robot.commands;

import frc.robot.OI;
import frc.robot.subsystems.Intake;
import harkerrobolib.commands.IndefiniteCommand;

public class IntakeManual extends IndefiniteCommand {
    
    public IntakeManual() {
        addRequirements(Intake.getInstance());
    }

    public void execute() {
        if(OI.getInstance().getDriver().getRightTrigger() > 0.5) {
            Intake.getInstance().setPercentageOutput(0.3);
        }
        else{
            Intake.getInstance().setPercentageOutput(0);
        }
    }

    public void end(Boolean interrupt) {
        Intake.getInstance().setPercentageOutput(0);
    }
}
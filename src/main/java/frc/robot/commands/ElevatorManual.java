package frc.robot.commands;
import frc.robot.OI;
import frc.robot.subsystems.Elevator;
import harkerrobolib.commands.IndefiniteCommand;

public class ElevatorManual extends IndefiniteCommand {
    
    public ElevatorManual() {
        addRequirements(Elevator.getInstance());
    }

    public void execute() {
        double value = OI.getInstance().getDriver().getRightY();
        if(value > 0.1) {
            Elevator.getInstance().setPercentageOutput(Math.abs(value));
        }
        else{
            Elevator.getInstance().setPercentageOutput(0.1);
        }
    }

    public void end(Boolean interrupt) {
        Elevator.getInstance().setPercentageOutput(0);
    }
}
package frc.robot.subsystems;
import com.ctre.phoenix.motorcontrol.ControlMode;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import harkerrobolib.wrappers.HSTalon;

public class WristRoller extends SubsystemBase {
    
    private static WristRoller instance;

    private HSTalon motor;
    private static final int ID = 0;
    private static final boolean INVERT = false;

    private WristRoller() {
        motor = new HSTalon(ID);
        motor.setInverted(INVERT);
    }

    public void setPercentageOutput(double value){
        motor.set(ControlMode.PercentOutput, value);
    }

    public static WristRoller getInstance() {
        if (instance == null) {
            instance = new WristRoller();
        }
        return instance;
    } 

}

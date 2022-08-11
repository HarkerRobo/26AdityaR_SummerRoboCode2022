package frc.robot.subsystems;
import com.ctre.phoenix.motorcontrol.ControlMode;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import harkerrobolib.wrappers.HSTalon;

public class Intake extends SubsystemBase {
    
    private static Intake instance;

    private HSTalon motor;

    private boolean intake;

    private static final int MOTOR_ID = 0;
    private static final boolean MOTOR_INVERT = false;

    private DoubleSolenoid piston;
    private static final int PORT_1 = 0;
    private static final int PORT_2 = 0;

    private Intake () {
        motor = new HSTalon (MOTOR_ID);
        motor.setInverted(MOTOR_INVERT);

        piston = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, PORT_1, PORT_2);

        intake = false;
    }

    public boolean isIntaking() {
        return intake;
    }

    public void setPercentageOutput(double output) {
        motor.set(ControlMode.PercentOutput, output);
        intake = output >= 0.1;
    }

    public void toggle() {
        if(piston.get() == DoubleSolenoid.Value.kReverse) {
            piston.set(DoubleSolenoid.Value.kForward);
        }
        else if(piston.get() == DoubleSolenoid.Value.kForward) {
            piston.set(DoubleSolenoid.Value.kReverse);
        }
        else {
            piston.set(DoubleSolenoid.Value.kReverse);
        }
    }

    public static Intake getInstance() {
        if (instance == null) {
            instance = new Intake();
        }
        return instance;
    }
}

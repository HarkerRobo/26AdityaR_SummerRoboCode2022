package frc.robot.subsystems;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import harkerrobolib.wrappers.HSTalon;

public class Elevator extends SubsystemBase {
    
    private static Elevator instance;

    private HSTalon master;
    private HSTalon follower1;
    private VictorSPX follower2;
    private VictorSPX follower3;

    private static final int MASTER_ID = 2;
    private static final int FOLLOWER1_ID = 6;
    private static final int FOLLOWER2_ID = 3;
    private static final int FOLLOWER3_ID = 5;
    
    private static final boolean MASTER_INVERT = true;
    private static final boolean FOLLOWER1_INVERT = true;
    private static final boolean FOLLOWER2_INVERT = true;
    private static final boolean FOLLOWER3_INVERT = true;

    public Elevator () {
        master = new HSTalon(MASTER_ID);
        follower1 = new HSTalon(FOLLOWER1_ID);
        follower2 = new VictorSPX(FOLLOWER2_ID);
        follower3 = new VictorSPX(FOLLOWER3_ID);

        follower1.follow(master);
        follower2.follow(master);
        follower3.follow(master);

        master.setInverted(MASTER_INVERT);
        follower1.setInverted(FOLLOWER1_INVERT);
        follower2.setInverted(FOLLOWER2_INVERT);
        follower3.setInverted(FOLLOWER3_INVERT);
    }

    public void setPercentageOutput(double value) {
        master.set(ControlMode.PercentOutput, value);
    }

    public static Elevator getInstance() {
        if (instance == null) {
            instance = new Elevator();
        }
        return instance;
    }

}

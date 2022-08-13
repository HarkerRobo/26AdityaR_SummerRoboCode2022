package frc.robot.subsystems;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import harkerrobolib.wrappers.HSTalon;

public class Drivetrain extends SubsystemBase {
    
    private static Drivetrain instance;

    private HSTalon leftMaster;
    private HSTalon rightMaster;
    private VictorSPX leftFollower;
    private VictorSPX rightFollower;

    private static final int LEFT_MASTER_ID = 4;
    private static final int RIGHT_MASTER_ID = 1;
    private static final int LEFT_FOLLOWER_ID = 4;
    private static final int RIGHT_FOLLOWER_ID = 1;

    private static final boolean LEFT_MASTER_INVERT = true;
    private static final boolean RIGHT_MASTER_INVERT = false;
    private static final boolean LEFT_FOLLOWER_INVERT = true;
    private static final boolean RIGHT_FOLLOWER_INVERT = false;

    private Drivetrain() {
        leftMaster = new HSTalon(LEFT_MASTER_ID);
        rightMaster = new HSTalon(RIGHT_MASTER_ID);
        leftFollower = new VictorSPX(LEFT_FOLLOWER_ID);
        rightFollower = new VictorSPX(RIGHT_FOLLOWER_ID);

        leftFollower.follow(leftMaster);
        rightFollower.follow(rightMaster);

        leftMaster.setInverted(LEFT_MASTER_INVERT);
        rightMaster.setInverted(RIGHT_MASTER_INVERT);
        leftFollower.setInverted(LEFT_FOLLOWER_INVERT);
        rightFollower.setInverted(RIGHT_FOLLOWER_INVERT);
    }

    public VictorSPX getRightFollower() {
        return rightFollower;
    }

    public VictorSPX getLeftFollower() {
        return leftFollower;
    }

    public HSTalon getRightMaster() {
        return rightMaster;
    }

    public HSTalon getLeftMaster() {
        return leftMaster;
    }

    public static Drivetrain getInstance() {
        if (instance == null) {
            instance = new Drivetrain();
        }
        return instance;
    }

    public void setArcadeDrive(double speed, double turn)
    {
        rightMaster.set(ControlMode.PercentOutput, speed - turn);
        leftMaster.set(ControlMode.PercentOutput, speed + turn);
    }

}

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.robot.autocommands.AngleArmCargoShip;
import frc.robot.autocommands.AutoAlignCommand;
import frc.robot.autocommands.OrientTowardsCenterpointCommand;

/**
 * This class is the glue that binds the controls on  the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    public final Joystick driveStick = new Joystick(0);
    public final Joystick operatorStick = new Joystick(1);

    private Button autoAlignButton = new JoystickButton(driveStick, RobotMap.AUTO_ALIGN_BUTTON);
    private Button centerPointOrientButton = new JoystickButton(driveStick, RobotMap.CENTERPOINT_PID_COMMAND);
    private Button floorCargoArm = new JoystickButton(operatorStick, RobotMap.CARGO_ARM_FLOOR);
    private Button cargoCargoArm = new JoystickButton(operatorStick, RobotMap.CARGO_ARM_CARGO);
    private Button rocketCargoArm = new JoystickButton(operatorStick, RobotMap.CARGO_ARM_ROCKET);
    private Button stowCargoArm = new JoystickButton(operatorStick, RobotMap.CARGO_ARM_STOW);

    public OI() {
        autoAlignButton.whenPressed(new AutoAlignCommand());
        centerPointOrientButton.whenPressed(new OrientTowardsCenterpointCommand());
        floorCargoArm.whenReleased(new AngleArmCargoShip(0));
        cargoCargoArm.whenReleased(new AngleArmCargoShip(80));
        rocketCargoArm.whenReleased(new AngleArmCargoShip(50));
        stowCargoArm.whenReleased(new AngleArmCargoShip(100));
    }

      // Drive Stick
    public double getDriveX() {
        return driveStick.getX();
    }

    public double getDriveY() {
        return driveStick.getY();
    }

    public double getDriveZ() {
        return driveStick.getZ();
    }
    public double getDriveThrottle() {
        return driveStick.getThrottle();
    }
    public boolean isDriveButtonDown(int buttonNumber) {
        return driveStick.getRawButton(buttonNumber);
    }
    
    public double getOperatorX() {
        return operatorStick.getX();
    }
    public double getOperatorY() {
        return operatorStick.getY();
    }
    public double getOperatorZ() {
        return operatorStick.getZ();
    }
    public double getOperatorThrottle() {
        return operatorStick.getThrottle();
    }
    public boolean isOperatorButtonDown(int buttonNumber) {
        return operatorStick.getRawButton(buttonNumber);
    }
    public int getOperatorPOV() {
        return operatorStick.getPOV();
    }
}

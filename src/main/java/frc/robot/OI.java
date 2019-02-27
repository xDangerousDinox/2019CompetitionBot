package frc.robot;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.*;
import edu.wpi.first.wpilibj.buttons.*;
import frc.robot.autocommands.*;
import frc.robot.teleopcommands.*;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    public final Joystick driveStick = new Joystick(0);
    public final Joystick operatorStick = new Joystick(1);

    private Button autoAlignButton = new JoystickButton(driveStick, RobotMap.AUTO_ALIGN_BUTTON);
    private Button centerPointOrientButton = new JoystickButton(
        driveStick, 
        RobotMap.CENTERPOINT_PID_COMMAND);

    private Button shootOutButton = new JoystickButton(operatorStick, RobotMap.SHOOT_OUT_BUTTON);
    private Button shootInButton = new JoystickButton(operatorStick, RobotMap.SHOOT_IN_BUTTON);
    private Button cameraButtonSwitchSidesButton = new JoystickButton(operatorStick, RobotMap.CAMERA_BUTTON_SWITCH_SIDES);
    private Button cameraButtonUpdownButton = new JoystickButton(operatorStick, RobotMap.CAMERA_BUTTON_UPDOWN);
    private Button hatchPushOutButton = new JoystickButton(operatorStick, RobotMap.HATCH_PUSH_OUT);
    private Button hatchPushInButton = new JoystickButton(operatorStick, RobotMap.HATCH_PUSH_IN);

    public OI() {
        this.autoAlignButton.whenPressed(new AutoAlignCommand());
        this.centerPointOrientButton.whenPressed(new OrientTowardsCenterpointCommand());

        Command teleopCargoShoot = new TeleopCargoShoot();
        this.shootOutButton.whenPressed(teleopCargoShoot);
        this.shootInButton.whenPressed(teleopCargoShoot);

        Command teleopCameraController = new TeleopCameraController();
        this.cameraButtonSwitchSidesButton.whenPressed(teleopCameraController);
        this.cameraButtonUpdownButton.whenPressed(teleopCameraController);

        Command teleopHatch = new TeleopHatch();
        this.hatchPushOutButton.whenPressed(teleopHatch);
        this.hatchPushInButton.whenPressed(teleopHatch);
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

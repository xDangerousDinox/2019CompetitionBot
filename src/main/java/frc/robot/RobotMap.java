package frc.robot;

public class RobotMap {

    //ALL DUMMY VALUES!!!

    //Camera values
    public static final int CAMERA_WIDTHPX = 320;

    //Left drive motors
    public static final int LEFT_DRIVE_1 = 10;
    public static final int LEFT_DRIVE_2 = 11;
    public static final int LEFT_DRIVE_3 = 12;

    //Right drive Motors
    public static final int RIGHT_DRIVE_1 = 13;
    public static final int RIGHT_DRIVE_2 = 14;
    public static final int RIGHT_DRIVE_3 = 15;

    //Cargo Arm
    public static final int ARM_CARGO = 18;
    public static final int SHOOT = 19;

    //Climb 
    public static final int CLIMB_1 = 16;
    public static final int CLIMB_2 = 17;

    //Servos
    public static final int CAMERA_Z = 4;
    public static final int CAMERA_X = 5;

    //Pneumatics
    public final static int PCM24V_ID = 0;
    public static final int HATCH_ROTATION_PUSH_OUT = 0;
    public static final int HATCH_ROTATION_PUSH_IN = 1;
    public static final int HATCH_TOP_PUSH_OUT = 2;
    public static final int HATCH_TOP_PUSH_IN = 3;
    public static final int HATCH_BOTTOM_PUSH_OUT = 4;
    public static final int HATCH_BOTTOM_PUSH_IN = 5; 

    public final static int PCM12V_ID = 1;
    public final static int DRIVE_SHIFT_IN = 0;
    public final static int DRIVE_SHIFT_OUT = 1;
    public final static int ARM_STOP_IN = 2;
    public final static int ARM_STOP_OUT = 3;
    public final static int CLIMB_TORQUE_IN = 4;
    public final static int CLIMB_TORQUE_OUT = 5;

    /*
     * ****************
     * JOYSTICK BUTTONS
     * ****************
     */

    //Operator Buttons
    public static final int SHOOT_OUT_BUTTON = 1;
    public static final int SHOOT_IN_BUTTON = 2;
    public static final int CARGO_ARM_LIFT = 3;
    public static final int HATCH_ROTATION = 4;
    public static final int HATCH_TOP = 5;
    public static final int HATCH_TORQUE = 6;
    public static final int CAMERA_BUTTON_SWITCH_SIDES = 11;
    public static final int CAMERA_BUTTON_UPDOWN = 12;

    //Drive Buttons
 
    public static final int DRIVE_SHIFT = 2;
    public static final int CENTERPOINT_PID_COMMAND = 3;
    public static final int AUTO_ALIGN_BUTTON = 4;

}
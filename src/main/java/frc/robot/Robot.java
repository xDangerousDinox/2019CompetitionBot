/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.autocommands.AutoSwitchCommand;
import frc.robot.autocommands.PIDManualMoveArm;
import frc.robot.subsystems.CameraController;
import frc.robot.subsystems.CargoArm;
import frc.robot.subsystems.Climb;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.HatchArm;
import frc.robot.subsystems.PIDCargoArm;
import frc.robot.teleopcommands.ManualCargoArm;
import frc.robot.teleopcommands.SmartDash;
import frc.robot.teleopcommands.TeleopCameraController;
import frc.robot.teleopcommands.TeleopCargoShoot;
import frc.robot.teleopcommands.TeleopDrive;
import frc.robot.teleopcommands.TeleopHatch;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {

  /*TODO:
  1) Implement Joystick commands
  2) test all solenoids
  3) tune drive encoders
  4) tune hatch mechanism
  5) tune autoallign
  6) create trajectories
  7) tune arm angle*/

  private final SendableChooser<String> startingPosition = new SendableChooser<>();
  private final SendableChooser<String> endingPosition = new SendableChooser<>();
  
  public static BaseCamera camera = new ImplCamera();

  public static RobotTables robotTables = new RobotTables();

  public static DriveTrain driveTrain = new DriveTrain();
  public static CameraController cameraController = new CameraController();
  public static CargoArm cargoArm = new CargoArm();
  public static Climb climb = new Climb();
  public static HatchArm hatchArm = new HatchArm();

  public static TeleopDrive teleopDrive = new TeleopDrive();
  public static TeleopCargoShoot teleopCargoShoot = new TeleopCargoShoot();
  public static SmartDash smartDash = new SmartDash();
  public static TeleopCameraController teleopCameraController = new TeleopCameraController();
  public static TeleopHatch teleopHatch = new TeleopHatch();

  public static ManualCargoArm manualCargoArm = new ManualCargoArm();

  public static PIDCargoArm pidCargoArm = new PIDCargoArm()
  ;

  public static PIDManualMoveArm pidManualMoveArm = new PIDManualMoveArm();

  public static AutoSwitchCommand autoSwitchCommand;

  public static OI oi = new OI();

  public CANSparkMax test = new CANSparkMax(RobotMap.LEFT_DRIVE_1, MotorType.kBrushless);

  /**
   * This function is run when the robot is first started up and should be used
   * for any initialization code.
   */

  @Override
  public void robotInit() {
    startingPosition.setDefaultOption("levelOneRight", "levelOneRight");
    startingPosition.addOption("levelOneCenter", "levelOneCenter");
    startingPosition.addOption("levelOneLeft", "levelOneLeft");
    startingPosition.addOption("levelTwoLeft", "levelTwoLeft");
    startingPosition.addOption("levelTwoRight", "levelTwoRight");
    SmartDashboard.putData("Starting Position", startingPosition);
    endingPosition.setDefaultOption("rightFront", "rightFront");
    endingPosition.addOption("rightFirst", "rightFirst");
    endingPosition.addOption("rightSecond", "rightSecond");
    endingPosition.addOption("rightThird", "rightThird");
    endingPosition.addOption("leftFront", "leftFront");
    endingPosition.addOption("leftFirst", "leftFirst");
    endingPosition.addOption("leftSecond", "leftSecond");
    endingPosition.addOption("leftThird", "leftThird");
    SmartDashboard.putData("Ending Position", endingPosition);
    CameraServer.getInstance().startAutomaticCapture();
  }

  /**
   * This function is called every robot packet, no matter the mode. Use this for
   * items like diagnostics that you want ran during disabled, autonomous,
   * teleoperated and test.
   *
   * <p>
   * This runs after the mode specific periodic functions, but before LiveWindow
   * and SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {
  }

  /**
   * This autonomous (along with the chooser code above) shows how to select
   * between different autonomous modes using the dashboard. The sendable chooser
   * code works with the Java SmartDashboard. If you prefer the LabVIEW Dashboard,
   * remove all of the chooser code and uncomment the getString line to get the
   * auto name from the text box below the Gyro
   *
   * <p>
   * You can add additional auto modes by adding additional comparisons to the
   * switch structure below with additional strings. If using the SendableChooser
   * make sure to add them to the chooser code above as well.
   */
  @Override
  public void autonomousInit() {
    super.autonomousInit();
    //autoSwitchCommand = new AutoSwitchCommand(endingPosition.getSelected(), startingPosition.getSelected());
    //autoSwitchCommand.start();
    teleopDrive.start();
    //pidManualMoveArm.start();
    teleopCargoShoot.start();
  }

  /**
   * This function is called periodically during autonomous.
   */
  @Override
  public void autonomousPeriodic() {
    Scheduler.getInstance().run();
  }

  @Override
  public void teleopInit() {
    super.teleopInit();
    //teleopCameraController.start();
    teleopCargoShoot.start();
    //smartDash.start();
    teleopDrive.start();
    //pidManualMoveArm.start();
    //manualCargoArm.start();
    //teleopHatch.start();
    //driveTrain.arcade(0.7, 0);
  }

  /**
   * This function is called periodically during operator control.
   */
  @Override
  public void teleopPeriodic() {
    Scheduler.getInstance().run();
  }

  /**
   * This function is called periodically during test mode.
   */
  @Override
  public void testPeriodic() {
  }
}

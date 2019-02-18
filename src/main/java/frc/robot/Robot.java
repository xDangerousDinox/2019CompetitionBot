/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import com.revrobotics.CANEncoder;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.subsystems.CameraController;
import frc.robot.subsystems.CargoArm;
import frc.robot.subsystems.Climb;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.HatchArm;
import frc.robot.teleopcommands.TeleopCameraController;
import jaci.pathfinder.followers.EncoderFollower;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {

  private static final String kDefaultAuto = "Default";
  private static final String kVisionAuto = "VisionFollow";
  private String m_autoSelected;
  private final SendableChooser<String> m_chooser = new SendableChooser<>();
  
  public static BaseCamera camera = new ImplCamera();

  public static RobotTables robotTables = new RobotTables();

  public static DriveTrain driveTrain = new DriveTrain();
  public static CameraController cameraController = new CameraController();
  public static CargoArm cargoArm = new CargoArm();
  public static Climb climb = new Climb();
  public static HatchArm hatchArm = new HatchArm();

  public static OI oi = new OI();
  

  private Command teleopCameraController = new TeleopCameraController();

  /**
   * This function is run when the robot is first started up and should be used
   * for any initialization code.
   */

  @Override
  public void robotInit() {
    m_chooser.setDefaultOption("Default Auto", kDefaultAuto);
    SmartDashboard.putData("Auto choices", m_chooser);
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
    m_autoSelected = m_chooser.getSelected();
    m_autoSelected = kVisionAuto;
    // autoSelected = SmartDashboard.getString("Auto Selector",
    // defaultAuto);
    // System.out.println("Auto selected: " + m_autoSelected);

    switch (m_autoSelected) {
    case kDefaultAuto:
      // System.out.println("Auto init done");
      // in meters
      double maxVelocity = 2.0;
      double maxAccel = 2.0;
      double maxJerk = 60.0;

      // generate trajectory
      /*
       * Waypoint[] points = new Waypoint[] { new Waypoint(-4, -1,
       * Pathfinder.d2r(-45)), // Waypoint @ x=-4, y=-1, exit angle=-45 degrees new
       * Waypoint(-2, -2, 0), // Waypoint @ x=-2, y=-2, exit angle=0 radians new
       * Waypoint(0, 0, 0) // Waypoint @ x=0, y=0, exit angle=0 radians };
       * Trajectory.Config config = new
       * Trajectory.Config(Trajectory.FitMethod.HERMITE_CUBIC,
       * Trajectory.Config.SAMPLES_HIGH, 0.02, maxVelocity, maxAccel, maxJerk);
       * Trajectory trajectory = Pathfinder.generate(points, config);
       * 
       * 
       * // 0.6m = 23.75 in wheelbase (dist b/w left and right wheel) TankModifier
       * modifier = new TankModifier(trajectory).modify(0.6); leftFollower = new
       * EncoderFollower(modifier.getLeftTrajectory()); rightFollower = new
       * EncoderFollower(modifier.getRightTrajectory());
       */

      break;
    }
  }

  /**
   * This function is called periodically during autonomous.
   */
  @Override
  public void autonomousPeriodic() {
    Scheduler.getInstance().run();
    switch (m_autoSelected) {
    case kDefaultAuto:
      // Put default auto code here
      // System.out.println("Auto periodic run");
      break;
    case kVisionAuto:
      break;
    }
  }

  @Override
  public void teleopInit() {
    super.teleopInit();
    teleopCameraController.start();
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

/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.autocommands;

import java.io.File;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import jaci.pathfinder.Pathfinder;
import jaci.pathfinder.Trajectory;

public class FollowPathCommand extends Command {

  private String fileLocationLeft;
  private String fileLocationRight;

  public FollowPathCommand(String fileLocationLeft, String fileLocationRight) {
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
    this.fileLocationLeft = fileLocationLeft;
    this.fileLocationRight = fileLocationRight;
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    File leftFile = new File(fileLocationLeft);
    File rightFile = new File(fileLocationRight);
    // Trajectory leftTraj = Pathfinder.readFromCSV(rightFile);
    // Trajectory rightTraj = Pathfinder.readFromCSV(leftFile);
    // Robot.driveTrain.trajectoryFollowInit(leftTraj, rightTraj);
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    Robot.driveTrain.trajectoryFollowRun();
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}

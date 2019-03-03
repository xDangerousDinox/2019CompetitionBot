/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.autocommands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.RobotMap;

public class PIDMoveArm extends Command {

  public int targetAngle;

  public PIDMoveArm(int targetAngle) {
    this.targetAngle = targetAngle;
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    Robot.pidCargoArm.setSetpoint(0.0);
    Robot.pidCargoArm.enable();
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    double y = Robot.oi.operatorStick.getY();
    if (y > 0.2 || y < -0.2) {
      Robot.pidCargoArm.setSetpoint(y);
    } else {
      Robot.pidCargoArm.setSetpoint(0);
    }
    if (Robot.oi.operatorStick.getRawButtonReleased(RobotMap.BRAKE)) {
      Robot.cargoArm.brake();
    }
    if (Robot.oi.operatorStick.getRawButtonReleased(RobotMap.BRAKE_RELEASE)) {
      Robot.cargoArm.releaseBrake();
    }
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    Robot.pidCargoArm.disable();
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}

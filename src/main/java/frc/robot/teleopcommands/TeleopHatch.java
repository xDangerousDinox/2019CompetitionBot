/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.teleopcommands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.RobotMap;

public class TeleopHatch extends Command {

  private boolean isRetractedTop = true;
  private boolean isRetractedBottom = true;
  private boolean isRetractedRotation = true;

  public TeleopHatch() {
    // Use requires() here to declare subsystem dependencies
    requires(Robot.hatchArm);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    if (Robot.oi.operatorStick.getRawButtonReleased(RobotMap.HATCH_TOP)) {
      if (isRetractedTop) {
        Robot.hatchArm.forwardTop();
        isRetractedTop = false;
      } else {
        Robot.hatchArm.reverseTop();
        isRetractedTop = true;
      }
    }
    if (Robot.oi.operatorStick.getRawButtonReleased(RobotMap.HATCH_BOTTOM)) {
      if (isRetractedBottom) {
        Robot.hatchArm.forwardBottom();
        isRetractedBottom = false;
      } else {
        Robot.hatchArm.reverseBottom();
        isRetractedBottom = true;
      }
    }
    if (Robot.oi.operatorStick.getRawButtonReleased(RobotMap.HATCH_ROTATION)) {
      if (isRetractedRotation) {
        Robot.hatchArm.forwardRotation();
        isRetractedRotation = false;
      } else {
        Robot.hatchArm.reverseRotation();
        isRetractedRotation = true;
      }
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
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}

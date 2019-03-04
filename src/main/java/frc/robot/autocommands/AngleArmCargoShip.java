/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.autocommands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class AngleArmCargoShip extends Command {

  // TODO: Tune

  private double targetAngle;

  public AngleArmCargoShip(int targetAngle) {
    this.targetAngle = targetAngle;
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.cargoArm);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    Robot.cargoArm.releaseBrake();
    if (Robot.cargoArm.getAngle() < targetAngle) {
      Robot.pidCargoArm.setSetpoint(0.1);
    } else {
      Robot.pidCargoArm.setSetpoint(-0.1);
    }
    Robot.pidCargoArm.enable();
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    // double angle = Robot.cargoArm.getAngle();
    // if (Math.abs(targetAngle - angle) < 15 && 
    // (Robot.pidCargoArm.getSetpoint() != 0.35 && Robot.pidCargoArm.getSetpoint() != -.15)) {
    //   if (Robot.cargoArm.getAngle() < targetAngle) {
    //     Robot.pidCargoArm.setSetpoint(0.15);
    //   } else {
    //     Robot.pidCargoArm.setSetpoint(-0.15);
    //   }
    // }
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    double angle = Robot.cargoArm.getAngle();
		return angle < (targetAngle + 2.5) && angle > (targetAngle - 2.5);
  } 

  // Called once after isFinished returns true
  @Override
  protected void end() {
    Robot.pidCargoArm.disable();
    Robot.cargoArm.setCargoArm(0);
    Robot.pidCargoArm.setSetpoint(0);
    Robot.cargoArm.brake();
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
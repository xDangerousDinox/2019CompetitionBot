/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.autocommands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class LowerArmCargoShip extends Command {
  // TODO: Tune

  private final double kArmLowerMax = 0.05;


  public LowerArmCargoShip() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.cargoArm);

  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    Robot.cargoBrake.releaseBrake();
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    double angle = Robot.cargoArm.getAngle();
    double out = 0;
    if (angle < 90) {
      out = Math.cos(Math.toRadians(angle)) * kArmLowerMax;
    } else {
      out = -0.05;
    }
    Robot.cargoArm.setCargoArm(out);
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return Robot.cargoArm.getAngle() < 3;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    Robot.cargoArm.setCargoArm(0);
    Robot.cargoBrake.brake();
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}

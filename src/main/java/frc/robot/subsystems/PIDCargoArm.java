/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.PIDSubsystem;
import frc.robot.Robot;
import frc.robot.RobotMap;

/**
 * Add your docs here.
 */
public class PIDCargoArm extends PIDSubsystem {
  /**
   * Add your docs here.
   */
  
  public PIDCargoArm() {
    // Intert a subsystem name and PID values here
    super("PIDCargoArm", 0.4, 0.05, 0);
    setOutputRange(-1, 1);
    // Use these to get going:
    // setSetpoint() - Sets where the PID controller should move the system
    // to
    // enable() - Enables the PID controller.
  }

  public void setP(double P) {
    getPIDController().setP(P);
  }

  public void setI(double I) {
    getPIDController().setI(I);
  }

  public void setD(double D) {
    getPIDController().setD(D);
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }

  @Override
  protected double returnPIDInput() {
    // Return your input value for the PID loop
    // e.g. a sensor, like a potentiometer:
    // yourPot.getAverageVoltage() / kYourMaxVoltage;
    return Robot.cargoArm.getVelocity() / 15.0;
  }

  @Override
  protected void usePIDOutput(double output) {
    // Use output to drive your system, like a motor
    // e.g. yourMotor.set(output);
    Robot.cargoArm.setCargoArm(output);
  }
}

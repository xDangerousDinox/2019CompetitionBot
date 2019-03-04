/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.PIDSubsystem;
import frc.robot.Robot;

/**
 * Add your docs here.
 */
public class PIDCargoArm extends PIDSubsystem {
  /**
   * Add your docs here.
   */

  //private WPI_TalonSRX cargoArm = new WPI_TalonSRX(RobotMap.ARM_CARGO);

  private static final double NERF_SPEED = 1.0;

  private double gearBoxReduction = 0.5;
  private double coefficient = (360 * gearBoxReduction / 4096);
  public static double startingAngle = 150; //see note on HatchArm
  
  public PIDCargoArm() {
    // Intert a subsystem name and PID values here
    super("PIDCargoArm", 0.2, 0.1, 0.05);

    // cargoArm.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, 0); 
    // cargoArm.configSelectedFeedbackCoefficient(coefficient);
    // cargoArm.setSensorPhase(false); //????
    // cargoArm.setSelectedSensorPosition(0, 0, 0);

    setOutputRange(-0.3, 0.3);
    // Use these to get going:
    // setSetpoint() - Sets where the PID controller should move the system
    // to
    // enable() - Enables the PID controller.
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
    return getVelocity();
  }

  @Override
  protected void usePIDOutput(double output) {
    // Use output to drive your system, like a motor
    // e.g. yourMotor.set(output);
    Robot.cargoArm.setCargoArm(output * NERF_SPEED);
  }

  public double getVelocity() {
    return Robot.cargoArm.getSelectedSensorVelocity() * coefficient;
  }
}

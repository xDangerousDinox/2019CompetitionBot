/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

public class HatchArm extends Subsystem {
  
  private DoubleSolenoid hatch = new DoubleSolenoid(1, RobotMap.HATCH_OUT, RobotMap.HATCH_IN);
  private WPI_TalonSRX hatchFall = new WPI_TalonSRX(RobotMap.HATCH_FALL);

  private double gearBoxReduction = 1;

  private double coefficient =  (360 * gearBoxReduction / 4096);

  private double startingAngle = 80;

  public HatchArm() {
    hatchFall.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, 0); 
    hatchFall.configSelectedFeedbackCoefficient(coefficient);
    hatchFall.setSensorPhase(false); //????
    hatchFall.setSelectedSensorPosition(0, 0, 0);
  }

  @Override
  public void initDefaultCommand() {
  }

  public double getAngle() {
    return -1 * hatchFall.getSelectedSensorPosition() + startingAngle;
  }

  public double getVelocity() {
    return -1 * hatchFall.getSelectedSensorVelocity();
  }

  public void setHatchArm(double v) {
    hatchFall.set(v);
  }

  public void forward() {
    hatch.set(DoubleSolenoid.Value.kForward);
  }

  public void reverse() {
    hatch.set(DoubleSolenoid.Value.kReverse);
  }

  public void stop() {
    hatch.set(DoubleSolenoid.Value.kOff);
  }
}

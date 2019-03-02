/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.revrobotics.CANSparkMax;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

/**
 * Add your docs here.
 */
public class Climb extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  private double gearBoxReduction = 1;
  private double coefficient = (360 * gearBoxReduction / 4096);


  // private CANSparkMax climb = new CANSparkMax(RobotMap.CLIMB1, );
  // private CANSparkMax climb2 = new CANSparkMax();

  public Climb() {
    // climb.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, 0); 
    // climb.configSelectedFeedbackCoefficient(coefficient);
    // climb.setSensorPhase(false); //??
    // climb.setSelectedSensorPosition(0, 0, 0);
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }

  public void setClimbMotor(double speed) {
    //climb.set(speed);
  }

  // public double getAngle() {
  //   return climb.getSelectedSensorPosition();
  // }
}

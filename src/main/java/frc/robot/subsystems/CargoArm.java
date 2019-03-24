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
import com.revrobotics.CANSparkMaxLowLevel.ConfigParameter;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.RobotMap;

/**
 * Add your docs here.
 */
public class CargoArm extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  private double gearBoxReduction = 0.5;
  private double coefficient = (360 * gearBoxReduction / 4096);
  public static double startingAngle = 115; //see note on HatchArm

  private WPI_TalonSRX arm = new WPI_TalonSRX(RobotMap.ARM_CARGO);

  public CargoArm() {

    // shoot.setParameter(ConfigParameter.kIdleMode, 1);
    // shoot.setParameter(ConfigParameter.kMotorType, 0);

    arm.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, 0); 
    arm.configSelectedFeedbackCoefficient(coefficient);
    arm.setSensorPhase(false); //????
    arm.setSelectedSensorPosition(0, 0, 0);
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }

  public void setCargoArm(double speed) {
    arm.set(speed);
    SmartDashboard.putNumber("Arm Angle", getAngle());
  }

  public double getAngle() {
    return -1 * arm.getSelectedSensorPosition() + startingAngle;
  }

  public double getVelocity() {
    return -1 * arm.getSelectedSensorVelocity();
  }

  public int getSelectedSensorVelocity() {
    return -1 * this.arm.getSelectedSensorVelocity();
  }
}

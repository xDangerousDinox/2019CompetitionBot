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
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
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

  
  private CANSparkMax shoot = new CANSparkMax(RobotMap.SHOOT, MotorType.kBrushed);
  private WPI_TalonSRX cargoArm = new WPI_TalonSRX(RobotMap.ARM_CARGO);

  private DoubleSolenoid cargoBrake = new DoubleSolenoid(RobotMap.ARM_STOP_IN, RobotMap.ARM_STOP_OUT);

  public CargoArm() {

    cargoArm.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, 0); 
    cargoArm.configSelectedFeedbackCoefficient(coefficient);
    cargoArm.setSensorPhase(false); //????
    cargoArm.setSelectedSensorPosition(0, 0, 0);
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }

  public void setCargoArm(double speed) {
    cargoArm.set(speed);
  }

  public double getAngle() {
    return cargoArm.getSelectedSensorPosition() + startingAngle;
  }

  public int getSelectedSensorVelocity() {
    return this.cargoArm.getSelectedSensorVelocity();
  }

  public void shootOut() {
    shoot.set(0.7);
  }

  public void stopShoot() {
    shoot.set(0);
  }

  public void shootIn() {
    shoot.set(-0.7);
  }

  public void brake() {
    cargoBrake.set(DoubleSolenoid.Value.kReverse);
  }

  public void releaseBrake() {
    cargoBrake.set(DoubleSolenoid.Value.kForward);
  }
}

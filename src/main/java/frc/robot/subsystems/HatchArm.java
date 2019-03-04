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

/**
 * Add your docs here.
 */
public class HatchArm extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  
  //private DoubleSolenoid hatchTop = new DoubleSolenoid(1, RobotMap.HATCH_TOP_PUSH_OUT, RobotMap.HATCH_TOP_PUSH_IN); 
  //private DoubleSolenoid hatchBottom = new DoubleSolenoid(1, RobotMap.HATCH_BOTTOM_PUSH_OUT, RobotMap.HATCH_BOTTOM_PUSH_IN);
  //private DoubleSolenoid hatchRotation = new DoubleSolenoid(1, RobotMap.HATCH_ROTATION_PUSH_OUT, RobotMap.HATCH_ROTATION_PUSH_IN);

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }

  public void forwardBottom() {
    //hatchBottom.set(DoubleSolenoid.Value.kForward);
  }

  public void reverseBottom() {
   // hatchBottom.set(DoubleSolenoid.Value.kReverse);
  }

  public void stopBottom() {
    //hatchBottom.set(DoubleSolenoid.Value.kOff);
  }

  public void forwardTop() {
    //hatchTop.set(DoubleSolenoid.Value.kForward);
  }

  public void reverseTop() {
    //hatchTop.set(DoubleSolenoid.Value.kReverse);
  }

  public void stopTop() {
    //hatchTop.set(DoubleSolenoid.Value.kOff);
  }

  public void forwardRotation() {
    //hatchRotation.set(DoubleSolenoid.Value.kForward);
  }

  public void reverseRotation() {
    //hatchRotation.set(DoubleSolenoid.Value.kForward);
  }

  public void stopRotation() {
    //hatchRotation.set(DoubleSolenoid.Value.kOff);
  }
}

/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

/**
 * Add your docs here.
 */
public class HatchSolenoid extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  private DoubleSolenoid hatch = new DoubleSolenoid(RobotMap.HATCH_OUT, RobotMap.HATCH_IN);

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
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

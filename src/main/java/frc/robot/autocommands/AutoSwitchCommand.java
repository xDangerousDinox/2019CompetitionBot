/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.autocommands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutoSwitchCommand extends CommandGroup {
  /**
   * Add your docs here.
   */

  public AutoSwitchCommand(String endingPosition, String startingPosition) {

    switch(endingPosition){
      case "":
      return;

      case "rightFront":
      addSequential(new FollowPathCommand("/home/lvuser/deploy/" + endingPosition + startingPosition + ".left.pf1.csv", "/home/lvuser/deploy/" + endingPosition + startingPosition + ".right.pf1.csv"));
      addSequential(new AutoAlignCommand());
      addSequential(new PlaceHatchCommand());

      return;

      case "rightFirst":
      addSequential(new FollowPathCommand("/home/lvuser/deploy/" + endingPosition + startingPosition + ".left.pf1.csv", "/home/lvuser/deploy/" + endingPosition + startingPosition + ".right.pf1.csv"));
      addSequential(new AutoAlignCommand());
      addSequential(new PlaceHatchCommand());
      return;

      case "rightSecond":
      addSequential(new FollowPathCommand("/home/lvuser/deploy/" + endingPosition + startingPosition + ".left.pf1.csv", "/home/lvuser/deploy/" + endingPosition + startingPosition + ".right.pf1.csv"));
      addSequential(new AutoAlignCommand());
      addSequential(new PlaceHatchCommand());
      return;

      case "rightThird":
      addSequential(new FollowPathCommand("/home/lvuser/deploy/" + endingPosition + startingPosition + ".left.pf1.csv", "/home/lvuser/deploy/" + endingPosition + startingPosition + ".right.pf1.csv"));
      addSequential(new AutoAlignCommand());
      addSequential(new PlaceHatchCommand());
      return;

      case "leftFront":
      addSequential(new FollowPathCommand("/home/lvuser/deploy/" + endingPosition + startingPosition + ".left.pf1.csv", "/home/lvuser/deploy/" + endingPosition + startingPosition + ".right.pf1.csv"));
      addSequential(new AutoAlignCommand());
      addSequential(new PlaceHatchCommand());
      return;

      case "leftFirst":
      addSequential(new FollowPathCommand("/home/lvuser/deploy/" + endingPosition + startingPosition + ".left.pf1.csv", "/home/lvuser/deploy/" + endingPosition + startingPosition + ".right.pf1.csv"));
      addSequential(new AutoAlignCommand());
      addSequential(new PlaceHatchCommand());
      return;

      case "leftSecond":
      addSequential(new FollowPathCommand("/home/lvuser/deploy/" + endingPosition + startingPosition + ".left.pf1.csv", "/home/lvuser/deploy/" + endingPosition + startingPosition + ".right.pf1.csv"));
      addSequential(new AutoAlignCommand());
      addSequential(new PlaceHatchCommand());
      return;

      case "leftThird":
      addSequential(new FollowPathCommand("/home/lvuser/deploy/" + endingPosition + startingPosition + ".left.pf1.csv", "/home/lvuser/deploy/" + endingPosition + startingPosition + ".right.pf1.csv"));
      addSequential(new AutoAlignCommand());
      addSequential(new PlaceHatchCommand());
      return;

    }
  }
}
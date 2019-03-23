/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableInstance;

/**
 * Add your docs here.
 */
public class RobotTables {

    private NetworkTableInstance inst = NetworkTableInstance.getDefault();
    private NetworkTable visionTable = inst.getTable("VisionTable");

    public int getCenterX() {
        return (int) visionTable.getEntry("centerTargetX").getDouble(RobotMap.CAMERA_WIDTHPX / 2);
    }

    public int leftTargetX() {
        return (int) visionTable.getEntry("leftTargetX").getDouble(RobotMap.CAMERA_WIDTHPX / 2);
    }

    public int rightTargetX() {
        return (int) visionTable.getEntry("rightTargetX").getDouble(RobotMap.CAMERA_WIDTHPX / 2);
    }

    public double distanceTarget() {
        return (int) visionTable.getEntry("distanceTargetIn").getDouble(0);
    }
}

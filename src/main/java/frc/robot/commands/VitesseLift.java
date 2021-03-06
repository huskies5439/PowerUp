/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class VitesseLift extends Command {
  public VitesseLift() {
    requires(Robot.lift);

    // Use requires() here to declare subsystem dependencies
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {

    if (Robot.lift.encoder() < 20) {
      Robot.lift.liftTeleop(Robot.oi.joystick.getRawAxis(3));
    } else if (Robot.lift.encoder() > 30000) {
      Robot.lift.liftTeleop(-0.5 * Robot.oi.joystick.getRawAxis(2)+0.1);
    } else {
      Robot.lift.liftTeleop(Robot.oi.joystick.getRawAxis(3) - 0.5 * Robot.oi.joystick.getRawAxis(2)+0.1);
    }
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}

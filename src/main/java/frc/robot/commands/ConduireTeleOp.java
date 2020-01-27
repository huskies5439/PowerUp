/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;


import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class ConduireTeleOp extends Command {
  public ConduireTeleOp() {
    requires(Robot.basePilotable);
    
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
   Robot.basePilotable.ramp(0.25);

  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    //Robot.basePilotable.conduire(Robot.oi.joystick.getY(),0.8 * Robot.oi.joystick.getX());
    
    Robot.basePilotable.conduireCurve(Robot.oi.joystick.getRawAxis(1), 0.8 * Robot.oi.joystick.getRawAxis(4), Math.abs(Robot.oi.joystick.getY())<0.2);
    /*if (Math.abs(Robot.oi.joystick.getRawAxis(1))>0.2){
      Robot.basePilotable.conduireCurve(Robot.oi.joystick.getRawAxis(1), 0.8 * Robot.oi.joystick.getRawAxis(4), Robot.oi.joystick.getRawButton(6));
    }
    else {
      Robot.basePilotable.conduireCurve(0, Robot.oi.joystick.getRawAxis(4), true);
    }
  */}


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

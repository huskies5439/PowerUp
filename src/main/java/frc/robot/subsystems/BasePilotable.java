/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.commands.ConduireTeleOp;

/**
 * Add your docs here.
 */
public class BasePilotable extends Subsystem {
  private WPI_TalonSRX moteuravantd = new WPI_TalonSRX(10);
  private WPI_TalonSRX moteurarriered = new WPI_TalonSRX(11);
  private WPI_TalonSRX moteuravantg = new WPI_TalonSRX(12);
  private WPI_TalonSRX moteurarriereg = new WPI_TalonSRX(13);
  private SpeedControllerGroup moteurg = new SpeedControllerGroup(moteuravantg, moteurarriereg);
  private SpeedControllerGroup moteurd = new SpeedControllerGroup(moteuravantd, moteurarriered);
  private DifferentialDrive drive = new DifferentialDrive(moteurg, moteurd);

  public BasePilotable(){
    moteuravantd.setInverted(false);
    moteuravantg.setInverted(false);
    moteurarriereg.setInverted(false);
    moteurarriered.setInverted(false);
    moteurarriereg.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder);
    moteurarriered.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder);
    moteurarriered.setSensorPhase(true);
    moteurarriereg.setSensorPhase(false);
  }

  public void conduire(double vx, double vy) {
    drive.arcadeDrive(vx, -vy);
  }
  public void conduireCurve(double vx, double vy, boolean quickturn){
    drive.curvatureDrive(vx, -vy, quickturn);
  }

  // Put methods for controlling this subsystem
  public void ramp(double rate) {
    moteuravantd.configOpenloopRamp(rate);
    moteurarriered.configOpenloopRamp(rate);
    moteuravantg.configOpenloopRamp(rate);
    moteurarriereg.configOpenloopRamp(rate);
  }

  public double velocity() {
    SmartDashboard.putNumber("VelocityGauche", moteurarriereg.getSelectedSensorVelocity());
    SmartDashboard.putNumber("VelocityDroite", moteurarriered.getSelectedSensorVelocity());
    SmartDashboard.putNumber("VelocityMoyenne", (moteurarriereg.getSelectedSensorVelocity()+moteurarriered.getSelectedSensorVelocity())/2.0);
    return (moteurarriereg.getSelectedSensorVelocity()+moteurarriered.getSelectedSensorVelocity())/2.0;
  }

  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new ConduireTeleOp());

    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }

}
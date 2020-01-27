/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;


import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.commands.VitesseLift;;

/**
 * Add your docs here.
 */
public class Lift extends Subsystem {
  private WPI_TalonSRX moteurlift1 = new WPI_TalonSRX(14);
  private WPI_TalonSRX moteurlift2 = new WPI_TalonSRX(15);
  private SpeedControllerGroup moteurlift = new SpeedControllerGroup(moteurlift1,moteurlift2);
  
  public Lift(){
    moteurlift2.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder);
    moteurlift2.setSensorPhase(true);
    moteurlift1.setNeutralMode(NeutralMode.Brake);
    moteurlift2.setNeutralMode(NeutralMode.Brake);
  }
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  
  public void liftTeleop(double v){
    moteurlift.set(v);
  }
  public double encoder(){
    return moteurlift2.getSelectedSensorPosition();
  }
  public void encoderReset(){
    moteurlift2.setSelectedSensorPosition(0);
  }

  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new VitesseLift());

    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}

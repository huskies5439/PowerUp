/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.NidecBrushless;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Add your docs here.
 */
public class Pince extends Subsystem {
  private NidecBrushless moteurg = new NidecBrushless(1, 1);
  private NidecBrushless moteurd = new NidecBrushless(3, 3);
  private DoubleSolenoid piston_pince = new DoubleSolenoid(3, 2);

public void roue_int(){
  moteurd.set(-1);
  moteurg.set(1);
  
}
public void roue_ext(){
  moteurd.set(1);
  moteurg.set(-1);
} 
public void roue_stop(){
  moteurg.set(0);
  moteurd.set(0);
}
public void pince_fermee(){
  piston_pince.set(Value.kForward);
}
public void pince_ouverte(){
  piston_pince.set(Value.kReverse);
}

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}

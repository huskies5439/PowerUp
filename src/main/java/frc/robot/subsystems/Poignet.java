/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.commands.LeverPinceAuto;


/**
 * Add your docs here.
 */
public class Poignet extends Subsystem {
private DoubleSolenoid piston_poignet =new DoubleSolenoid(4, 5);

public void poignet_haut(){
  piston_poignet.set(Value.kForward);
}
public void poignet_bas(){
  piston_poignet.set(Value.kReverse);
}


  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new LeverPinceAuto());
  }
}

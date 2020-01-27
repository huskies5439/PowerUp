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
import frc.robot.commands.ChangementVitesse;

/**
 * Add your docs here.
 */
public class Transmission extends Subsystem {
  private DoubleSolenoid transmission =new DoubleSolenoid(1, 0);

  public void haute_vitesse(){
    transmission.set(Value.kForward);
  }
  public void basse_vitesse(){
    transmission.set(Value.kReverse);
  }
  
  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new ChangementVitesse());
  }
}

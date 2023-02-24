// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.AnalogPotentiometer;


import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Joystick;

import static edu.wpi.first.wpilibj.DoubleSolenoid.Value.*;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Robot;
import frc.robot.RobotContainer;
import frc.robot.RobotMap;
import frc.robot.commands.DriveCommand;
import static edu.wpi.first.wpilibj.DoubleSolenoid.Value.*;

public class DriveSubsystem extends SubsystemBase {
  PWMSparkMax frontRight = new PWMSparkMax(RobotMap.frontRight);
  PWMSparkMax middleRight= new PWMSparkMax(RobotMap.middleRight);
  PWMSparkMax backRight = new PWMSparkMax(RobotMap.backRight);

  
  PWMSparkMax frontLeft = new PWMSparkMax(RobotMap.frontLeft);
  PWMSparkMax middleLeft = new PWMSparkMax(RobotMap.middleLeft);
  PWMSparkMax backLeft = new PWMSparkMax(RobotMap.backLeft);



  MotorControllerGroup left = new MotorControllerGroup(backLeft, frontLeft, middleLeft);
  MotorControllerGroup right = new MotorControllerGroup(backRight, frontRight, middleRight);

    DoubleSolenoid exampleDoublePCM = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, 0, 7);
    DoubleSolenoid exampleDoublePCM2 = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, 1, 6);
 
 
    // Compressor pcmCompressor = new Compressor(0, PneumaticsModuleType.CTREPCM);

    // boolean enabled = pcmCompressor.isEnabled();
    // boolean pressureSwitch = pcmCompressor.getPressureSwitchValue();
    // double current = pcmCompressor.getCurrent();

    // double scale = 250, offset = -25;
    // AnalogPotentiometer pressureTransducer = new AnalogPotentiometer(/* the AnalogIn port*/ 0, scale, offset);

// scaled values in psi units
    // double psi = pressureTransducer.get();


  DifferentialDrive drive;
  /** Creates a new DriverSubsystem. */
  public DriveSubsystem() {
    frontRight.setInverted(false);
    middleRight.setInverted(false);
    backRight.setInverted(false);


    frontLeft.setInverted(true);
    middleLeft.setInverted(true);
    backLeft.setInverted(true);

    drive = new DifferentialDrive(left, right);

    // exampleDoublePCM.set(kOff);
    exampleDoublePCM.set(kReverse);
    exampleDoublePCM.set(kForward);

    // pcmCompressor.disable();
    // exampleDoublePCM2.set(kOff);
    exampleDoublePCM2.set(kReverse);
    exampleDoublePCM2.set(kForward);

  }

  public void drive(double straight, double rotation){
      drive.arcadeDrive(straight, rotation);
      Joystick joystick = Robot.m_robotContainer.getDriverStick();
      SmartDashboard.putNumber("Turret Pot Voltage", 8);
      if (joystick.getRawButton(3)) {
        exampleDoublePCM.toggle();
        // pcmCompressor.enableAnalog(straight, rotation);
        // pcmCompressor.enableDigital();
            
      }
      if (joystick.getRawButton(4)) {
        exampleDoublePCM2.toggle();
      }
      
  }

  public void stop(){
    drive.stopMotor();
  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    setDefaultCommand(new DriveCommand());
  }
}

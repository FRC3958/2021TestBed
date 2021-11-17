// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.Relay.Value;
import frc.robot.commands.Driving;
// import frc.robot.commands.ExampleCommand;
import frc.robot.subsystems.DriveTrain;
// import frc.robot.subsystems.ExampleSubsystem;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
 
/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  // private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();

  // private final ExampleCommand m_autoCommand = new ExampleCommand(m_exampleSubsystem);

  private final DriveTrain m_DT = new DriveTrain(); //initializes drivetrain
  private final XboxController m_XC = new XboxController(Constants.XboxControllerPort);
  private final Driving m_Driving = new Driving(m_DT, m_XC);
  private final Relay m_solenoidrelay = new Relay(Constants.solenoidRelayPort); 

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {


    // Configure the button bindings
    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    m_DT.setDefaultCommand(m_Driving);

    new JoystickButton(m_XC, Constants.ForwardButton) 
      .whenPressed(() -> m_solenoidrelay.set(Value.kOn))
      .whenReleased(() -> m_solenoidrelay.set(Value.kOff));

  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  // public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    // return m_autoCommand;
  }
// }

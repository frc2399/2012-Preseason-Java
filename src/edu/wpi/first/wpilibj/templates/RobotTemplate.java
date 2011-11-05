/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST 2008. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package edu.wpi.first.wpilibj.templates;


import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.DriverStationLCD;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.RobotDrive;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class RobotTemplate extends IterativeRobot {
    //Drivers station LCD for debug statements while driving
    DriverStationLCD lcd;
    
    //Robotdrive object for controlling drivetrain
    RobotDrive driveTrain;
    //Drivetrain motor controllers
    Jaguar frontRightJag, frontLeftJag, backRightJag, backLeftJag;
    
    //Joysticks for tank drive
    Joystick leftStick, rightStick;
    
    //Joystick for mecanum drive
    Joystick twistStick;
    
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
        //Instantiate all objects
        leftStick = new Joystick(1);
        rightStick = new Joystick(2);
        twistStick = new Joystick(3);
        
        frontRightJag = new Jaguar(1);
        frontLeftJag = new Jaguar(2);
        backRightJag = new Jaguar(3);
        backLeftJag = new Jaguar(4);
        
        driveTrain = new RobotDrive(frontLeftJag, backLeftJag, frontRightJag, backRightJag);
        
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {

    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        //This line is used to drive the robot in a tank drive configuration
        driveTrain.tankDrive(leftStick, rightStick);
        
        //This line is used to drive the robot in all directions
        mecanumDrive(twistStick);
    }
    
    /**
     * This function is used to drive the robot in all directions with 
     * mecanum wheels
     */
    private void mecanumDrive(Joystick stick){
        double dtRotation = stick.getZ();
        double dtX = stick.getX();
        double dtY = stick.getY();
        driveTrain.mecanumDrive_Cartesian(dtX, dtY,dtRotation, 0);
    }
}

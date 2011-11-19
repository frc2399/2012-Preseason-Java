    /*----------------------------------------------------------------------------*/
    /* Copyright (c) FIRST 2008. All Rights Reserved.                             */
    /* Open Source Software - may be modified and shared by FRC teams. The code   */
    /* must be accompanied by the FIRST BSD license file in the root directory of */
    /* the project.                                                               */
    /*----------------------------------------------------------------------------*/

    package edu.wpi.first.wpilibj.templates;


    import edu.wpi.first.wpilibj.IterativeRobot;
    import edu.wpi.first.wpilibj.Joystick;
    import edu.wpi.first.wpilibj.RobotDrive;
    import edu.wpi.first.wpilibj.Jaguar; 
    import edu.wpi.first.wpilibj.DigitalInput;

    /**
     * The VM is configured to automatically run this class, and to call the
     * functions corresponding to each mode, as described in the IterativeRobot
     * documentation. If you change the name of this class or the package after
     * creating this project, you must also update the manifest file in the resource
     * directory.
     */
    public class RobotTemplate extends IterativeRobot {

        Joystick armStick, driveStick;
        RobotDrive dt;
        Jaguar armJag; 
        DigitalInput armLimit; 

        /**
         * This function is run when the robot is first started up and should be
         * used for any initialization code.
         */
        public void robotInit() {
            armStick = new Joystick(1);
            driveStick = new Joystick(2);
            dt = new RobotDrive(1,4,8,6);
            armJag = new Jaguar(5);
            armLimit = new DigitalInput(14);

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
            double x, y, rotation;
            x = driveStick.getRawAxis(1); 
            y = -driveStick.getRawAxis(2);
            rotation = -driveStick.getRawAxis(3);
            dt.mecanumDrive_Cartesian(x, rotation,y, 0);//documentaion is wrong
            double armSpeed = -armStick.getRawAxis(2);
            if(armLimit.get()|| (armSpeed >= 0)){
                armJag.set(armSpeed);
            }
            System.out.println(armLimit.get()); 
            armStick.getRawButton(3);
            armStick.getRawButton(2);
            System.out.println(armStick.getRawButton(3));
            System.out.println(armStick.getRawButton(2));
        }

    }

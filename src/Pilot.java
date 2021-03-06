import lejos.hardware.BrickFinder;
import lejos.hardware.ev3.EV3;
import lejos.hardware.motor.Motor;
import lejos.robotics.chassis.Chassis;
import lejos.robotics.chassis.Wheel;
import lejos.robotics.chassis.WheeledChassis;
import lejos.robotics.navigation.MovePilot;

public class Pilot {

	EV3 brick = (EV3) BrickFinder.getDefault();
	Wheel leftWheel = WheeledChassis.modelWheel(Motor.B, 56).offset(-53.2);
	Wheel rigthWheel = WheeledChassis.modelWheel(Motor.C, 56).offset(53.2);
	int distanceOn_mm = 1000;
	int speed = 250;
	int acceleration = 100;

	public void go() {

		Chassis chassis = new WheeledChassis(new Wheel[] { leftWheel, rigthWheel },
				WheeledChassis.TYPE_DIFFERENTIAL);
		MovePilot pilot = new MovePilot(chassis);
		
		
		pilot.setLinearAcceleration(acceleration);
		pilot.setLinearSpeed(speed);
		pilot.setAngularSpeed(50);
		for(int i = 0; i<=3; i++) {
		pilot.rotate(90);
		pilot.travel(distanceOn_mm);
		}
		pilot.rotate(180);
		pilot.stop();
	}

}

import java.awt.geom.Path2D;

import lejos.hardware.BrickFinder;
import lejos.hardware.ev3.EV3;
import lejos.hardware.motor.Motor;
import lejos.robotics.chassis.Chassis;
import lejos.robotics.chassis.Wheel;
import lejos.robotics.chassis.WheeledChassis;
import lejos.robotics.mapping.NavigationModel;
import lejos.robotics.navigation.MovePilot;
import lejos.robotics.navigation.Navigator;
import lejos.robotics.navigation.Waypoint;
import lejos.robotics.pathfinding.Path;

public class NavigationPilot {
	EV3 brick = (EV3) BrickFinder.getDefault();
	Wheel leftWheel = WheeledChassis.modelWheel(Motor.B, 56).offset(-53.2);
	Wheel rigthWheel = WheeledChassis.modelWheel(Motor.C, 56).offset(53.2);
	int speed = 250;
	int acceleration = 100;
	int initialX = 0;
	int initialY = 0;
	int x;
	int y;
	
	public void act() {

		Chassis chassis = new WheeledChassis(new Wheel[] { leftWheel, rigthWheel }, WheeledChassis.TYPE_DIFFERENTIAL);
		MovePilot pilot = new MovePilot(chassis);
		pilot.setLinearAcceleration(acceleration);
		pilot.setLinearSpeed(speed);
		Navigator navi = new Navigator(pilot);
		navi.addWaypoint(40, 101);
		navi.addWaypoint(101,40);
		navi.addWaypoint(0,0);
		navi.followPath();
	}
}

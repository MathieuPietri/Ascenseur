package Requests;

import commandSystem.Direction;

public class EmergencyStopRequest implements Request {
	
	public EmergencyStopRequest() {
	}

	@Override
	public Direction getDirection() {
		return Direction.NONE;
	}

	@Override
	public int getDestinationFloor() {
		return -1;
	}

	@Override
	public int getSourceFloor() {
		return -1;
	}
}

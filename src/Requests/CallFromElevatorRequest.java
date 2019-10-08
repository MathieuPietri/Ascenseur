package Requests;

import commandSystem.Direction;

public class CallFromElevatorRequest implements Request {

	private final int destinationFloor;

	public CallFromElevatorRequest(int destinationFloor) {
		this.destinationFloor = destinationFloor;
	}

	@Override
	public Direction getDirection() {
		return Direction.NONE;
	}

	@Override
	public int getDestinationFloor() {
		return destinationFloor;
	}

	@Override
	public int getSourceFloor() {
		return -1;
	}

}

package Requests;

import commandSystem.Direction;

public class CallFromFloorRequest implements Request {

	private final int sourceFloor;
	private final Direction direction;

	public CallFromFloorRequest(int sourceFloor, Direction direction) {
		this.sourceFloor = sourceFloor;
		this.direction = direction;
	}

	@Override
	public Direction getDirection() {
		return direction;
	}

	@Override
	public int getDestinationFloor() {
		return -1;
	}

	@Override
	public int getSourceFloor() {
		return sourceFloor;
	}
}

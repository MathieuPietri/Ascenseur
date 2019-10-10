package Requests;

import commandSystem.Direction;

public abstract class Request {
	
	protected RequestType type;
	protected int destinationFloor;
	protected int sourceFloor;
	protected Direction direction;
	
	public Request() {
		this.destinationFloor = -1;
		this.sourceFloor = -1;
		this.direction = Direction.NONE;
	}
	
	/**
	 * 
	 * @return the direction of the request, unconcerned extending classes return NONE
	 */
	public Direction getDirection() {
		return Direction.NONE;
	}

	/**
	 * 
	 * @return the wished floor, unconcerned extending classes return -1
	 */
	public int getWantedFloor() {
		return destinationFloor;
	}

	/**
	 * 
	 * @return the floor it was called from, unconcerned extending classes return -1 
	 */
	public int getIncomingCallFloor() {
		return sourceFloor;
	}

	
	public RequestType getType() {
		return type;
	}
}

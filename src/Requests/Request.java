package Requests;

import commandSystem.Direction;

public interface Request {

	/**
	 * 
	 * @return the direction of the request, NONE if it was called from the Elevator
	 *         or if it is an emergency call
	 */
	public Direction getDirection();

	/**
	 * 
	 * @return the wished floor, or -1 if it is an emergency call
	 */
	public int getDestinationFloor();

	/**
	 * 
	 * @return the floor it was called from, -1 if it was called from the Elevator
	 *         or if it is an emergency call
	 */
	public int getSourceFloor();

}

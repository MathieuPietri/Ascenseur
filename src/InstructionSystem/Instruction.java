package InstructionSystem;

import commandSystem.Direction;

public interface Instruction {

	/**
	 * 
	 * @return the direction of the move instruction, NONE if it's an emergency call
	 */
	public Direction getDirection();

	/**
	 * 
	 * @return true if the elevator has to stop next floor, false if it's not or if
	 *         it's an emergency call
	 */
	public boolean stopsAtNextFloor();
}

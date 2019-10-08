package InstructionSystem;

import commandSystem.Direction;

public class MoveInstruction implements Instruction {

	Direction direction;
	boolean stopsAtNextFloor;

	public MoveInstruction(Direction direction, boolean stopsAtNextFloor) {
		this.direction = direction;
		this.stopsAtNextFloor = stopsAtNextFloor;
	}

	@Override
	public Direction getDirection() {
		return direction;
	}

	@Override
	public boolean stopsAtNextFloor() {
		return stopsAtNextFloor;
	}

}

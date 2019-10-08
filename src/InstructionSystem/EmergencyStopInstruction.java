package InstructionSystem;

import commandSystem.Direction;

public class EmergencyStopInstruction implements Instruction {

	public EmergencyStopInstruction() {
	}

	@Override
	public Direction getDirection() {
		return Direction.NONE;
	}

	@Override
	public boolean stopsAtNextFloor() {
		return false;
	}

}

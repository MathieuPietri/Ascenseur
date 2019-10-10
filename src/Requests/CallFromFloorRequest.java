package Requests;

import commandSystem.Direction;

public class CallFromFloorRequest extends Request {


	public CallFromFloorRequest(int sourceFloor, Direction direction) {
		super();
		this.sourceFloor = sourceFloor;
		this.direction = direction;
		this.type = RequestType.CALLFROMFLOOR;
	}

}

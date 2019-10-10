package Requests;

public class CallFromElevatorRequest extends Request {

	public CallFromElevatorRequest(int destinationFloor) {
		super();
		this.destinationFloor = destinationFloor;
		this.type = RequestType.CALLFROMELEVATOR;
	}
}

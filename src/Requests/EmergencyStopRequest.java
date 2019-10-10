package Requests;

public class EmergencyStopRequest extends Request {
	
	public EmergencyStopRequest() {
		super();
		this.type = RequestType.EMERGENCYSTOP;
	}
}

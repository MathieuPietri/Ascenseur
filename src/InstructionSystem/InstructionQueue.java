package InstructionSystem;

import java.util.ArrayList;

import Requests.Request;

public abstract class InstructionQueue {

	protected ArrayList<Request> requests;
	protected ArrayList<Instruction> instructions;
	
	public InstructionQueue() {
		requests = new ArrayList<>();
		instructions = new ArrayList<>();
	}
	
	public void addRequest(Request request) {
		requests.add(request);
	}
	
	
	public abstract void computeNextRequest();
	
	
}

package InstructionSystem;

import Requests.Request;

public abstract class defaultInstructionQueue extends InstructionQueue {

	@Override
	public void computeNextRequest() {
		if (requests.isEmpty())
			return;
		Request nextRequest = requests.get(0);
		
		//TODO algorithme de Dylan
		//accès à la liste des instructions : 
		//instructions
	}
	
}

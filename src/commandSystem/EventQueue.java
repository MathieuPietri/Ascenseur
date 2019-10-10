package commandSystem;

import java.util.ArrayList;
import java.util.Collections;

import Requests.Request;

// emergencyStop -> clear the queue

public class EventQueue {
	private ArrayList<Integer> upQueue = new ArrayList<>();
	private ArrayList<Integer> downQueue = new ArrayList<>();
	
	private Elevator elevator;

	/**
	 * Add new floor to <b>queue</b> queue and sort it to keep floors order
	 * 
	 * @param queue   ArrayList<Int>
	 * @param floor   int - the floor we add to queue
	 * @param reversed boolean - reverse queue order
	 */
	public void appSort(ArrayList<Integer> queue, int floor, boolean reversed) {
		queue.add(floor);
		if (reversed)
			Collections.sort(queue, Collections.reverseOrder());
		else
			Collections.sort(queue);
	}

	/**
	 * Compute a request into the {@link #EventQueue} depending on the elevator status
	 * 
	 * @param request - the request to compute
	 */
	public void computeRequest(Request request) {

		switch (request.getType()) {
		case CALLFROMFLOOR:
			switch (request.getDirection()) {
			case UP:
				if (!upQueue.contains(request.getWantedFloor()))
					appSort(upQueue, request.getIncomingCallFloor(), false);
				break;
			case DOWN:
				if (!downQueue.contains(request.getWantedFloor()))
					appSort(downQueue, request.getIncomingCallFloor(), true);
				break;
			default:
				break;
			}
		case CALLFROMELEVATOR:
			if (request.getWantedFloor() > elevator.getCurrentFloor() && !upQueue.contains(request.getWantedFloor()))
				appSort(upQueue, request.getWantedFloor(), false);
			else if (request.getWantedFloor() < elevator.getCurrentFloor() && !upQueue.contains(request.getWantedFloor()))
				appSort(downQueue, request.getWantedFloor(), true);
			break;
		case EMERGENCYSTOP:
			//TODO Clear queues and add 
		default:
			break;
		}
	}

	/**
	 * removes one instruction from the queue - call when the elevator reaches targeted floor
	 * 
	 * @param reachedFloor
	 * @param direction of elevators
	 */
	public void removeInstruction(int reachedFloor, Direction direction) {
		switch (direction) {
		case UP:
			if (upQueue.contains(reachedFloor))
				upQueue.remove(upQueue.indexOf(reachedFloor));
			else // we go up to the top of descending queue
				downQueue.remove(downQueue.indexOf(reachedFloor));
		case DOWN:
			if (downQueue.contains(reachedFloor))
				downQueue.remove(downQueue.indexOf(reachedFloor));
			else // we go down to the bottom of ascending queue
				upQueue.remove(upQueue.indexOf(reachedFloor));
		default:
			break;
		}
	}

	/**
	 * Return the next floor the elevator have to go to
	 * 
	 * @return next floor if exists else -1
	 */
	
	//TODO Incorrect
	public int getNextInstruction() {
		
		int nextFloor = -1;
		switch (elevator.getCurrentDirection()) {
		
		//TODO : get first element of upQueue that is ABOVE the elevator's current floor
		case UP:
			for (int i = 0; i < upQueue.size() && nextFloor < 0; i++) {
				if (upQueue.get(i) >= elevator.getCurrentFloor()) {
					nextFloor = upQueue.get(i);
				}
			}
			// if no floor found in upQueue, change direction //TODO : change direction only if every floor in upQueue is UNDER the elevator's current floor
			if (nextFloor < 0 && downQueue.size() > 0) {
				nextFloor = downQueue.get(0);
			}
			break;
			
		//TODO : get first element of downQueue that is UNDER the elevator's current floor
		case DOWN:
			for (int i = 0; i < downQueue.size() && nextFloor < 0; i++) {
				if (upQueue.get(i) <= elevator.getCurrentFloor()) {
					nextFloor = upQueue.get(i);
				}
			}
			// if no floor found in downQueue, change direction //TODO : change direction only if every floor in downQueue is ABOVE the elevator's current floor
			if (nextFloor < 0 && upQueue.size() > 0) {
				nextFloor = upQueue.get(0);
			}
			break;
		default:
			break;
		}
		return nextFloor;
	}

}
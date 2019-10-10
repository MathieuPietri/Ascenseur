package commandSystem;

public interface Elevator {

	
	public void sendFloorReachedNotification();
	public int getCurrentFloor();
	public Direction getCurrentDirection();
}

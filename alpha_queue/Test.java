import java.io.*;

public class Test {
    private static int elevatorFloor;
    private static Direction elevatorDir;
    private static boolean running = false;
    private static EventQueue queue;

    public static void iter() {
        int nextDestination = queue.getFirstTarget(elevatorFloor, elevatorDir);
        // System.out.println("next dest = " + nextDestination);
        if (!running) {
            if (nextDestination > 0) { // return -1 if no next destination
                running = true;
                elevatorDir = elevatorFloor < nextDestination ? Direction.UP : Direction.DOWN;
            }
        } else {
            if (elevatorFloor == nextDestination) {
                queue.delEvent(elevatorFloor, elevatorDir);
                running = false;
            } else {
                elevatorDir = elevatorFloor < nextDestination ? Direction.UP : Direction.DOWN;
                elevatorFloor += elevatorDir == Direction.UP ? 1 : -1;
            }
        }
        System.out.println("elevator floor " + elevatorFloor + " direction " +
             (elevatorDir == Direction.UP? "up" : "down") + " running: " + running);
    }

    public static void main(String[] args) {
        queue = new EventQueue();
        elevatorDir = Direction.UP;
        elevatorFloor = 0;
        iter();
        iter();
        queue.addEvent(elevatorFloor, elevatorDir, 2, Direction.DOWN);
        iter();
        System.out.println("someone call from floor 2 to go down");
        iter();
        queue.addEvent(elevatorFloor, elevatorDir, 1, Direction.UP);
        System.out.println("someone call from floor 1 to go up");
        iter();
        queue.addEvent(elevatorFloor, elevatorDir, 5, Direction.NONE);
        System.out.println("the guy who entered push on floor 5");

        iter();
        iter();
        iter();
        iter();
        iter();
        iter();
        iter();
        iter();
        iter();
        iter();
        iter();
        iter();
        
    }
}
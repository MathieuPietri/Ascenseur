import java.util.*;
import src.commandSystem.Direction;

// emergencyStop -> clear the queue

public class EventQueue {
    private ArrayList<Int> upQueue = new ArrayList<Int>();
    private ArrayList<Int> downQueue = new ArrayList<Int>();

    /**
     * Add new floor to <b>queue</b> queue and sort it to keep floors order
     * @param queue ArrayList<Int>
     * @param floor int - the floor we add to queue
     * @param reverse boolean - reverse queue order
     */
    public void appSort(ArrayList<Int> queue, int floor, boolean reverse) {
        queue.push(floor);
        if (reverse)
            Collection.sort(queue, Collection.reverseOrder());
        else
            Collection.sort(queue);
    }

    /**
     * Add new event to the {@link #EventQueue} depending of the elevator status
     * @param elevatorFloor
     * @param elevatorDir
     * @param wantedFloor
     * @param wantedDir {@link #Direction} of the requests, NONE if it came from the elevator
     */
    public void addEvent(int elevatorFloor, Direction elevatorDir, int wantedFloor, Direction wantedDir) {
        switch (wantedDir) {
            case UP:
                if (!upQueue.contains(wantedFloor))
                    appSort(upQueue, wantedFloor, false);
                break;
            case DOWN:
                if (!downQueue.contains(wantedFloor))
                    appSort(downQueue, wantedFloor, true);
                break;
            case NONE:
                if (wantedFloor > elevatorFloor && !upQueue.contains(wantedFloor))
                    appSort(upQueue, wantedFloor, false);
                else if (wantedFloor < elevatorFloor && !upQueue.contains(wantedFloor))
                    appSort(downQueue, wantedFloor, true);
                break;
        }
    }

    /**
     * del one event of the queue - to call when arrive to target floor
     * @param floor
     * @param direction of elevator
     */
    public void delEvent(int floor, Direction direction) {
        switch (direction) {
            case UP:
                if (upQueue.contains(floor))
                    upQueue.remove(upQueue.indexOf(floor));
                else // we go up to the top of descending queue
                    downQueue.remove(downQueue.indexOf(floor));
            case DOWN:
                if (downQueue.contains(floor))
                    downQueue.remove(downQueue.indexOf(floor));
                else // we go down to the bottom of ascending queue
                    upQueue.remove(upQueue.indexOf(floor));
        }
    }

    /**
     * Return the next floor the elevator have to go to
     * @param elevatorFloor
     * @param elevatorDir
     * @return next floor if exists else -1
     */
    public int getFirstTarget(int elevatorFloor, Direction elevatorDir) {
        int nextFloor = -1;
        switch (elevatorDir) {
            case UP:
                for (int i = 0; i < upQueue.size() && nextFloor < 0; i++) {
                    if (upQueue.get(i) >= elevatorFloor) {
                        nextFloor = upQueue.get(i);
                    }
                }
                // if no floor found in upqueue, change direction
                if (nextFloor < 0 && downQueue.size() > 0) {
                    nextFloor = downQueue.get(0)
                }
                break;
            case DOWN:
                for (int i = 0; i < downQueue.size() && nextFloor < 0; i++) {
                    if (upQueue.get(i) <= elevatorFloor) {
                        nextFloor = upQueue.get(i);
                    }
                }
                // if no floor found in downqueue, change direction
                if (nextFloor < 0 && upQueue.size() > 0) {
                    nextFloor = upQueue.get(0)
                }
                break;
        }
        return nextFloor;
    }

}
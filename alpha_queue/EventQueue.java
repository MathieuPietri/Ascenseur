// emergencyStop -> clear the queue
import java.util.ArrayList;
import java.util.Collections;

import java.io.*; // test

public class EventQueue {
    private ArrayList<Integer> upQueue;
    private ArrayList<Integer> downQueue;


    EventQueue() {
        upQueue = new ArrayList<Integer>();
        downQueue = new ArrayList<Integer>();
    }

    /**
     * Add new floor to <b>queue</b> queue and sort it to keep floors order
     * @param queue ArrayList<Integer>
     * @param floor int - the floor we add to queue
     * @param reverse boolean - reverse queue order
     */
    public void appSort(ArrayList<Integer> queue, int floor, boolean reverse) {
        queue.add(floor);
        if (reverse)
            Collections.sort(queue, Collections.reverseOrder());
        else
            Collections.sort(queue);
        // System.out.println("we added " + floor + " now we have:");
        // System.out.println("upQueue: " + upQueue);
        // System.out.println("downQueue: " + downQueue);
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
        // System.out.println("we wan't to remove " + floor + " with dir " + direction);
        // System.out.println("upQueue: " + upQueue);
        // System.out.println("downQueue: " + downQueue);
        // System.out.println("downQueue.contains(floor)=" + downQueue.contains(floor));
        // System.out.println("index of floor in downQueue: " + downQueue.indexOf(floor));
        // System.out.println("upQueue.contains(floor)=" + upQueue.contains(floor));        
        // System.out.println("index of floor in upQueue: " + upQueue.indexOf(floor));
        switch (direction) {
            case UP:
                if (upQueue.contains(floor))
                    upQueue.remove(upQueue.indexOf(floor));
                else // we go up to the top of descending queue
                    downQueue.remove(downQueue.indexOf(floor));
                break;
            case DOWN:
                if (downQueue.contains(floor))
                    downQueue.remove(downQueue.indexOf(floor));
                else // we go down to the bottom of ascending queue
                    upQueue.remove(upQueue.indexOf(floor));
                break;
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
                    nextFloor = downQueue.get(0);
                }
                break;
            case DOWN:
                for (int i = 0; i < downQueue.size() && nextFloor < 0; i++) {
                    if (downQueue.get(i) <= elevatorFloor) {
                        nextFloor = downQueue.get(i);
                    }
                }
                // if no floor found in downqueue, change direction
                if (nextFloor < 0 && upQueue.size() > 0) {
                    nextFloor = upQueue.get(0);
                }
                break;
        }
        return nextFloor;
    }

    public void clearQueue() {
        downQueue.removeAll(downQueue);
        upQueue.removeAll(upQueue);
    }

}
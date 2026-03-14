import java.util.Iterator;
import java.util.LinkedList;

public class ScheduleManager {

    private LinkedList<Schedule> schedules;

    public ScheduleManager() {
        schedules = new LinkedList<>();
    }

    public void addFirst(Schedule s) {
        schedules.addFirst(s);
    }

    public void addLast(Schedule s) {
        schedules.addLast(s);
    }

    public void removeFirst() {

        if(!schedules.isEmpty())
            schedules.removeFirst();
    }

    public void removeLast() {

        if(!schedules.isEmpty())
            schedules.removeLast();
    }

    public void showSchedules() {

        Iterator<Schedule> it = schedules.iterator();

        while(it.hasNext()){
            it.next().displayInfo();
        }
    }

    public void searchRoute(String origin, String destination){

        for(Schedule s : schedules){

            if(s.getOrigin().equalsIgnoreCase(origin) &&
                    s.getDestination().equalsIgnoreCase(destination)){

                s.displayInfo();
            }
        }
    }

    public void cleanupDestination(String destination){

        Iterator<Schedule> it = schedules.iterator();

        while(it.hasNext()){

            Schedule s = it.next();

            if(s.getDestination().equalsIgnoreCase(destination)){
                it.remove();
            }
        }
    }
}
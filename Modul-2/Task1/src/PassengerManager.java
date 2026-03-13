import java.util.ArrayList;

public class PassengerManager {
    private ArrayList<Passenger> passengers;

    public PassengerManager(){
        passengers = new ArrayList<>();
    }

    public void addPassenger(Passenger p){
        passengers.add(p);
    }

    public Passenger getPassenger(int index){
        return  passengers.get(index);
    }

    public Passenger findPassenger(String name){
        for(Passenger p : passengers){
            if(p.getName().equalsIgnoreCase(name)){
                return p;
            }
        }
        return null;
    }

    public void updatePassenger(int index, String name, String email, String phone, int age) {
        Passenger p = passengers.get(index);
        p.setName(name);
        p.setEmail(email);
        p.setPhone(phone);
        p.setAge(age);
    }

    public void removePassengerById(int id) {

        for (Passenger p : passengers) {

            if (p.getPassengerId() == id) {
                passengers.remove(p);
                System.out.println("Passenger with ID " + id + " successfully removed.");
                return;
            }

        }

        System.out.println("Passenger ID not found.");
    }

    public void showPassengers() {
        if (passengers.isEmpty()) {
            System.out.println("Passenger list empty.");
            return;
        }

        for (Passenger p : passengers) {
            System.out.println(p);
        }
    }
}

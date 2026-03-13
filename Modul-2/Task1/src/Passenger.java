public class Passenger {
    private static int idCounter = 1;

    private int passengerId;
    private String name;
    private String email;
    private String phone;
    private int age;

    public Passenger(String name, String email, String phone, int age){
        this.passengerId = idCounter++;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.age = age;
    }

    public int getPassengerId(){
        return passengerId;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void displayInfo() {
        System.out.println(passengerId + " | " + name + " | " + email + " | " + phone + " | Age: " + age);
    }

    @Override
    public String toString(){
        return "Passenger ID: " + passengerId +
                ", Name: " + name +
                ", Email: " + email +
                ", Phone: " + phone +
                ", Age: " + age;
    }
}

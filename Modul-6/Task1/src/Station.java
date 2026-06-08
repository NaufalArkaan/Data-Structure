public class Station {
    String code;
    String name;
    String city;

    public Station(String code, String name, String city) {
        this.code = code;
        this.name = name;
        this.city = city;
    }

    @Override
    public String toString() {
        return code + " - " + name + " (" + city + ")";
    }
}
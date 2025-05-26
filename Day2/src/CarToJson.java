class Car {
    String brand;
    String model;
    int year;

    public Car(String brand, String model, int year) {
        this.brand = brand;
        this.model = model;
        this.year = year;
    }

    public String toJson() {
        return "{"
                + "\"brand\":\"" + brand + "\","
                + "\"model\":\"" + model + "\","
                + "\"year\":" + year
                + "}";
    }
}

public class CarToJson {
    public static void main(String[] args) {
        Car car = new Car("Honda", "City", 2022);
        System.out.println(car.toJson());
    }
}
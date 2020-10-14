public class Car_6Dinh {
    public static void main(String[] args) {
        Car myCar = new Car();
        System.out.println(myCar);

        Car momCar = new Car("Toyata Prius", 2019, 5273);
        momCar.drive(7);
        System.out.println(momCar);
    }
}

class Car {
    private String name;
    private int year;
    private int miles;

    public Car() {
        name = "Honda Civic";
        year = 2021;
        miles = 0;
    }

    public Car(String carName, int carYear, int carMiles) {
        name = carName;
        year = carYear;
        miles = carMiles;
    }

    public String toString() {
        return "The " + year + " " + name + ", has " + miles + " miles.";
    }

    public void drive(int milesDriven) {
        miles = miles + milesDriven;
    }
}

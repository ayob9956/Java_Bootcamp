public abstract class Passenger {
 String name;
 String id;
 double tripCost;
Cars reservedCar;

    public Passenger() {

    }


    public abstract void reserveCar() throws Exception;

    public abstract void display();

    public Passenger(String name, String id, Cars car) {
        this.name = name;
        this.id = id;
        this.reservedCar = car;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getTripCost() {
        return tripCost;
    }

    public void setTripCost(double tripCost) {
        this.tripCost = tripCost;
    }

    public Cars getReservedCar() {
        return reservedCar;
    }

    public void setReservedCar(Cars reservedCar) {
        this.reservedCar = reservedCar;
    }
}

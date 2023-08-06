public class Subscribers extends Passenger {


    public Subscribers(String name, String id, Cars car) {
        super(name, id, car);
    }

    public Subscribers() {

    }

    @Override
    public void reserveCar() throws Exception {
        if (reservedCar.getMaxCapacity() == 0) {
            throw new Exception("exception if the maximum capacity of the car was equal to zero");
        }else tripCost = (reservedCar.getFixedRoute().getTripPrice() * 0.5);
    }




    @Override
    public void display() {
        System.out.println("Subscriber Name : " + name +
                " id : " + id +
                " car code : " + reservedCar.getCode() +
                " route price : " + reservedCar.getFixedRoute().getTripPrice() +
                " trip cost : " + tripCost);
    }
    }


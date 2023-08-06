public class NonSubscribers extends Passenger{



    boolean discountCo;


    public NonSubscribers(String name, String id , Cars car, boolean discountCo) {
        super(name, id, car);
        this.discountCo = discountCo;
    }

    @Override
    public void reserveCar() throws Exception {





            if (super.reservedCar.maxCapacity == 0) {
                throw new Exception("maximum capacity of the car was equal to zero");
            }
            if (discountCo) {
               tripCost = reservedCar.getFixedRoute().getTripPrice() - (reservedCar.getFixedRoute().getTripPrice() * 0.1);
            } else {
                tripCost = reservedCar.getFixedRoute().getTripPrice();
            }
    }

    @Override
    public void display() {
        System.out.println("nonSubscriber name : " + name +
                " id : " + id + " car code:" + reservedCar.getCode() +
                " route price : " + reservedCar.getFixedRoute().getTripPrice() +
                " trip cost :" + tripCost);

    }
}

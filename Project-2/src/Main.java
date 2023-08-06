// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Route r1 = new Route("start1", "end1", 150.0);
        Route r2 = new Route("start2", "end2", 280.0);

        Cars c1 = new Cars("car1", r1, 5);
        Cars c2 = new Cars("car2", r2, 1);

        Passenger[] passengers = new Passenger[2];
        passengers[0] = new Subscribers("ahmad","1233",c1);


        passengers[1] = new NonSubscribers("Ali","12",c2,true);

        try {
            passengers[0].reserveCar();
            passengers[1].reserveCar();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return;
        }

        for (Passenger passenger : passengers) {
            passenger.display();
        }

    }
}
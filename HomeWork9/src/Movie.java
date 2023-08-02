public class Movie extends Product{

    private String director;

    public Movie() {
    }

    public Movie(String name, double price, String director) {
        super(name, price);
        this.director = director;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    @Override
    double getDiscount() {
        return getPrice()-(getPrice()*0.15);
    }

    @Override
    public String toString() {
        return "Movie{" +
                "director='" + director + '\'' +
                " After Discuont price ='" + getDiscount() + '\'' +
                "} " + super.toString();
    }
}

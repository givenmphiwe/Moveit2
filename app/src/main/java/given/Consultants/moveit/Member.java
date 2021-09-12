package given.Consultants.moveit;

public class Member {

    private String Location;
    private Integer Price;
    private Integer Bedroom;
    private Float square;
    // TODO: adding the private String for image in the member class folder

    public Member() {
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }

    public Integer getPrice() {
        return Price;
    }

    public void setPrice(Integer price) {
        Price = price;
    }

    public Integer getBedroom() {
        return Bedroom;
    }

    public void setBedroom(Integer bedroom) {
        Bedroom = bedroom;
    }

    public Float getSquare() {
        return square;
    }

    public void setSquare(Float square) {
        this.square = square;
    }
}

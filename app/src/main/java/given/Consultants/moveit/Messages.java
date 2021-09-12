package given.Consultants.moveit;

public class Messages {

    //Model class
    String ImageUrl;
    String Beds;
    String Loca;
    String Pric;
    String squa;

    //Constructors
    public Messages() {
    }

    public Messages(String imageUrl, String beds, String loca, String pric, String squa) {
        ImageUrl = imageUrl;
        Beds = beds;
        Loca = loca;
        Pric = pric;
        this.squa = squa;
    }

    public String getImageUrl() {
        return ImageUrl;
    }

    public void setImageUrl(String imageUrl) {
        ImageUrl = imageUrl;
    }

    public String getBeds() {
        return Beds;
    }

    public void setBeds(String beds) {
        Beds = beds;
    }

    public String getLoca() {
        return Loca;
    }

    public void setLoca(String loca) {
        Loca = loca;
    }

    public String getPric() {
        return Pric;
    }

    public void setPric(String pric) {
        Pric = pric;
    }

    public String getSqua() {
        return squa;
    }

    public void setSqua(String squa) {
        this.squa = squa;
    }
}

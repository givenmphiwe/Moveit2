package given.Consultants.moveit;

public class uploadinfo {

    public String imageName;
    public String imageURL;
    public String imagePrice;
    public String imageLocation;
    public String imageEmail;

    public  uploadinfo(){}

    public uploadinfo(String imageName, String imageURL, String imagePrice, String imageLocation, String imageEmail) {
        this.imageName = imageName;
        this.imageURL = imageURL;
        this.imagePrice = imagePrice;
        this.imageLocation = imageLocation;
        this.imageEmail = imageEmail;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public String getImagePrice() {
        return imagePrice;
    }

    public void setImagePrice(String imagePrice) {
        this.imagePrice = imagePrice;
    }

    public String getImageLocation() {
        return imageLocation;
    }

    public void setImageLocation(String imageLocation) {
        this.imageLocation = imageLocation;
    }

    public String getImageEmail() {
        return imageEmail;
    }

    public void setImageEmail(String imageEmail) {
        this.imageEmail = imageEmail;
    }
}

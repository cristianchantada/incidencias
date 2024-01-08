public class GeoCoordinates {

    private double latitude;
    private double longitude;

    GeoCoordinates(){}

    GeoCoordinates(double latitude){
        this();
        this.latitude = latitude;
    }

    GeoCoordinates(double latitude, Double longitude){
        this();
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
}

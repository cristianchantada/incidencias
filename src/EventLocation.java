import java.io.File;

public class EventLocation {

    private String eventLocation;
    private String eventPhoto;
    private GeoCoordinates coordinates;

    EventLocation(){}

    EventLocation(String eventLocation){
        this();
        this.eventLocation = eventLocation;
    }

    EventLocation(String eventLocation, GeoCoordinates coordinates){
        this(eventLocation);
        this.coordinates = coordinates;
    }

    EventLocation(String eventLocation, GeoCoordinates coordinates, String eventPhoto){
        this(eventLocation);
        this.eventPhoto = eventPhoto;
    }

    public String getEventLocation() {
        return eventLocation;
    }

    public void setEventLocation(String eventLocation) {
        this.eventLocation = eventLocation;
    }

    public String getEventPhoto() {
        return eventPhoto;
    }

    public void setEventPhoto(String eventPhoto) {
        this.eventPhoto = eventPhoto;
    }

    public GeoCoordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(GeoCoordinates coordinates) {
        this.coordinates = coordinates;
    }
}

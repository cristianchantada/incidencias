import java.util.Date;

public class HappenedAt {

    private Date dateDetection;
    private Date dateNotification;

    HappenedAt(){}

    HappenedAt(Date dateNotification){
        this();
        this.dateNotification = dateNotification;
    }

    HappenedAt(Date dateNotification, Date dateDetection){
        this(dateNotification);
        this.dateDetection = dateDetection;
    }

    public Date getDateDetection() {
        return this.dateDetection;
    }

    public void setDateDetection(Date dateDetection) {
        this.dateDetection = dateDetection;
    }

    public Date getDateNotification() {
        return this.dateNotification;
    }

    public void setDateNotification(Date dateNotification) {
        this.dateNotification = dateNotification;
    }
}

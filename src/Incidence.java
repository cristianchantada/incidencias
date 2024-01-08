public class Incidence {

    private int id = 0;
    private MainType type;
    private Subtype subtype;
    private String summary;
    private HappenedAt when;
    private EventLocation where;
    private String description;
    private Person responsible;
    private Person[] supervisor;
    private String[] notificationTask;

    Incidence(){}

    Incidence(MainType type){
        this();
        this.id = ++id;
        this.type = type;
    }

    Incidence(MainType type, Subtype subtype) {
        this(type);
        this.subtype = subtype;
    }

    Incidence(MainType type, Subtype subtype, String summary){
        this(type, subtype);
        this.summary = summary;
    }

    Incidence(MainType type, Subtype subtype, String summary, HappenedAt when){
        this(type, subtype, summary);
        this.when = when;
    }

    Incidence(MainType type, Subtype subtype, String summary, HappenedAt when,
              EventLocation where){
        this(type, subtype, summary, when);
        this.where = where;
    }

    Incidence(MainType type, Subtype subtype, String summary, HappenedAt when,
              EventLocation where, String description){
        this(type, subtype, summary, when, where);
        this.description = description;
    }

    Incidence(MainType type, Subtype subtype, String summary, HappenedAt when,
              EventLocation where, String description, Person responsible){
        this(type, subtype, summary, when, where, description);
        this.responsible = responsible;
    }

    Incidence(MainType type, Subtype subtype, String summary, HappenedAt when,
              EventLocation where, String description, Person responsible, Person[] supervisor){
        this(type, subtype, summary, when, where, description, responsible);
        this.supervisor = supervisor;
    }

    Incidence( MainType type, Subtype subtype, String summary, HappenedAt when,
              EventLocation where, String description, Person responsible, Person[] supervisor, String[] notificationTask){
        this(type, subtype, summary, when, where, description, responsible, supervisor);
        this.notificationTask = notificationTask;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public MainType getType() {
        return type;
    }

    public void setType(MainType type) {
        this.type = type;
    }

    public Subtype getSubtype() {
        return subtype;
    }

    public void setSubtype(Subtype subtype) {
        this.subtype = subtype;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public HappenedAt getWhen() {
        return when;
    }

    public void setWhen(HappenedAt when) {
        this.when = when;
    }

    public EventLocation getWhere() {
        return where;
    }

    public void setWhere(EventLocation where) {
        this.where = where;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Person getResponsible() {
        return responsible;
    }

    public void setResponsible(Person responsible) {
        this.responsible = responsible;
    }
    public Person[] getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(Person[] supervisor) {
        this.supervisor = supervisor;
    }

    public String[] getNotificationTask() {
        return notificationTask;
    }

    public void setNotificationTask(String[] notificationTask) {
        this.notificationTask = notificationTask;
    }
}

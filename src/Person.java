public class Person {

    private String email;
    private int number;
    private String firstname;
    private String lastnames;

    Person(){}

    Person(String firstname){
        this();
        this.firstname = firstname;
    }

    Person(String firstname, String lastnames){
        this(firstname);
        this.lastnames = lastnames;
    }

    Person(String firstname, String lastnames, String email){
        this(firstname, lastnames);
        this.email = email;
    }

    Person(String firstname, String lastnames, String email, int number){
        this(firstname, lastnames, email);
        this.firstname = firstname;
    }

    public String getEmail() {
        return this.email;
    }

    public int getNumber(){
        return this.number;
    }

    public String getName(){
        return this.firstname;
    }

    public String getLastnames(){
        return this.lastnames;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setNumber(int number){
        this.number = number;
    }

    public void setFirstname(String firstname){
        this.firstname = firstname;
    }

    public void setLastnames(String lastnames){
        this.lastnames = lastnames;
    }
}

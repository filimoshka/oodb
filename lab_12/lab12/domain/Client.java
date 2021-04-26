package lab12.domain;

import javax.persistence.*;

@Entity
public class Client {

    @Id
    @SequenceGenerator(name="Client", sequenceName="client_seq", allocationSize=1)
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="Client")
    private int id;

    @Column
    private String firstname;

    @Column
    private String lastname;

    @Column
    private String phonenumber;

    @Column
    private String email;


    public String getFirstnameame() {
        return firstname;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public String getEmail() {
        return email;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}


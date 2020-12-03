package lab5.model;

import org.postgresql.util.PGobject;
import org.postgresql.util.PGtokenizer;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.sql.SQLException;
import java.util.List;

@XmlRootElement(name = "client")
@XmlAccessorType(XmlAccessType.FIELD)

public class Client extends PGobject {

    public Client(){
        setType("client");
    }

    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;

    public Client(String firstName, String lastName, String phoneNumber, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public void setValue(String value) throws SQLException {
        String str = value.substring(1, value.length()-1);
        PGtokenizer pgt = new PGtokenizer(str, ',');
        firstName = pgt.getToken(0).substring(1, pgt.getToken(0).length()-1);
        lastName = pgt.getToken(1).substring(1, pgt.getToken(1).length()-1);
        phoneNumber = pgt.getToken(2).substring(1, pgt.getToken(2).length()-1);
        email = pgt.getToken(3).substring(1, pgt.getToken(3).length()-1);
    }

    public String getValue() {
        return "('" + firstName + "','" + lastName + "','" + email + "','" + phoneNumber + "')";
    }

    public static void setOrder(List<Product> products)
    {
        int sum=0;
        System.out.println("Products list:");
        for(Product product: products)
        {
            if(product.getQuantity()>=1)
            {
                sum=sum+product.getPrice();
                System.out.println(product.toString());
            }

        }
        for(Product product: products)product.setQuantity(product.getQuantity()-1);
        System.out.println("Total cost: "+sum);

    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
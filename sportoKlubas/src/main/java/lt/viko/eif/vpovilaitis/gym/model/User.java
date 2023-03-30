package lt.viko.eif.vpovilaitis.gym.model;

import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

import javax.persistence.*;
import java.util.List;

@XmlRootElement
@XmlType(propOrder = {"id", "firstName", "lastName", "membership", "trainer"})
@Entity
@Table(name = "club_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;
    private String firstName;
    private String lastName;


    @OneToOne(targetEntity = Membership.class, cascade = CascadeType.ALL)
    private Membership membership;

    @OneToOne(targetEntity = Trainer.class, cascade = CascadeType.ALL)
    private Trainer trainer;


    public User(int id, String firstName, String lastName, Membership membership, Trainer trainer) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;

        this.membership = membership;
        this.trainer = trainer;
    }

    public User(String firstName, String lastName, Membership membership, Trainer trainer) {

        this.firstName = firstName;
        this.lastName = lastName;

        this.membership = membership;
        this.trainer = trainer;
    }

    public User() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Membership getMembership() {
        return membership;
    }

    public void setMembership(Membership membership) {
        this.membership = membership;
    }

    public Trainer getTrainer() {
        return trainer;
    }

    public void setTrainer(Trainer trainer) {
        this.trainer = trainer;
    }

    @Override
    public String toString() {
        return String.format("User:\n\tFirst name = %s\n\t" +
                        "Last name = %s\n" +
                        "Membership = \n\t%s\n" +
                        "Trainer = %s",
                this.firstName,
                this.lastName,
                this.membership,
                this.trainer
        );
    }


}


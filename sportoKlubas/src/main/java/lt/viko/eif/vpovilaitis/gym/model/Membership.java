package lt.viko.eif.vpovilaitis.gym.model;

import javax.persistence.*;

@Entity
@Table(name = "membership")
public class Membership {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;


    @OneToOne(targetEntity = Plan.class, cascade = CascadeType.ALL)
    private Plan plan;

    public Membership(int id, Plan plan) {
        this.id = id;
        this.plan = plan;
    }

    public Membership(Plan plan) {
        this.plan = plan;
    }
    public Membership(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public Plan getPlan() {
        return plan;
    }

    public void setPlan(Plan plan) {
        this.plan = plan;
    }


    @Override
    public String toString() {
        return String.format("Membership:" +
                "\n\tPlan = %s\t",
                this.plan);
    }

}

package lt.viko.eif.vpovilaitis.gym.model;

import javax.persistence.*;

@Entity
@Table(name = "equipment")
public class Equipment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;
    private String name;
    private String description;

    public Equipment(String name, String description) {
        this.name = name;
        this.description = description;
    }
    public Equipment(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return String.format("name: %s\n\t" +
                        "description: %s",
                this.name,
                this.description);
    }
}


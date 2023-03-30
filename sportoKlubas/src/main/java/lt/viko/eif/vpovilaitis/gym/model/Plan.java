package lt.viko.eif.vpovilaitis.gym.model;

import javax.persistence.*;

@Entity
@Table(name = "plan")
public class Plan {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    private String exercise;
    private String repetitions;
    private String sets;
    @OneToOne(targetEntity = Equipment.class, cascade = CascadeType.ALL)
    private Equipment equipment;

    public Plan(int id, String exercise, String repetitions, String sets, Equipment equipment) {
        this.id = id;
        this.exercise = exercise;
        this.repetitions = repetitions;
        this.sets = sets;
        this.equipment = equipment;
    }

    public Plan(String exercise, String repetitions, String sets, Equipment equipment) {
        this.exercise = exercise;
        this.repetitions = repetitions;
        this.sets = sets;
        this.equipment = equipment;
    }
     public Plan (){

     }

    public String getExercise() {
        return exercise;
    }

    public void setExercise(String exercise) {
        this.exercise = exercise;
    }

    public String getRepetitions() {
        return repetitions;
    }

    public void setRepetitions(String repetitions) {
        this.repetitions = repetitions;
    }

    public String getSets() {
        return sets;
    }

    public void setSets(String sets) {
        this.sets = sets;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Equipment getEquipment() {
        return equipment;
    }

    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }

    @Override
    public String toString() {
        return String.format("Plan:\n\t" +
                        "Exercise: %s\n\t" +
                        "Sets:%s\t" +
                        "repetitions: %s\n\t",

                this.exercise,
                this.sets,
                this.repetitions);
    }
}

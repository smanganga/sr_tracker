package ke.co.sr.server.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Block {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "refid")
    private String refID;
    @OneToMany(mappedBy = "block")
    private List<Project> projects;
    @OneToMany(mappedBy = "residingBlock")
    private List<Individual> residents;
    @OneToMany(mappedBy = "operatingBlock")
    private List<Individual> activeResidents;

}

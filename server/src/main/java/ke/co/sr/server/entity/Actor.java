package ke.co.sr.server.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name="actor")
public class Actor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String  name;
    @Column(name="actor_type")
    private ActorType actorType;
    @Column(name = "address", nullable = true)
    private String address;
    @Column(name = "phone_number", nullable = true)
    private String phoneNumber;
    @Column(name = "email")
    private String email;
    @ManyToMany(mappedBy = "implementors")
    private List<Project> implementedProjects;
    @ManyToMany(mappedBy = "proposers")
    private List<Project> proposedProjects;
}

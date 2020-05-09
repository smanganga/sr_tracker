package ke.co.sr.server.entity;
import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="project")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    @Column(name ="date_created")
    private Date date_created;
    @Column(name = "title")
    private String title;
    @Column(name = "refid")
    private String refID;
    @ManyToMany
    @JoinTable(name = "project_implementor",
        joinColumns = @JoinColumn(name = "project_id"),
        inverseJoinColumns = @JoinColumn(name = "implementor_id"))
    private List <Actor> implementors;
    @ManyToMany
    @JoinTable(name = "project_proposer",
        joinColumns = @JoinColumn(name = "project_id"),
        inverseJoinColumns = @JoinColumn(name = "proposer_id"))
    private List<Actor> proposers;

    @Column(name = "description")
    private String description;
    @Column(name = "location", nullable = true)
    private String location;
    @ManyToOne
    @JoinColumn(name = "block_id")
    private Block block;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
    @Column(name = "status")
    private Status status;

    public Project() {
    }

    public Project(String title, String description, String location) {
        this.title = title;
        this.description = description;
        this.location = location;
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", location='" + location + '\'' +
                '}';
    }
}

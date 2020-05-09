package ke.co.sr.server.dao;
import ke.co.sr.server.entity.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class ProjectDAO {
    private EntityManager entityManager;
    @Autowired
    public ProjectDAO(EntityManager entityManager){
        this.entityManager = entityManager;
    }
    public List<Project> findAll() {
        System.out.println("we do come to impl");
        //Session currentSession = entityManager.unwrap(Session.class);
        Query query = entityManager.createQuery("from Project", Project.class);
        List<Project> projects= query.getResultList();
        return projects;
    }
    public Project findById(int id) {
        //Session session = entityManager.unwrap(Session.class);
        Project project = entityManager.find(Project.class, id);
        return project;
    }
    public void save(Project project) {
        //Session session = entityManager.unwrap(Session.class);
        Project dbProject = entityManager.merge(project);
        project.setId(dbProject.getId());
    }
    public void deleteById(int id) {
        //Session session = entityManager.unwrap(Session.class);
        Query query = entityManager.createQuery("delete from Project where id=:projectId");
        query.setParameter("projectId", id);
        query.executeUpdate();
    }

}

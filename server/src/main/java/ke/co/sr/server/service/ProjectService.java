package ke.co.sr.server.service;
import ke.co.sr.server.dao.ProjectDAO;
import ke.co.sr.server.entity.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class ProjectService {
    private ProjectDAO projectDAO;
    @Autowired
    public ProjectService(ProjectDAO projectDAO) {
        this.projectDAO = projectDAO;
    }

    @Transactional
    public List<Project> findAll(){
        return projectDAO.findAll();
    }
    @Transactional
    public Project findById(int id){
        return projectDAO.findById(id);
    }
    @Transactional
    public void save(Project project){
        projectDAO.save(project);
    }
    @Transactional
    public void deleteById(int id){
        projectDAO.deleteById(id);
    }
    @Transactional
    public Project getProject(int id){
        return projectDAO.findById(id);
    }
}

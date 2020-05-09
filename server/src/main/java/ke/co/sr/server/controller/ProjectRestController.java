package ke.co.sr.server.controller;
import ke.co.sr.server.entity.Project;
import ke.co.sr.server.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class ProjectRestController {
    private ProjectService projectService;
    @Autowired
        public ProjectRestController(ProjectService service){
        projectService=service;
    }

    @GetMapping("/projects")
    public List<Project> findAll(){
        System.out.println("redirecting to DAO");
        return projectService.findAll();
    }
    @GetMapping("/projects/{projectId}")
    public Project getProject(@PathVariable int projectId){
        return projectService.getProject(projectId);
    }
    @PostMapping("/projects")
    public Project addProject(@RequestBody Project newProject){
        newProject.setId(0); //0 to force save not update
        projectService.save(newProject);
        return newProject;
    }
    @PutMapping("/projects")
    public Project updateProject(@RequestBody Project newProject){
        projectService.save(newProject);
        return newProject;
    }
    @DeleteMapping("/projects/{projectId}")
    public void deleteProject(@PathVariable int projectId){
        projectService.deleteById(projectId);

    }



}

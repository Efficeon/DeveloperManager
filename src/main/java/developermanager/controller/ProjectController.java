package developermanager.controller;

import developermanager.model.Developer;
import developermanager.model.Project;
import developermanager.service.DeveloperService;
import developermanager.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class ProjectController {

    public ProjectService projectService;
    public DeveloperService developerService;


    @Autowired(required = true)
    @Qualifier(value = "projectService")
    public void setProjectService(ProjectService projectService) {
        this.projectService = projectService;
    }

    @RequestMapping(value = "projects", method = RequestMethod.GET)
    public String listProjects(Model model){
        model.addAttribute("project", new Project());
        model.addAttribute("listProjects", this.projectService.listProjects());

        return "projects";
    }

    @RequestMapping(value = "/projects/add", method = RequestMethod.POST)
    public String addProject(@ModelAttribute("project") Project project){
        if(project.getId()==0){
            this.projectService.addProject(project);
        } else {
            this.projectService.updateProject(project);
        }

        return "redirect:/projects";
    }

    @RequestMapping("/remove/{id}")
    public String removeProject(@PathVariable("id") int id){
        this.projectService.removeProject(id);

        return "redirect:/projects";
    }

    @RequestMapping("edit/{id}")
    public String editProject(@PathVariable("id") int id, Model model){
        model.addAttribute("project", this.projectService.getProjectById(id));
        model.addAttribute("listProjects", this.projectService.listProjects());

        return "projects";
    }

    /*@RequestMapping("developeradd/{developerID}{projectID}")
    public String addDeveloper1(@PathVariable("developerID") int developerID,
                              @PathVariable("projectID") int projectID){
        this.projectService.addDeveloper(developerID, projectID);

        return "redirect:/projects";
    }*/

    @RequestMapping(value = "/projects/developeradd", method = RequestMethod.GET)
    public String addDeveloper(@RequestParam("developerID") int developerID,
                               @RequestParam("projectID") int projectID){
        this.projectService.addDeveloper(developerID, projectID);

       return "redirect:/projects";
    }

    @RequestMapping("projectdata/{id}")
    public String projectDate(@PathVariable("id") int id, Model model){
        model.addAttribute("project", this.projectService.getProjectById(id));

        return "projectdata";
    }
}

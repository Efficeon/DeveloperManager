package developermanager.controller;

import developermanager.model.Developer;
import developermanager.model.Project;
import developermanager.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class ProjectController {

    private ProjectService projectService;


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

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addDeveloper(@RequestParam("idDev") int idDev, @RequestParam("idProj") int idProj){
        this.projectService.addDeveloper(idDev, idProj);

       return "redirect:/projects";
    }

    @RequestMapping("projectdata/{id}")
    public String projectDate(@PathVariable("id") int id, Model model){
        model.addAttribute("project", this.projectService.getProjectById(id));

        return "projectdata";
    }
}

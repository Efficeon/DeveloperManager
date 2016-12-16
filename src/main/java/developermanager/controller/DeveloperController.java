package developermanager.controller;

import developermanager.model.Developer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import developermanager.service.DeveloperService;

@Controller
public class DeveloperController {

   private DeveloperService developerService;

   @Autowired(required = true)
   @Qualifier(value = "developerService")
   public void setDeveloperService(DeveloperService developerService) {
       this.developerService = developerService;
   }

   @RequestMapping(value = "developers", method = RequestMethod.GET)
   public String listDevelopers(Model model){
       model.addAttribute("developer", new Developer());
       model.addAttribute("listDevelopers", this.developerService.listDevelopers());

       return "developers";
   }

   @RequestMapping(value = "/developers/add", method = RequestMethod.POST)
   public String addDeveloper(@ModelAttribute("developer") Developer developer){
        if(developer.getId()==0){
            this.developerService.addDeveloper(developer);
        } else {
            this.developerService.updateDeveloper(developer);
        }

        return "redirect:/developers";
   }

   @RequestMapping("/removeDeveloper/{id}")
   public String removeDeveloper(@PathVariable("id") int id){
       this.developerService.removeDeveloper(id);
       return "redirect:/developers";
   }

   @RequestMapping("editDeveloper/{id}")
   public String editDeveloper(@PathVariable("id") int id, Model model){
       model.addAttribute("developer", this.developerService.getDeveloperById(id));
       model.addAttribute("listDevelopers", this.developerService.listDevelopers());

       return "developers";
   }

   @RequestMapping("developerdata/{id}")
   public String developerDate(@PathVariable("id") int id, Model model){
       model.addAttribute("developer", this.developerService.getDeveloperById(id));

       return "developerdata";
   }
}

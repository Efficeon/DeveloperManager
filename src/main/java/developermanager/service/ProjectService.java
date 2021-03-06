package developermanager.service;

import developermanager.model.Project;

import java.util.List;

public interface ProjectService {

    public void addProject(Project project);

    public void updateProject(Project project);

    public void addDeveloper(int developerID, int projectID);

    public void removeProject(int id);

    public Project getProjectById(int id);

    public List<Project> listProjects();
}

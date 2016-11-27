package developermanager.service;

import developermanager.dao.ProjectDao;
import developermanager.model.Project;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService{
    ProjectDao projectDao;

    public void setProjectDao(ProjectDao projectDao) {
        this.projectDao = projectDao;
    }

    @Override
    @Transactional
    public void addProject(Project project) {
        this.projectDao.addProject(project);
    }

    @Override
    @Transactional
    public void updateProject(Project project) {
        this.projectDao.updateProject(project);
    }

    @Override
    @Transactional
    public void addDeveloper(int developerID, int projectID) {
       this.projectDao.addDeveloper(developerID, projectID);
    }

    @Override
    @Transactional
    public void removeProject(int id) {
        this.projectDao.removeProject(id);
    }

    @Override
    @Transactional
    public Project getProjectById(int id) {
        return this.projectDao.getProjectById(id);
    }

    @Override
    @Transactional
    public List<Project> listProjects() {
        return this.projectDao.listProjects();
    }
}

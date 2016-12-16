package developermanager.dao;

import developermanager.model.Developer;
import developermanager.model.Project;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public class ProjectDaoImpl implements ProjectDao{
    private static final Logger logger = LoggerFactory.getLogger(DeveloperDaoImpl.class);
    private Set<Developer> developers = null;
    SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addProject(Project project) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(project);
        logger.info("Project successfully saved. Project details: " + project);
    }

    @Override
    public void updateProject(Project project) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(project);
        logger.info("Project successfully updated. Project details: " + project);
    }

    @Override
    public void addDeveloper(int developerID, int projectID) {
        Session session = this.sessionFactory.getCurrentSession();
        Project project = (Project) session.load(Project.class, projectID);
        developers = project.getDevelopers();

        DeveloperDaoImpl developerDao = new DeveloperDaoImpl();
        developers.add(developerDao.getDeveloperById(developerID));
        project.setDevelopers(developers);
        session.update(project);
    }

    //public void addDeveloper(int teamID, int developerID){
        //Session session = ConnectDao.sessionFactory.openSession();
        //Transaction transaction = session.beginTransaction();
        //Team team = (Team) session.get(Team.class, teamID);
        //developers = team.getDevelopers();
        //developerDao = new DeveloperDao();
        //developers.add(developerDao.readingDevelopers(developerID));
        //team.setDevelopers(developers);
        //session.update(team);
        //transaction.commit();
        //logger.info("Add developer: " + team.getName());
        //session.close();
    //}
    @Override
    public void removeProject(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Project project = (Project) session.load(Project.class, new Integer(id));

        if (project !=null){
            session.delete(project);
        }
        logger.info("Project successfully removed. Project details: " + project);
    }

    @Override
    public Project getProjectById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Project project = (Project) session.load(Project.class, new Integer(id));

        logger.info("Project successfully loaded. Project details: " + project);
        return project;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Project> listProjects() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Project> listProject = session.createQuery("FROM Project").list();

        for (Project project : listProject){
            logger.info("Project list: " + project);
        }
        return listProject;
    }


}

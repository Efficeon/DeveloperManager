package dao;

import model.Developer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class DeveloperDaoImpl implements DeveloperDao{
    private static final Logger logger = LoggerFactory.getLogger(DeveloperDaoImpl.class);

    SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addDeveloper(Developer developer) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(developer);
        logger.info("Developer successfully saved. Developer details: " + developer);
        session.close();
    }

    @Override
    public void updateDeveloper(Developer developer) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(developer);
        logger.info("Developer successfully updated. Developer details: " + developer);
        session.close();
    }

    @Override
    public void removeDeveloper(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Developer developer = (Developer) session.load(Developer.class, new Integer(id));

        if (developer !=null){
            session.delete(developer);
        }
        logger.info("Developer successfully removed. Developer details: " + developer);
        session.close();
    }

    @Override
    public Developer getDeveloperById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Developer developer = (Developer) session.load(Developer.class, new Integer(id));

        logger.info("Developer successfully loaded. Developer details: " + developer);
        session.close();
        return developer;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Developer> listDevelopers() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Developer> listDeveloper = session.createQuery("FROM Developer").list();

        for (Developer developer : listDeveloper){
            logger.info("Developer list: " + developer);
        }

        session.close();
        return listDeveloper;
    }
}

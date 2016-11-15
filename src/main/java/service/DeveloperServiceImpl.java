package service;

import dao.DeveloperDao;
import model.Developer;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DeveloperServiceImpl implements DeveloperService{
    DeveloperDao developerDao;

    public void setDeveloperDao(DeveloperDao developerDao) {
        this.developerDao = developerDao;
    }

    @Override
    @Transactional
    public void addDeveloper(Developer developer) {
        this.developerDao.addDeveloper(developer);
    }

    @Override
    @Transactional
    public void updateDeveloper(Developer developer) {
        this.developerDao.updateDeveloper(developer);
    }

    @Override
    @Transactional
    public void removeDeveloper(int id) {
        this.developerDao.removeDeveloper(id);
    }

    @Override
    @Transactional
    public Developer getDeveloperById(int id) {
        return this.developerDao.getDeveloperById(id);
    }

    @Override
    @Transactional
    public List<Developer> listDevelopers() {
        return this.developerDao.listDevelopers();
    }
}

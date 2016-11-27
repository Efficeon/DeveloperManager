package developermanager.dao;

import developermanager.model.Developer;

import java.util.List;

public interface DeveloperDao {

    public void addDeveloper(Developer developer);

    public void updateDeveloper(Developer developer);

    public void removeDeveloper(int id);

    public Developer getDeveloperById(int id);

    public List<Developer> listDevelopers();
}

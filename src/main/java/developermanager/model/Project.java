package developermanager.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "PROJECTS")
public class Project{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int projectID;

    @Column(name= "NAME")
    private String name;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "PROJECTS_DEVELOPERS", joinColumns = @JoinColumn(name = "projectID"),
            inverseJoinColumns = @JoinColumn(name = "developerID"))
    private Set<Developer> developersInProject;

    public int getId() {
        return projectID;
    }

    public void setId(int projectID) {
        this.projectID = projectID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Developer> getDevelopers() {
        return developersInProject;
    }

    public void setDevelopers(Set<Developer> developersInProject) {
        this.developersInProject = developersInProject;
    }

    @Override
    public String toString() {
         return  "-----------------------------------------------------------------------------------------------" + "\n" +
                "Название проекта: " + name + "; " + "\n" +
                "ID проекта: " + projectID + "\n";
    }
}

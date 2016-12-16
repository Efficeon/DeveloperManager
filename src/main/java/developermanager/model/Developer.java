package developermanager.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "DEVELOPERS")
public class Developer {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "SKILL")
    private String skill;

    @Column(name = "SALARY")
    private int salary;

    @Column(name = "EXPERIENCE")
    private int experience;

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "developersInProject")
    private Set<Project> projectsDeveloper;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public Set<Project> getProjects() {
        return projectsDeveloper;
    }

    public void setProjects(Set<Project> projectsDeveloper) {
        this.projectsDeveloper = projectsDeveloper;
    }

    @Override
    public String toString() {
        return "name" + " " + id +"\n";
    }
}

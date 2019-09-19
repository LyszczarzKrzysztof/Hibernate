package pl.sdaacademy.database.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
public class Run {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)     // automatyczne nadawanie id
    private Integer id;
    private String name;
    private Date startDate;

    @OneToMany(mappedBy = "run")
    private Set<RunMember> members;

    @Override
    public String toString(){
        return "Wyscig: id = "+id+" name: "+name+" startdate: "+startDate;
    }

    public Run(){

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Set<RunMember> getMembers() {
        return members;
    }

    public void setMembers(Set<RunMember> members) {
        this.members = members;
    }
}

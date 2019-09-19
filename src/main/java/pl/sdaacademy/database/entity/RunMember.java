package pl.sdaacademy.database.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
public class RunMember {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private Integer startNumber;

    @ManyToOne
    @JoinColumn(name="run_id")
    private Run run;

    @ManyToMany(mappedBy = "members")
    private Set<NfcChip> chips;

    public RunMember(){

    }

    @Override
    public String toString(){
        return "Uczestnik: id = "+id+" name: "+name+" startnumber: "+startNumber;
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

    public Integer getStartNumber() {
        return startNumber;
    }

    public void setStartNumber(Integer startNumber) {
        this.startNumber = startNumber;
    }


    public Run getRun() {
        return run;
    }

    public void setRun(Run run) {
        this.run = run;
    }

    public Set<NfcChip> getChips() {
        return chips;
    }

    public void setChips(Set<NfcChip> chips) {
        this.chips = chips;
    }
}

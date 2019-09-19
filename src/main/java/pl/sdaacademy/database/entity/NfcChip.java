package pl.sdaacademy.database.entity;

import org.hibernate.SessionFactory;

import javax.persistence.*;
import java.util.Set;

@Entity
public class NfcChip {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String serial;

    @ManyToMany
    @JoinTable(
            name = "chip_member",
            joinColumns = {@JoinColumn(name = "chip_id")},
            inverseJoinColumns = {@JoinColumn(name = "member_id")})
    private Set<RunMember> members;


    public NfcChip() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }
}

package pl.sdaacademy.database.dao;

import pl.sdaacademy.database.entity.Run;

import java.util.List;

public interface RunDao {

    void save(Run run);
    void delete(Integer id);
    Run findById(Integer id);
    List<Run> findAll();
    void dropTable();
    void dropTableIds();
}

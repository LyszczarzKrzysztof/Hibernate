package pl.sdaacademy.database.dao;

import pl.sdaacademy.database.entity.RunMember;

import java.util.List;

public interface RunMemberDao {
    void save(RunMember runMember);
    RunMember findById(Integer id);
    List<RunMember> findAll();
    void update(RunMember run);
    void delete(Integer id);
}

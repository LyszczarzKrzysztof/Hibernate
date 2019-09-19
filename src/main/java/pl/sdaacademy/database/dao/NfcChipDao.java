package pl.sdaacademy.database.dao;

import pl.sdaacademy.database.entity.NfcChip;
import pl.sdaacademy.database.entity.Run;

import java.util.List;

public interface NfcChipDao {

    void save(NfcChip nfcChip);
    void delete(Integer id);
    NfcChip findById(Integer id);
    List<NfcChip> findAll();
}

package pl.sdaacademy.database.main;

import org.hibernate.SessionFactory;
import pl.sdaacademy.database.dao.NfcChipDao;
import pl.sdaacademy.database.dao.RunDao;
import pl.sdaacademy.database.dao.RunMemberDao;
import pl.sdaacademy.database.daoimpl.NfcChipDaoImpl;
import pl.sdaacademy.database.daoimpl.RunDaoImpl;
import pl.sdaacademy.database.daoimpl.RunMemberDaoImpl;
import pl.sdaacademy.database.entity.NfcChip;
import pl.sdaacademy.database.entity.Run;
import pl.sdaacademy.database.entity.RunMember;
import pl.sdaacademy.database.utils.HibernateUtils;

import java.lang.reflect.Member;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {

//     RunDao runDao = new RunDaoImpl();
//     Run run = new Run();
//
//        runDao.dropTable();
//        //runDao.dropTableIds();
//
//     //run.setId(1);                  ---   jak sie da nad id generatedvalue auto to sam nadaje id
//     run.setName("Rat race");
//     run.setStartDate(new Date());
//
//     runDao.save(run);
//
//        //System.out.println(runDao.findById(20));
//
//        System.out.println(runDao.findAll());
//
//
//
//        System.out.println(runDao.findAll());
//
//
//        RunMemberDao runMemberDao = new RunMemberDaoImpl();
//
//        RunMember runMember = new RunMember();
//
//        runMember.setName("Szymon Szymon");
//        runMember.setStartNumber(1);
//
//
//        runMemberDao.save(runMember);
//
//        //----------------------------------------------
//
//        RunDao runDao1 = new RunDaoImpl();
//
//        RunMemberDao memberDao = new RunMemberDaoImpl();
//
//        RunMember member = new RunMember();
//        member.setName("Halina");
//        member.setStartNumber(120);
//
//        RunMember member1 = new RunMember();
//        member1.setName("Adam");
//        member1.setStartNumber(100);
//
//        memberDao.save(member);
//        memberDao.save(member1);
//
//        Run run1 = new Run();
//        run1.setName("Rzeszowska piątka");
//        runDao1.save(run1);
//
//        member.setRun(run1);
//        member1.setRun(run1);
//
//        memberDao.save(member);
//        memberDao.save(member1);
//
//        List<Run> runs = runDao1.findAll();
//        for(Run r: runs){
//        }

        //------------------------------------------------

        NfcChipDao nfcChipDao = new NfcChipDaoImpl();
        NfcChip nfcChip = new NfcChip();
        NfcChip nfcChip1 = new NfcChip();
        NfcChip nfcChip2 = new NfcChip();

        nfcChip.setSerial("00000");
        nfcChip1.setSerial("11111");
        nfcChip2.setSerial("22222");

        nfcChipDao.save(nfcChip);
        nfcChipDao.save(nfcChip1);
        nfcChipDao.save(nfcChip2);


        HibernateUtils.instance().getSessionFactory().close();
    }

    private static void chipTest() {
        ArrayList<NfcChip> chips = new ArrayList<NfcChip>();
        ArrayList<RunMember> members = new ArrayList<RunMember>();
        NfcChipDao chipDao = new NfcChipDaoImpl();
        RunMemberDao memberDao = new RunMemberDaoImpl();
        for(int i = 0; i < 5; i++) {
            NfcChip chip = new NfcChip();
            chip.setSerial("Serial" + i);
            chipDao.save(chip);
            chips.add(chip);
        }
        for(int i = 0; i < 10; i++) {
            RunMember member = new RunMember();
            member.setName("Serial" + i);
            memberDao.save(member);
            members.add(member);
        }
        for(NfcChip c : chips) {
            for(int i = 0; i < 3; i++) {
                int index = (int)(Math.random() * members.size());
                RunMember randomMember = members.get(index);
                c..add(randomMember);
                chipDao.save(c);
            }
        }
    }
}

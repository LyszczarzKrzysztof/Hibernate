package pl.sdaacademy.database.daoimpl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import pl.sdaacademy.database.dao.NfcChipDao;
import pl.sdaacademy.database.entity.NfcChip;
import pl.sdaacademy.database.entity.Run;
import pl.sdaacademy.database.entity.RunMember;
import pl.sdaacademy.database.utils.HibernateUtils;

import javax.persistence.NoResultException;
import java.util.List;

public class NfcChipDaoImpl implements NfcChipDao {
    public void save(NfcChip nfcChip) {
        SessionFactory factory = HibernateUtils.instance().getSessionFactory();
        Session session = factory.getCurrentSession();
        session.beginTransaction();

        session.saveOrUpdate(nfcChip);

        session.getTransaction().commit();
        session.close();
    }


    public void delete(Integer id) {
        SessionFactory factory = HibernateUtils.instance().getSessionFactory();
        Session session = factory.getCurrentSession();
        session.beginTransaction();

        session.createQuery("delete NfcChip where id=:id")
                .setParameter("id", id)
                .executeUpdate();

        session.getTransaction().commit();
        session.close();
    }

    public NfcChip findById(Integer id) {
        try {
            SessionFactory factory = HibernateUtils.instance().getSessionFactory();
            Session session = factory.getCurrentSession();
            session.beginTransaction();

            NfcChip nfcChip = (NfcChip) session.createQuery("from NfcChip where id=:id")
                    .setParameter("id", id).getSingleResult();

            session.getTransaction().commit();
            session.close();

            return nfcChip;
        } catch (NoResultException ex) {
            // tu nic nie ma ale sie na razie nie przejmujemy
        }
        return null;
    }

    public List<NfcChip> findAll() {
        SessionFactory factory = HibernateUtils.instance().getSessionFactory();
        Session session = factory.getCurrentSession();
        session.beginTransaction();

        List<NfcChip> list = session.createQuery("from RunMember").list();

        session.getTransaction().commit();
        session.close();

        return list;
    }
}

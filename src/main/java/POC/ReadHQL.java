package POC;

import entities.Student;
import org.hibernate.Session;
import utilities.HibernateUtil;

import java.util.List;

public class ReadHQL {
    public static void main(String[] args) {

        HibernateUtil hiberUtil = HibernateUtil.getInstance();
        Session session = hiberUtil.getSessionFactory().getCurrentSession();
        try {
            session.beginTransaction();
            List<Student> studList = session.createQuery("FROM Student s WHERE s.id>6 OR s.firstName='Anshul'").getResultList();
            for (Student stud : studList) {
                System.out.println(stud);
            }
            session.getTransaction().commit();
        }finally {
            session.close();
            HibernateUtil.getSessionFactory().close();
        }
    }
}

package POC;

import entities.Instructor;
import entities.InstructorDetail;
import org.hibernate.Session;
import utilities.HibernateUtil;

public class OneToOneBi {
    public static void main(String[] args) {
        HibernateUtil hiberUtil = HibernateUtil.getInstance();
        Session session = hiberUtil.getSessionFactory().getCurrentSession();
        try {
            session.beginTransaction();
            int theId = 2;
            InstructorDetail instDetObj = session.get(InstructorDetail.class, theId);
            System.out.println(instDetObj);
            System.out.println(instDetObj.getInstructor());
            session.getTransaction().commit();
        }finally {
            session.close();
            HibernateUtil.getSessionFactory().close();
        }
    }
}

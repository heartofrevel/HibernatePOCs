package POC;

import entities.InstructorDetail;
import org.hibernate.Session;
import utilities.HibernateUtil;

public class OneToOneBiDelete {
    public static void main(String[] args) {
        HibernateUtil hiberUtil = HibernateUtil.getInstance();
        Session session = hiberUtil.getSessionFactory().getCurrentSession();
        try {
            session.beginTransaction();
            int theId = 4;
            InstructorDetail instDetObj = session.get(InstructorDetail.class, theId);
            System.out.println(instDetObj);
            instDetObj.getInstructor().setInstructorDetail(null);
            session.delete(instDetObj);
            session.getTransaction().commit();
        }finally {
            session.close();
            HibernateUtil.getSessionFactory().close();
        }
    }
}

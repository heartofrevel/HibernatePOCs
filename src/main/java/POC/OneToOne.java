package POC;

import entities.Instructor;
import entities.InstructorDetail;
import org.hibernate.Session;
import utilities.HibernateUtil;

public class OneToOne {
    public static void main(String[] args) {
        HibernateUtil hiberUtil = HibernateUtil.getInstance();
        Session session = hiberUtil.getSessionFactory().getCurrentSession();
        try {
            Instructor instructorObj = new Instructor("Anshul", "Gupta", "anshul@root.com");
            InstructorDetail instructDetailsObj = new InstructorDetail("http://yuURL.com", "Coding");
            instructorObj.setInstructorDetail(instructDetailsObj);

            session.beginTransaction();
            session.save(instructorObj);
            session.getTransaction().commit();
            System.out.println(instructorObj);
            System.out.println(instructDetailsObj);
        }finally {
            session.close();
            HibernateUtil.getSessionFactory().close();
        }
    }
}

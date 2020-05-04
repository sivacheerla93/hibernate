import java.util.Date;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import entities.User;

public class AddUser {
	public static void main(String[] args) throws Exception {
		User u = new User();
		u.setUname("Siva");
		u.setEmail("test@gmail.com");
		u.setDj(new Date());
		u.setPwd("test");

		Configuration c = new Configuration().configure();
		SessionFactory sf = c.buildSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
		session.save(u);
		session.getTransaction().commit();
		session.close();

		sf.close();
	}
}
import java.util.List;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import entities.User;

public class ListUsers {
	public static void main(String[] args) {
		Configuration c = new Configuration().configure();
		SessionFactory sf = c.buildSessionFactory();
		Session session = sf.openSession();
		Query q = session.createQuery("from User");
		List l = q.list();
		for (Object o : l) {
			User u = (User) o;
			System.out.println(u.getUname() + ":" + u.getEmail());
		}
		session.close();
		sf.close();
	}
}
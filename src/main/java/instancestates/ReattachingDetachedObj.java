package instancestates;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ReattachingDetachedObj {

	public static void main(String[] args) throws Exception {
		Configuration c = new Configuration();
		c.configure("instancestates/hibernate.cfg.xml");

		SessionFactory sf = c.buildSessionFactory();

		Session session = sf.openSession();

		// Querying object results in SELECT
		Publisher p = (Publisher) session.get(Publisher.class, 3);
		// p is persistent

		session.close();

		// p becomes detached
		p.setName("Sherlock Publisher"); // modify detached object
		session = sf.openSession(); // create a new session
		session.beginTransaction();
		session.update(p);// p is shifted to persistent state from detached
		session.getTransaction().commit(); // results in UPDATE
		session.close();

		sf.close();
	}
}

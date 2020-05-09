package instancestates;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class RemovingObject {

	public static void main(String[] args) throws Exception {
		Configuration c = new Configuration();
		c.configure("instancestates/hibernate.cfg.xml");

		SessionFactory sf = c.buildSessionFactory();

		Session session = sf.openSession();
		session.beginTransaction();
		/*
		 * You can delete even a transient instance because delete() implicitly
		 * makes it persistent before deleting it
		 */

		Publisher p = (Publisher) session.get(Publisher.class, 3);
		if (p != null)
			session.delete(p);
		else
			System.out.println("Publisher not found!");

		session.getTransaction().commit();
		session.close();

		sf.close();
	}
}

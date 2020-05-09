package instancestates;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class TransientPersistentState {

	public static void main(String[] args) throws Exception {
		Configuration c = new Configuration();
		c.configure("instancestates/hibernate.cfg.xml");

		Publisher p = new Publisher(); // Object p is Transient
		p.setName("Manning");
		p.setEmail("info@manning.com");
		p.setAddress("Ny, USA");

		SessionFactory sf = c.buildSessionFactory();
		Session s = sf.openSession();

		s.beginTransaction();
		s.save(p); // Object p becomes Persistent
		s.getTransaction().commit(); // SQL INSERT
		s.beginTransaction();
		p.setName("Manning publisher"); // modify object
		s.getTransaction().commit(); // SQL UPDATE
		s.close();
		// object p becomes Detached as session is closed
		sf.close();
	}
}

package onetoone;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ListMemberships {
	public static void main(String[] args) throws Exception {
		Configuration c = new Configuration();
		c.configure("onetoone/hibernate.cfg.xml");

		SessionFactory sf = c.buildSessionFactory();
		Session s = sf.openSession();

		List<Membership> list = s.createQuery("from Membership").list();

		for (Membership m : list) {
			System.out.printf("%-5s %-5s %-10s\n", m.getId(), m.getType(), m.getEmployee().getName());
		}
		s.close();
		sf.close();
	}
}
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import entities.Employee;
import entities.Job;

public class DeleteEmployee {

	public static void main(String[] args) throws Exception {
		Configuration c = new Configuration();
		c.configure(); // load hibernate.cfg.xml

		SessionFactory sf = c.buildSessionFactory();
		Session s = sf.openSession();
		Employee emp = s.get(Employee.class, 207);

		if (emp == null)
			System.out.println("Sorry! Employee id not found!");
		else {
			Transaction trans = s.beginTransaction();
			s.remove(emp);
			trans.commit();
			System.out.println("Deleted!");
		}

		s.close();
		sf.close();
	}
}
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import entities.Employee;

public class ListEmployees {

	public static void main(String[] args) throws Exception {
		Configuration c = new Configuration();
		c.configure(); // load hibernate.cfg.xml

		SessionFactory sf = c.buildSessionFactory();
		Session s = sf.openSession();

		List<Employee> employees = s.createQuery("from Employee").list();

		for (Employee e : employees) {
			System.out.printf("%-10d - %-15s - %-10d - %s\n", e.getId(), e.getName(), e.getSalary(), e.getJob_id());
		}
		s.close();
		sf.close();
	}
}
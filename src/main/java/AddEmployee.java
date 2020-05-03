import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import entities.Employee;

public class AddEmployee {

	public static void main(String[] args) throws Exception {
		Configuration c = new Configuration();
		c.configure(); // load hibernate.cfg.xml

		SessionFactory sf = c.buildSessionFactory();
		Session s = sf.openSession();

		Employee emp = new Employee();
		emp.setId(207);
		emp.setFirstName("Siva");
		emp.setLastName("Cheerla");
		emp.setEmail("sivacheerla@live.com");
		emp.setSalary(10000);
		emp.setJob_id("AD_PRES");
		emp.setHireDate(new java.sql.Date(new java.util.Date().getTime()));

		Transaction trans = s.beginTransaction();
		s.save(emp); // Insert into JOBS table
		System.out.println("Inserted!");
		trans.commit();
		System.out.println("Committed!");
		s.close();
		sf.close();
	}
}
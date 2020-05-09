import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class BulkUpdateJobMinSalary {

	public static void main(String[] args) throws Exception {
		Configuration c = new Configuration();
		c.configure(); // load hibernate.cfg.xml

		SessionFactory sf = c.buildSessionFactory();
		Session s = sf.openSession();

		Transaction t = s.beginTransaction();
		Query q = s.createQuery("update Job set minSal = minSal + minSal * 0.1 where minSal < 5000");

		int cnt = q.executeUpdate();
		System.out.println("No. of rows updated : " + cnt);
		t.commit();

		s.close();
		sf.close();
	}
}
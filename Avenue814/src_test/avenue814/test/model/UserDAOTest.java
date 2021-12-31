package avenue814.test.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.dbunit.IDatabaseTester;
import org.dbunit.JdbcDatabaseTester;
import org.dbunit.dataset.DataSetException;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.operation.DatabaseOperation;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import avenue814.model.UserDAO;

public class UserDAOTest {
	private static IDatabaseTester tester;
	private UserDAO userDAO;
	
	@BeforeAll
	static void setUpAll() throws ClassNotFoundException {
		tester = new JdbcDatabaseTester(org.h2.Driver.class.getName(), 
				"jdbc:h2:men:test;DB_CLOSE_DELAY=-1;init=runscript from 'classpath:DB_test/schema.sql'",
				"sa", 
				""
			);
		
		tester.setSetUpOperation(DatabaseOperation.REFRESH);
		tester.setTearDownOperation(DatabaseOperation.DELETE_ALL);
	}
	
	private static void refreshDataSet(String filename) throws Exception {
		IDataSet initialState = new FlatXmlDataSetBuilder().build(UserDAOTest.class.getClassLoader().getResourceAsStream(filename));
		tester.setDataSet(initialState);
		tester.onSetup();
	}
	
	@BeforeEach
	public void setUp() throws Exception{
		refreshDataSet("DB_test/init/init.xml");
		userDAO = new UserDAO(tester.getConnection().getConnection());
	}
	
	@AfterEach
	public void tearDown() throws Exception {
		tester.onTearDown();
	}
	
	@Test
	public void TestGetLogin() {
		assertEquals(1,1);
	}
	
	
	
}

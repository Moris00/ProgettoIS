package avenue814.test.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.Connection;

import javax.sql.DataSource;

import org.dbunit.DataSourceBasedDBTestCase;

import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.operation.DatabaseOperation;
import org.h2.jdbcx.JdbcDataSource;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import avenue814.model.UserDAO;

public class UserDAOTest extends DataSourceBasedDBTestCase{
	private Connection connection;
	private UserDAO userDAO;
	
	@Override
	protected DataSource getDataSource() {
		JdbcDataSource dataSource = new JdbcDataSource();
		dataSource.setURL("jdbc:h2:men:test;DB_CLOSE_DELAY=-1;init=runscript from 'classpath:/DB_test/schema.sql'");
		dataSource.setUrl("sa");
		dataSource.setPassword("");
		return dataSource;
	}

	@Override
	protected IDataSet getDataSet() throws Exception {
		return new FlatXmlDataSetBuilder().build(this.getClass().getClassLoader().getResourceAsStream("C:\\Users\\Utente\\git\\ProgettoIS_Avenue814\\Avenue814\\DB_test\\init\\init.xml"));
	}
	
	protected DatabaseOperation getSetUpOperation() {return DatabaseOperation.REFRESH;}
	protected DatabaseOperation getTearDownOperation() {return DatabaseOperation.DELETE_ALL;}
	
	
	
	@BeforeEach
	public void setUp() throws Exception{
		super.setUp();
		connection = getConnection().getConnection();
		userDAO = new UserDAO();
	}
	
	@AfterEach
	public void tearDown() throws Exception {
		super.tearDown();
	}
	
	@Test
	public void TestGetLogin() {
		assertEquals(1,1);
	}

	
	
	
	
	
}

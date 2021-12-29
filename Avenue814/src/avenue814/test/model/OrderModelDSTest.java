package avenue814.test.model;

import java.sql.SQLException;

import org.dbunit.Assertion;
import org.dbunit.DatabaseUnitException;
import org.dbunit.IDatabaseTester;
import org.dbunit.JdbcDatabaseTester;
import org.dbunit.dataset.DataSetException;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.ITable;
import org.dbunit.dataset.SortedTable;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.operation.DatabaseOperation;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import avenue814.model.OrderBean;
import avenue814.model.OrderModelDS;

public class OrderModelDSTest {
	private static IDatabaseTester t;
	private OrderModelDS dao;
	
	@BeforeAll
	static void setUpAll() throws ClassNotFoundException{
		t = new JdbcDatabaseTester(org.h2.Driver.class.getName(), "jdbc:h2:men:test;DB_CLOSE_DELAY=-1;init=runscript frp, 'classpath:WebContent/DB/Avenue814DB.sql'","sa","");
		t.setSetUpOperation(DatabaseOperation.REFRESH);
		t.setTearDownOperation(DatabaseOperation.DELETE_ALL);
	}
	
	@BeforeEach
	public void setUp() throws Exception {
		refreshDataSet("WebContent/DB/init.xml");
		dao = new OrderModelDS(t.getConnection().getConnection());
	}
	
	@AfterEach
	public void tearDown() throws Exception {
		t.onTearDown();
	}
	
	private static void refreshDataSet(String filename) throws Exception {
		IDataSet initialState = new FlatXmlDataSetBuilder().build(OrderModelDSTest.class.getClassLoader().getResourceAsStream(filename));
		t.setDataSet(initialState);
		t.onSetup();
	}
	
	@Test
	public void TestaddOrderDS() throws SQLException, Exception {
		ITable expected = new FlatXmlDataSetBuilder().build(OrderModelDSTest.class.getClassLoader().getResourceAsStream("WebContent/DB/testAddOrder.xml")).getTable("Ordini");
		
		ITable actual = t.getConnection().createDataSet().getTable("Ordini");
		
		Assertion.assertEquals(new SortedTable(expected), new SortedTable(actual));
		
	}
	
}

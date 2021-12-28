package avenue814.test.model;

import org.dbunit.IDatabaseTester;
import org.dbunit.JdbcDatabaseTester;
import org.dbunit.dataset.DataSetException;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.operation.DatabaseOperation;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

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
	public void setUp() throws DataSetException {
		refreshDataSet("WebContent/DB/init.xml");
		dao = new OrderModelDS();
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
	
}

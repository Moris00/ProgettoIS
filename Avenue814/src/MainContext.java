

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.sql.DataSource;

@WebListener
public class MainContext implements ServletContextListener {	
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		
		ServletContext context = sce.getServletContext(); //Serve per salvare il nostro database
		
		DataSource ds = null;
		try {
			Context initCtx = new InitialContext();
			Context envCtx = (Context) initCtx.lookup("java:comp/env");
			
			ds = (DataSource) envCtx.lookup("jdbc/database");
				try {
					Connection con = null;
					try {
						con = ds.getConnection();
				
						DatabaseMetaData metaData = con.getMetaData();
						System.out.println("DBMS name: "+ metaData.getDatabaseProductName());
						System.out.println("DMS name: "+ metaData.getDatabaseProductVersion());
				
					}finally {
						if(con != null) con.close();
					}
			
				}catch(SQLException e) {
				}
			}catch(NamingException e) {
			}
		
		context.setAttribute("DataSource", ds); //Database visto da tutte le servlet
	}
	
	
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		ServletContext context = sce.getServletContext();
		context.removeAttribute("DataSource");
	}
}

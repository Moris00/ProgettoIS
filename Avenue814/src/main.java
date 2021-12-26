
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import avenue814.control.database.*;

public class main {

	public static void main(String[] args) {
		String timeStamp = new SimpleDateFormat("yyyy/MM/dd HH:mm").format(Calendar.getInstance().getTime());
		System.out.println(timeStamp);
	}

}

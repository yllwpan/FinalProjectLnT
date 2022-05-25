import java.sql.SQLException;
import config.connect;

public class Main {
	public connect con;
			
	public static void main(String[] args) {
		new Main();
	}
	
	public Main() {
//		con = new connect();
//		con.getAllData();
//		try {
//			while(con.rs.next()) {
//				System.out.println(con.rs.getString(1));
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
		new home();
		
	}
	

}

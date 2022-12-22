package testmvc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class RoomDAO {
	private Connection con;

	public RoomDAO(){
		String dbUrl = "jdbc:mysql://localhost:3306/test";  
		String dbClass = "com.mysql.jdbc.Driver";

		try {
			Class.forName(dbClass);
			con = DriverManager.getConnection (dbUrl,  "root", "");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void addRoom(Room room){
		String sql = "INSERT INTO tblRoom(id, name, type, displayPrice,  description)";
		try{
			PreparedStatement ps = con.prepareStatement(sql); 
			ps.setString(1, room.getId());
			ps.setString(2, room.getName());
			ps.setString(3, room.getType());  
			ps.setFloat(4, room.getDisplayPrice());  
			ps.setString(5, room.getDescription());
			ps.executeUpdate();
		}catch(Exception e){  
			e.printStackTrace();
		}
	}
}


import java.sql.*;
import java.util.*;

public class StudDao {
	static Connection con;
	public static Connection getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/profound","root","Adipri@23");
					} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}
	public static int save(Stud s) {
		int status = 0;
		try {
			con = StudDao.getConnection();
			PreparedStatement pst = con.prepareStatement("insert into stud value(?,?,?,?)");
			pst.setInt(1, s.getRollno());	
			pst.setString(2,s.getName());
			pst.setInt(3, s.getMarks());
			pst.setString(4, s.getCity());
			status = pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
		
	}
	public static List <Stud> showStud(){
		List <Stud> list = new ArrayList<Stud>();
		try {
			con = StudDao.getConnection();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from stud");
			while(rs.next()) {
				Stud s= new Stud();
				s.setRollno(rs.getInt(1));
				s.setName(rs.getString(2));
				s.setMarks(rs.getInt(3));
				s.setCity(rs.getString(4));
				list.add(s);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list;
	}
	public static int update (Stud s) {
		int status=0;
		try {
			con = StudDao.getConnection();
			PreparedStatement pst = con.prepareStatement("UPDATE stud SET Name=?, Marks=?, City=? WHERE RollNo=?");
			pst.setString(1,s.getName());
			pst.setInt(2, s.getMarks());
			pst.setString(3, s.getCity());
			pst.setInt(4,s.getRollno());;
			status = pst.executeUpdate();
			con.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
		}
	public static int delete(int rn) {
		try {
			con = StudDao.getConnection();
			PreparedStatement pst = con.prepareStatement("delete from stud where Rollno=?");
			pst.setInt(1, rn);
			pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rn;
	}
}

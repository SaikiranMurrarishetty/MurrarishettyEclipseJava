
import java.sql.*;
public class ForiegnKeyCreateTable {

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		try
		{
	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/feed"
							+ "back?useSSL=false&serverTimezone=UTC", "root", "root");
	Statement st = con.createStatement();
	
	st.executeUpdate("Create Table EmployeeDetails(Emp_Id int NOT NULL,FOREIGN KEY (Emp_Id) REFERENCES"
			+ " employee(Emp_Id),Employee_Details_Id int,PRIMARY KEY (Employee_Details_Id),Employee_Salary "
			+ "int NOT NULL,Employee_Position varchar(255))");
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
	
	}

}

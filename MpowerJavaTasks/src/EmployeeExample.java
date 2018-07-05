import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
public class EmployeeExample {

	ArrayList<EmployeeDetails> EmpAl = new ArrayList<EmployeeDetails>();
	Connection con = null;
   
    
	public static void main(String[] args) throws IOException
	{
	// TODO Auto-generated method stub
	
	System.out.println("Please Choose One Option:\n"
					  + "1.DisplayEmployeeData\n"
					  + "2.InsertEmployeeData");
	
	Scanner sc			 = new Scanner(System.in);
	EmployeeExample e 	 = new EmployeeExample();
	int choice			 = sc.nextInt();
	
	if(choice == 1)
		e.getEmployeeData();
	else if(choice == 2)
		e.insertEmloyeeData();
}
	
	
	void insertEmloyeeData() throws IOException
	{
			int Eid = 0,res = 0,count = 0;
			String Ename = null,Ephn = null,Eadd = null;

			
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("How Many records you want to insert?");
			int noOfRecords = Integer.parseInt(br.readLine());
			System.out.println("Enter Employee Data");
		   
		    for(int i = 0;i<noOfRecords;i++)
		    {
		    	System.out.println("Enter Employee ID:");
		    	Eid 		= Integer.parseInt(br.readLine());
		    	System.out.println("Enter Employee Name:");
		    	Ename 		= br.readLine();
		    	System.out.println("Enter Employee Phone Number:");
		    	Ephn 		= br.readLine();
		    	System.out.println("Enter Employee Address:");   
		    	Eadd		= br.readLine();	
		    	
			    EmployeeDetails Ed = new EmployeeDetails(Eid, Ename, Ephn, Eadd);
			    EmpAl.add(Ed);
		    }
		    
		    //Connecting to the database
		    try
		    {
		    	
		    	con       			 = DriverManager.getConnection("jdbc:mysql://localhost:3306/feedback?useSSL=false&serverTimezone=UTC", "root", "root");
		    	PreparedStatement ps = con.prepareStatement("Insert Into Employee Values(?,?,?,?)");
		    	Iterator<EmployeeDetails> itr = EmpAl.iterator();
		    	
		    	while(itr.hasNext())
		    	{
		    	EmployeeDetails ed = itr.next();
		    	ps.setInt(1, ed.EmployeeId);
		    	ps.setString(2, ed.EmployeeName);
		    	ps.setString(3, ed.EmployeePhoneNo);
		    	ps.setString(4, ed.EmployeeAddress);
		    	
		    	res = ps.executeUpdate();
		    	count = count + res;  
		    	}
		    	System.out.println("Total "+res+" Records Inserted\n"); 
		    	
		    }
		    catch(Exception e)
		    {
		    	e.printStackTrace();
		    }
	}
	
	void getEmployeeData()
	{
		
		try
		{
		
    	con       			 = DriverManager.getConnection("jdbc:mysql://localhost:3306/feedback?useSSL=false&serverTimezone=UTC", "root", "root");
    	Statement st		 = con.createStatement();
    	ResultSet r			 = st.executeQuery("Select * from Employee");
    	System.out.println("---------------------------------");
    		while(r.next())
    		{
    		System.out.println("Employe Id:"+r.getInt(1)+
    						   "\nEmployee Name:"+r.getString(2)+
    						   "\nEmployee Phone:"+r.getString(3)+
    						   "\nEmployee Address:"+r.getString(4));
    		System.out.println("---------------------------------");
	
    		}
		}
	
		catch(Exception e)
		{
			e.printStackTrace();
		}
	
	}

}

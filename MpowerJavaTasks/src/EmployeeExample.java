import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;


class EmployeeInformation
{
	ArrayList<EmployeeDetails> EmpAl = new ArrayList<EmployeeDetails>();
	Connection con = null;

	//Singleton Approach---Only Single Java Object Possible for this class
	public static EmployeeInformation SingleInstanceofClass = null;
	public static EmployeeInformation getInstance()
	{
		if(SingleInstanceofClass == null)
			SingleInstanceofClass = new EmployeeInformation();
		
		return SingleInstanceofClass;
	}
    private EmployeeInformation()
    {
    System.out.println("Private Constructor for Singleton class");	
    }
    //
    
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
		    	
		    	if(con == null)
		    	con = OpenConnection();
		    	
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
		
		if(con == null)
		con = OpenConnection();
    	try
    	{
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
	
	
	void getEmployeeData(int eid)
	{
		
		if(con == null)
		con = OpenConnection();
    	try
    	{
		Statement st		 = con.createStatement();
    	ResultSet r			 = st.executeQuery("Select * from Employee where emp_id ="+eid);
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
	Connection OpenConnection()
	{
		try 
		{
			con       			 = DriverManager.getConnection("jdbc:mysql://localhost:3306/feedback?useSSL=false&serverTimezone=UTC", "root", "root");
	    		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return con;
		
	}

}






public class EmployeeExample 
{
    
	public static void main(String[] args) throws IOException
	{
	// TODO Auto-generated method stub
	
	System.out.println("Please Choose One Option:\n"
					  + "1.DisplayEmployeeData\n"
					  + "2.InsertEmployeeData");
	
	Scanner sc			 = new Scanner(System.in);
	EmployeeInformation e 	 = EmployeeInformation.getInstance();
	int choice			 = sc.nextInt();
	int eid = 0;
	
	if(choice == 1)
	{
		System.out.println("Please Choose One Option:\n"
				  + "1.Fetch Single Record\n"
				  + "2.Fetch All Records");
		choice			 = sc.nextInt();
		if(choice == 1)
		{
			System.out.println("Enter Employee ID: ");
			eid			 = sc.nextInt();
			e.getEmployeeData(eid);	
		}
		else
		{
			e.getEmployeeData();
	
		}
	}
	else if(choice == 2)
	{
		e.insertEmloyeeData();
	}
   }
	
}

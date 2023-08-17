package MYSQL.mycasestudy;
import java.sql.*;

public class myproj {
	public static final String URL="jdbc:mysql://localhost:3306/test";
	public static final String USERNAME="root";
	public static final String PASSWORD="Jan@16042001";
	Connection con;
	Statement stat;
	public void dbConnect()
	{
		try {
			con=DriverManager.getConnection(URL,USERNAME,PASSWORD);
			System.out.println("Connection established");
			System.out.println(con.getMetaData().getDatabaseProductName());
			System.out.println(con.getClientInfo());
		}
		
		
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	public void executeStatements()
	{  
		String query="create table MyCallQuality(callid int,phoneno varchar(20),callfeedback varchar(20),callrating int,customername varchar(20),calldrop varchar(20))";
		
	
		try {
			stat =con.createStatement();
			boolean result=stat.execute(query);
			if(result)
			{
				System.out.println("table not created");
			}
			else
			{
				System.out.println("table created");
				
			}
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}

}
	public void insertRecords()
	{
		String insertCommand ="insert into MyCallQuality values(2,'98562314','frequentcalldrop',2,'Erric Jones','35%')";
		
		try
		{
			int recordsaffected=stat.executeUpdate(insertCommand);
			System.out.println("record inserted "+recordsaffected);
			
			}
		
		catch(Exception e)
		{
			System.out.println(e);
		}
		
	}
	
	public void getRecords()
	{
		String query="select * from MyCallQuality";
		try
		{
			ResultSet result=stat.executeQuery(query);
			while(result.next()) {
				int call_id=result.getInt(1);
				String phoneno=result.getString(2);
				String callfeedback=result.getString(3);
				int callrating=result.getInt(4);
				String customername=result.getString(5);
				String calldroprate=result.getString(6);
				
				System.out.println("callid"+call_id);
				System.out.println("phoneno"+phoneno);
				System.out.println("callfeedback"+callfeedback);
				System.out.println("callrating"+callrating);
				System.out.println("customername"+customername);
				System.out.println("calldroprate"+calldroprate);
			}
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}

}
	
	public void insertcallData(int callid,String phoneno,String callfeedback,int callrating,String customername,String calldrop )
	{
		String querry="insert into MyCallQuality values (?,?,?,?,?,?)";
		
		
		try {
			
			PreparedStatement stat= con.prepareStatement(querry);
			stat.setInt(1, callid);
			stat.setString(2,phoneno);
			stat.setString(3,callfeedback);
			stat.setInt(4,callrating);
			stat.setString(5,customername);
			stat.setString(6, calldrop);
			int records_inserted=stat.executeUpdate();
			System.out.println(records_inserted+"records inserted");
			
			
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	
	public void showrecords(String callfeedback)
	{
		String query="select * from MyCallQuality where callfeedback>?";
		try
		{
			PreparedStatement stat=con.prepareStatement(query);
			stat.setString(1,callfeedback);
			ResultSet result=stat.executeQuery();
			while(result.next()) {
				int call_id=result.getInt(1);
				String phoneno=result.getString(2);
				String callfeedback1=result.getString(3);
				int callrating=result.getInt(4);
				String customername=result.getString(5);
				String calldroprate=result.getString(6);
				
				System.out.println("callid"+call_id);
				System.out.println("phoneno"+phoneno);
				System.out.println("callfeedback"+callfeedback1);
				System.out.println("callrating"+callrating);
				System.out.println("customername"+customername);
				System.out.println("calldroprate"+calldroprate);
			}
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
			
		}
	public void showrecords1(String droprate)
	{
		String query="select * from MyCallQuality where droprate>?";
		try
		{
			PreparedStatement stat=con.prepareStatement(query);
			stat.setString(1,droprate);
			ResultSet result=stat.executeQuery();
			while(result.next()) {
				int call_id=result.getInt(1);
				String phoneno=result.getString(2);
				String callfeedback1=result.getString(3);
				int callrating=result.getInt(4);
				String customername=result.getString(5);
				String calldroprate=result.getString(6);
				
				System.out.println("callid"+call_id);
				System.out.println("phoneno"+phoneno);
				System.out.println("callfeedback"+callfeedback1);
				System.out.println("callrating"+callrating);
				System.out.println("customername"+customername);
				System.out.println("calldroprate"+calldroprate);
			}
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
			
		}
	
	public void insertcallData1(String calldrop,int callid)
	{
		String querry="UPDATE MyCallQuality SET calldrop= ? WHERE callid=?";
		
		
		try {
			
			PreparedStatement stat= con.prepareStatement(querry);
			stat.setString(1,calldrop);
			stat.setInt(2, callid);
			
			int records_inserted=stat.executeUpdate();
			System.out.println(records_inserted+"records inserted");
			
			
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	
	}


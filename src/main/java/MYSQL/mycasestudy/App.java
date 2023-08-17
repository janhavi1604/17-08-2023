package MYSQL.mycasestudy;



/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	 myproj obj=new myproj();
         obj.dbConnect();
         obj.executeStatements();
         obj.insertRecords();
        // obj.getRecords();
         obj.insertcallData(3,"986532135","Good",5,"Jones","33%");
         //obj.showrecords("4");
         obj.showrecords("30");
         obj.insertcallData1("20%",2);
         obj.getRecords();
    }
}

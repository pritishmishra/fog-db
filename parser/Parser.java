package parser;
import java.util.Scanner;
import actions.*;



public class Parser {

	public void main(String args[])
			{
		System.out.println("Enter your command");
        Scanner sc=new Scanner(System.in);
		String cmd = sc.nextLine();
			}
    
	

	 public String parserString(String cmd) {
		 String jsonServer = null;
		// add a semicolon at last process begins
		cmd=cmd.trim();
		
		// add a semicolon at last process ends
		String cmdArr[]=cmd.split(" ");
		cmdArr[0]=cmdArr[0].toUpperCase();
		
	
		
//		Boolean cmdSuccess=false;
		switch (cmdArr[0]) {
		case "CREATE":
			//creation and call to respective class object
			break;
		case "UPDATE":
			//update master set Name = x where Name = A
			UpdateTable updateObj=new UpdateTable();
			jsonServer=updateObj.updateTable(cmdArr);
//			updateObj.convertGson();
			break;
		case "DELETE":
			//creation and call to respective class object
			DeleteTable deleteObj= new DeleteTable();
			jsonServer=deleteObj.deleteTable(cmdArr);
			break;
		case "INSERT":
			//creation and call to respective class object
			InsertTable insertObj=new InsertTable();
			 jsonServer=insertObj.check_insert(cmd);
			break;
		case "SELECT":
			SelectTable selectObj=new SelectTable();
			jsonServer=selectObj.selectTable(cmd);
		case "ALTER":
			break;

		default:
			return "Not A valid Command";
			
		}
		
		return jsonServer;
		
	}

}

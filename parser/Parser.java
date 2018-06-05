package parser;

import java.util.Scanner;

import actions.*;


public class Parser {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter your command");
		String cmd=in.nextLine();
		parserString(cmd);
		

	}

	private static void parserString(String cmd) {
		// add a semicolon at last process begins
		cmd=cmd.trim();
		if(cmd.charAt(cmd.length()-1)!=';') {
			cmd+=" ;";
		}
		// add a semicolon at last process ends
		String cmdArr[]=cmd.split(" ");
		cmdArr[0]=cmdArr[0].toUpperCase();
		System.out.println(cmdArr[0]);
	
		
		Boolean cmdSuccess=false;
		switch (cmdArr[0]) {
		case "CREATE":
			//creation and call to respective class object
			break;
		case "UPDATE":
			//update master set Name = x where Name = A
			UpdateTable updateObj=new UpdateTable();
			cmdSuccess=updateObj.updateTable(cmdArr);
			updateObj.convertGson();
			break;
		case "DELETE":
			//creation and call to respective class object
			break;
		case "INSERT":
			//creation and call to respective class object
			break;
		case "ALTER":
			break;

		default:
			System.out.println("Not A valid Command");
			break;
		}
		if(cmdSuccess) {
			System.out.println(cmd+" SUCCESSFULL");
		}else {
			System.out.println(cmd+" NOT SUCCESSFULL");
		}
		
	}

}
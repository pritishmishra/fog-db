package dataTypes;

import java.util.Scanner;

public class MainParser {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter your command");
		String str=in.nextLine();
		parserString(str);
		

	}

	private static void parserString(String str) {
		String s[]=str.split(" ");
		s[0]=s[0].toUpperCase();
		System.out.println(s[0]);
		switch (s[0]) {
		case "CREATE":
			//creation and call to respective class object
			break;
		case "UPDATE":
			//creation and call to respective class object
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
		
	}

}

package application;

import java.util.Scanner;

public class Input {
	
	private static Scanner scanner ;
	
	public Input() {
	
	}
	
	public String getInput(String message) {
		System.out.println(message);
		String input =  scanner.nextLine();
		return input;
	}

}

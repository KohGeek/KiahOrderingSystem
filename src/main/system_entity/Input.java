package system_entity;

import java.util.Scanner;

public class Input {

	Scanner scanner = new Scanner(System.in);

	public String getInput(String message) {
		System.out.println(message);
		String input = scanner.nextLine();
		return input;
	}

	public Input() {
	};

}

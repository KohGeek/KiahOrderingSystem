package application;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class FileHandler {
	
	private static String[] processLine (String nextLine, int numberOfData) throws InputMismatchException {
		String[] s = nextLine.split(",", -1);
		
		if (s.length == 0) {
			throw new InputMismatchException("No data!");
		} else if (s.length != numberOfData) {
			throw new InputMismatchException("Data mismatch!");
		}
		
		return s;
	}
	
	public static ArrayList<Item> initializeItem (String filepath) throws FileNotFoundException, EOFException{
		ArrayList<Item> item = new ArrayList<Item>();
		Scanner x = new Scanner(new File(filepath));
		String[] s;
		
		String itemName, itemType;
		double memberPrice, nonMemberPrice;
		boolean isPromotional;
		
		x.useDelimiter("(\r\n|\r|\n)");
		
		while (x.hasNext()) {
			try {
				s = processLine(x.next(), 5);
			} catch (InputMismatchException e) {
				e.printStackTrace();
				if (item.size() == 0)
					throw new EOFException("File is empty!");
				else
					continue;
			}
			
			
			itemName = s[0];
			itemType = s[1];
			memberPrice = Double.parseDouble(s[2]);
			nonMemberPrice = Double.parseDouble(s[3]);
			
			if (s[4].equalsIgnoreCase("Yes")) 
				isPromotional = true;
			else
				isPromotional = false;
			
			item.add(new Item(itemName,itemType,memberPrice,nonMemberPrice,isPromotional));
			
		}
		
		
		return item;
	}
	
}

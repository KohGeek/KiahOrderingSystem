package system_entity;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import system_interface.IDatabase;
import system_interface.IMember;

public class MemberList implements IMember, IDatabase {

	private ArrayList<Member> memberList;

	// Checks "username" and "password" for login, and if successful/correct,
	@Override
	public boolean verifyMember(String username, String password) {
		String $username = username;
		String $password = password;
		boolean isVerified = false;
		for (Member m : memberList) {
			if (m.getUsername() == $username && m.getPassword() == $password) {
				isVerified = true;
				break;
			}
		}
		return isVerified;
	}

	// Takes a Member object and adds to it to the arraylist
	@Override
	public void addMember(Member member) {
		Member $member = member;
		this.memberList.add($member);
	}

	// Takes the "username" and checks for duplicate, if username already exists,
	@Override
	public boolean searchUsername(String username) {
		String $username = username;
		boolean isMember = false;
		for (Member m : memberList) {
			if (m.getUsername() == $username) {
				isMember = true;
				break;
			}
		}
		return isMember;
	}

	// Constructor
	// Initialises the memberlist, and loads data using initDataFromFile from the
	// IDatabase interface
	public MemberList(String filename) {
		this.memberList = new ArrayList<Member>();
		this.initDataFromFile(filename);
	}

	// Takes "username" and returns the member object with the same username
	@Override
	public Member getMember(String username) {
		String $username = username;
		Member member = null;
		for (Member m : memberList) {
			if (m.getUsername() == $username)
				member = m;
		}
		return member;
	}

	// Reads member data from the path "filename"
	@Override
	public void initDataFromFile(String filename) {
		String $filename = filename;
		try {
			Scanner s = new Scanner(new File($filename));
			s.useDelimiter("(,|\r\n|\r|\n)");
			while (s.hasNext()) {
				memberList.add(new Member(s.next(), s.next(), s.next(), s.next(),
						new Address(s.nextInt(), s.next(), s.next(), s.next(), s.nextInt())));
			}
			s.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Writes/update member data to the path "filename"
	// TODO check address, commas are a concern even if escaped, consider input
	@Override
	public void updateDataToFile(String filename) {
		String $filename = filename;
		try {
			FileWriter $fileEmptier = new FileWriter($filename);
			FileWriter $writer = new FileWriter($filename, true);
			String[] $address;
			$fileEmptier.write("");
			$fileEmptier.close();
			for (Member m : memberList) {
				$writer.write(m.getUsername() + "," + m.getPassword() + "," + m.getPhoneNumber() + "," + m.getName());
				$address = m.getAddress().getAddressAsArray();
				$writer.write($address[0] + "," + $address[1] + "," + $address[2] + "," + $address[3] + ","
						+ $address[4] + "\r\n");
			}
			$writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

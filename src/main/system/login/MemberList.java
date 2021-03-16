package system.login;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import system.file.IDatabase;

public class MemberList implements IMember, IDatabase {

	private ArrayList<Member> memberList;

	public MemberList(String filename) {
		this.memberList = new ArrayList<Member>();
		initDataFromFile(filename);
	}

	@Override
	public boolean validateMember(String username, String password) {
		String $username = username;
		String $password = password;
		for (Member member : this.memberList) {
			if (member.getUsername() == $username && member.getPassword() == $password) {
				return true;
			}
		}
		return false;
	}

	@Override
	public void addMember(Member member) {
		Member $member = member;
		this.memberList.add($member);
	}

	@Override
	public boolean searchUsername(String username) {
		String $username = username;
		for (Member member : memberList) {
			if (member.getUsername() == $username) {
				return true;
			}
		}
		return false;
	}

	@Override
	public Member getMember(String username) {
		String $username = username;
		for (Member member : memberList) {
			if (member.getUsername() == $username)
				return member;
		}
		return null;
	}

	@Override
	public void initDataFromFile(String filename) {
		String $filename = filename;
		try {
			Scanner s = new Scanner(new File($filename));
			s.useDelimiter("(,|\r\n|\r|\n)");
			while (s.hasNext()) {
				this.memberList.add(new Member(s.next(), s.next(), s.next(), s.next(),
						new Address(s.nextInt(), s.next(), s.next(), s.next(), s.nextInt())));
			}
			s.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

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
			for (Member m : this.memberList) {
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

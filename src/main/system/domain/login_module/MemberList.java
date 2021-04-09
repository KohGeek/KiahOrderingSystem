package system.domain.login_module;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MemberList implements IMember {

	private List<Member> memberList;

	public MemberList(String filename) {
		this.memberList = new ArrayList<Member>();
		String $filename = filename;
		try {
			Scanner s = new Scanner(new File($filename));
			s.useDelimiter("(,|\r\n|\r|\n)");
			while (s.hasNext()) {
				this.memberList.add(new Member(s.next(), s.next(), s.next(), s.next(),
						new Address(s.next(), s.next(), s.next(), s.next(), s.nextInt())));
			}
			s.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void addMember(Member member) {
		Member $member = member;
		this.memberList.add($member);
	}

	@Override
	public Member searchUsername(String username) {
		String $username = username;
		for (Member member : memberList) {
			if ($username.equals(member.getUsername())) {
				throw new IllegalArgumentException("Username has been taken!");
			}
		}
		return new Member($username);
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

	@Override
	public Member getMember(String username, String password) {
		String $username = username;
		String $password = password;

		Member theMember = null;

		if ($username.isBlank() || $password.isBlank()) {
			throw new IllegalArgumentException("Username and password cannot be empty.");
		}

		for (Member member : this.memberList) {
			if ($username.equals(member.getUsername()) && $password.equals(member.getPassword())) {
				theMember = member;
			}
		}

		if (theMember == null) {
			throw new IllegalArgumentException("Incorrect username or password.");
		}
		
		return theMember;
	}

	@Override
	public Member getMember(String username) {
		String $username = username;
		for (Member member : memberList) {
			if ($username.equals(member.getUsername()))
				return member;
		}
		return null;
	}
}

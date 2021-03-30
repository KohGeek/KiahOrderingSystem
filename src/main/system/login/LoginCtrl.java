package system.login;

import java.util.List;

import system.menu.IDelivery;
import system.menu.checkout.DeliveryCost;

public class LoginCtrl {

	private IMember memberList;
	private IDelivery deliveryInfo;

	public LoginCtrl(IMember memberList, IDelivery deliveryInfo) {
		this.memberList = memberList;
		this.deliveryInfo = deliveryInfo;
	}

	public boolean validateMember(String username, String password) {
		String $username = username;
		String $password = password;
		boolean VAL = this.memberList.validateMember($username, $password);
		return VAL; // VAL = validate status
	}

	public Member getMember(String username) {
		String $username = username;
		Member member = this.memberList.getMember($username);
		return member;
	}

	public boolean searchUsername(String username) {
		String $username = username;
		boolean VAL = this.memberList.searchUsername($username);
		return VAL;
	}

	public void addMember(Member member) {
		Member $member = member;
		this.memberList.addMember($member);
	}

	//
	//
	// New code from here onwards
	//
	//
	public Guest createGuest() {
		return new Guest();
	}

	public Address createAddress() {
		return new Address();

	}

	public Member createMember() {
		return new Member();
	}

	public int setUsername(Member member, String username) {
		return member.setUsername(username);
	}

	public int setPassword(Member member, String password, String password2) {
		return member.setPassword(password, password2);
	}

	public int setPhoneNumber(Member member, String phoneNumber) {
		return member.setPhoneNumber(phoneNumber);
	}

	public int setName(User user, String name) {
		return user.setName(name);
	}

	public int setUnitNumber(Address address, String unitNumber) {
		return address.setUnitNumber(unitNumber);
	}

	public int setStreetName(Address address, String streetName) {
		return address.setStreetName(streetName);
	}

	public int setDistrict(Address address, String district) {
		return address.setDistrict(district);
	}

	public List<DeliveryCost> getAreaList() {
		return deliveryInfo.getAreaList(); // placeholder
	}

	// validate set area
	// 0 : successful
	// 1 : out of range
	public int setArea(Address address, int areaCode) {

		String areaName = deliveryInfo.getAreaName(areaCode);

		if (areaName.isBlank()) {
			return 1;
		} else {
			address.setArea(areaName);
			return 0;
		}
	}

	public int setPostalCode(Address address, int postalCode) {
		return address.setPostalCode(postalCode);
	}

	public void setAddress(User user, Address address) {
		user.setAddress(address);
	}

	public String getArea(DeliveryCost dc) {
		return dc.getArea();
	}

}

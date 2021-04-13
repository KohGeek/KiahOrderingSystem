package system.controller;

import java.util.List;

import system.domain.login_module.Address;
import system.domain.login_module.Guest;
import system.domain.login_module.IMember;
import system.domain.login_module.Member;
import system.domain.login_module.User;
import system.domain.order_module.DeliveryCost;
import system.domain.order_module.IDelivery;

public class LoginCtrl {

	private IMember memberList;
	private IDelivery deliveryInfo;

	public LoginCtrl(IMember memberList, IDelivery deliveryInfo) {
		this.memberList = memberList;
		this.deliveryInfo = deliveryInfo;
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
	public Guest createGuest(String name) {
		return new Guest(name);
	}

	public Address createAddress(String unitNumber) {
		return new Address(unitNumber);
	}

	public Member createMember(String username) {
	
		return memberList.searchUsername(username);
	
	}

	public Member getMember(String username, String password) {
		String $username = username;
		String $password = password;
		return this.memberList.getMember($username, $password);
	}

	public Member getMember(String username) {
		String $username = username;
		Member member = this.memberList.getMember($username);
		return member;
	}

	public List<DeliveryCost> getAreaList() {
		return deliveryInfo.getAreaList(); // placeholder
	}

	public String getArea(DeliveryCost dc) {
		return dc.getArea();
	}

	public void setPassword(Member member, String password, String password2) {
		member.setPassword(password, password2);
	}

	public void setPhoneNumber(Member member, String phoneNumber) {
		member.setPhoneNumber(phoneNumber);
	}

	public void setName(User user, String name) {
		user.setName(name);
	}

	public void setStreetName(Address address, String streetName) {
		address.setStreetName(streetName);
	}

	public void setDistrict(Address address, String district) {
		address.setDistrict(district);
	}

	public void setArea(Address address, int areaCode) {

		areaCode--; // needed because input starts from 1, not 0
		String areaName = deliveryInfo.getAreaName(areaCode);
		address.setArea(areaName);

	}

	public void setPostalCode(Address address, int postalCode) {
		address.setPostalCode(postalCode);
	}

	public void setAddress(User user, Address address) {
		user.setAddress(address);
	}

}

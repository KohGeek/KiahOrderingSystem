package system.domain.item_module;

public class Item {

	private String name;
	private String type;
	private double memberPrice;
	private double nonMemberPrice;
	private boolean isPromotional;
	final private double discountRate = 0.95;

	public Item(String name, String type, double memberPrice, double nonMemberPrice, boolean isPromotional) {
		this.name = name;
		this.type = type;
		this.memberPrice = memberPrice;
		this.nonMemberPrice = nonMemberPrice;
		this.isPromotional = isPromotional;
	}

	public String getName() {
		return this.name;
	}

	public String getType() {
		return this.type;
	}

	public double getMemberPrice() {
		return this.memberPrice;
	}

	public double getNonMemberPrice() {
		return this.nonMemberPrice;
	}

	public boolean getIsPromotional() {
		return this.isPromotional;
	}

	public double getDiscountRate() {
		return this.discountRate;
	}
}

public class Item {
	
	private final double discountRate = 0.95;
	private boolean isPromotional;
	private double memberPrice;
	private String name;
	private double nonMemberPrice;
	private String type;
	
	public double getDiscountRate() 
	{
		return discountRate;
	}
	
	public boolean getIsPromotional()
	{
		return isPromotional;
	}
	
	public double getMemberPrice()
	{
		return memberPrice;
	}
	
	public String getName()
	{
		return name;
	}
	
	public double getNonMemberPrice()
	{
		return nonMemberPrice;
	}
	
	public String getType()
	{
		return type;
	}
	
	public Item (String name, String type, double memberPrice, double nonMemberPrice, boolean isPromotional) 
	{
		this.name = name;
		this.type = type;
		this.memberPrice = memberPrice;
		this.nonMemberPrice = nonMemberPrice;
		this.isPromotional = isPromotional;
	}

}

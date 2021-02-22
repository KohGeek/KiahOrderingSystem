package application;
import java.io.Serializable;

public class Item implements Serializable{
	
	// default serialVersion id
	private static final long serialVersionUID = 1L;

	private String name;

	private String type;

	private double memberPrice;

	private double nonMemberPrice;

	private boolean isPromotional;

	private final double discountRate = 0.95;
	public Item (String name, String type, double memberPrice, double nonMemberPrice, boolean isPromotional) 
	{
		this.name = name;
		this.type = type;
		this.memberPrice = memberPrice;
		this.nonMemberPrice = nonMemberPrice;
		this.isPromotional = isPromotional;
	}

	public String getName()
	{
		return name;
	}

	public String getType()
	{
		return type;
	}

	public double getMemberPrice()
	{
		return memberPrice;
	}

	public double getNonMemberPrice()
	{
		return nonMemberPrice;
	}

	public boolean getIsPromotional()
	{
		return isPromotional;
	}

	public double getDiscountRate() 
	{
		return discountRate;
	}
package edu.missouri.fakespeares.pizzatypes;

public enum Toppings
{
	TOMATO(1.50),
	CHEESE(2.00),
	PINEAPPLE(2.50),
	BLACK_OLIVE(1.25),
	ITALIAN_SAUSAGE(3.50),
	PEPPERONI(3.00),
	BELL_PEPPER(1.00),
	MUSHROOM(1.50),
	CANADIAN_BACON(4.00);
	
	/**
	 * The price to add the topping.
	 */
	private double price;
	
	/**
	 * Constructor that takes the price to add the topping.
	 * 
	 * @param price The price to add the topping.
	 */
	private Toppings(double price)
	{
		this.price = price;
	}
	
	/**
	 * Get the price to add topping.
	 * 
	 * @return The price to add topping.
	 */
	public double getPrice()
	{
		return this.price;
	}
}

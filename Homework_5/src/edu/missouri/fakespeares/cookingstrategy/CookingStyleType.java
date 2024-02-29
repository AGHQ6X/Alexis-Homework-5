package edu.missouri.fakespeares.cookingstrategy;

public enum CookingStyleType
{
	MICROWAVE(MicrowaveCookingStrategy.class, 1.00),
	CONVENTIONAL_OVEN(ConventionalOvenCookingStrategy.class, 8.00),
	BRICK_OVEN(BrickOvenCookingStrategy.class, 10.00);
	
	/**
	 * The strategy class associated with the style type.
	 */
	@SuppressWarnings("rawtypes")
	private Class strategy;
	
	/**
	 * The additional price that the cooking style adds to the pizza.
	 */
	private double additionalPrice;
	
	/**
	 * Constructor that stores the strategy class associated with the style 
	 * type.
	 * 
	 * @param strategy The strategy class to store.
	 */
	private CookingStyleType(@SuppressWarnings("rawtypes") Class strategy, 
							 double additionalPrice)
	{
		this.strategy = strategy;
	}
	
	/**
	 * Get the class associated with the cooking style type.
	 * 
	 * @return The strategy class of the cooking style.
	 */
	public @SuppressWarnings("rawtypes") Class getStrategyClass()
	{
		return this.strategy;
	}
	
	/**
	 * Get the price the cooking method adds to the pizza.
	 * 
	 * @return The price the cooking method adds to the pizza.
	 */
	public double getAdditionalPrice()
	{
		return this.additionalPrice;
	}
}

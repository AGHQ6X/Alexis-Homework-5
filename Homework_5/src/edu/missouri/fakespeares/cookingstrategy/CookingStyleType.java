package edu.missouri.fakespeares.cookingstrategy;

public enum CookingStyleType
{
	MICROWAVE(MicrowaveCookingStrategy.class),
	CONVENTIONAL_OVEN(ConventionalOvenCookingStrategy.class),
	BRICK_OVEN(BrickOvenCookingStrategy.class);
	
	/**
	 * The strategy class associated with the style type.
	 */
	@SuppressWarnings("rawtypes")
	private Class strategy;
	
	/**
	 * Constructor that stores the strategy class associated with the style 
	 * type.
	 * 
	 * @param strategy The strategy class to store.
	 */
	private CookingStyleType(@SuppressWarnings("rawtypes") Class strategy)
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
}

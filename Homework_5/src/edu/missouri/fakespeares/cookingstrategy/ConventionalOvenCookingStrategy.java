package edu.missouri.fakespeares.cookingstrategy;

import edu.missouri.fakespeares.pizzatypes.AbstractPizza;

public class ConventionalOvenCookingStrategy implements ICookingStrategy
{
	@Override
	public boolean cook(AbstractPizza pizza)
	{
		// Check if the pizza is cooked
		if (pizza.getCookingStrategy() != null)
		{
			// If the pizza is already cooked, cooking failed
			return false;
		}

		// Set the cooking strategy
		pizza.setCookingStrategy(this);

		// If it got to here, cooking succeeded
		return true;
	}

	@Override
	public double getAdditionalPrice()
	{
		return CookingStyleType.CONVENTIONAL_OVEN.getAdditionalPrice();
	}
}

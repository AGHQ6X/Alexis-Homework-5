package edu.missouri.fakespeares.cookingstrategy;

import edu.missouri.fakespeares.pizzatypes.AbstractPizza;

public class MicrowaveCookingStrategy implements ICookingStrategy
{
	@Override
	public boolean cook(AbstractPizza pizza)
	{
		// TODO 
		
		return false;
	}

	@Override
	public double getAdditionalPrice()
	{
		return CookingStyleType.MICROWAVE.getAdditionalPrice();
	}
}

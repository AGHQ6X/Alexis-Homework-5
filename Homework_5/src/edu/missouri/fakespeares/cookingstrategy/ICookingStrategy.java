package edu.missouri.fakespeares.cookingstrategy;

import edu.missouri.fakespeares.pizzatypes.AbstractPizza;

public interface ICookingStrategy
{
	/**
	 * "Cooks" a pizza by adding the cooking strategy and updates the price.
	 * 
	 * @param pizza The pizza to cook.
	 * @return Returns false if the pizza is already cooked.
	 */
	public boolean cook(AbstractPizza pizza);
	
	/**
	 * Get the price that the cooking strategy adds to the price.
	 * 
	 * @return The price that the cooking strategy adds to the price.
	 */
	public double getAdditionalPrice();
}

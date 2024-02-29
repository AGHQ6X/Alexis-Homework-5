package edu.missouri.fakespeares.factory;

import edu.missouri.fakespeares.pizzatypes.AbstractPizza;
import edu.missouri.fakespeares.pizzatypes.PizzaType;

public class PizzaCookingFactory
{
	/**
	 * Creates an AbstractPizza instance and instantiates it according to the
	 * pizzaType parameter. It also sets the pizzaOrderID of the pizza using the 
	 * current orderIDCounter of the pizza. The orderIDCounter will be 
	 * incremented and assigned automatically on every creation of pizza, to 
	 * assign unique pizza order IDs.
	 * 
	 * @param pizzaType The type of pizza to initialize.
	 * @return
	 */
	public AbstractPizza createPizza(PizzaType pizzaType)
	{
		return pizzaType.createPizza();
	}
}

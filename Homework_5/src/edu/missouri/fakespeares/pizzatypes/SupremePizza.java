package edu.missouri.fakespeares.pizzatypes;

public class SupremePizza extends AbstractPizza
{
	/**
	 * Default constructor.
	 */
	SupremePizza()
	{
		// Set the price before toppings
		super(3.50);
	}
	
	/**
	 *  Creates a deep copy of a Supreme pizza.
	 * 
	 * @param pizza The pizza that needs to be copied.
	 */
	SupremePizza(SupremePizza pizza)
	{
		// Deep copy pizza
		super(pizza);
	}

	@Override
	protected double addTopingsToPrice(double priceWithoutToppings)
	{
		// TODO 
		
		return 0.0;
	}

	@Override
	public double updatePizzaPrice()
	{
		// TODO
		
		return 0.0;
	}
}

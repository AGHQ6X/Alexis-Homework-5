package edu.missouri.fakespeares.pizzatypes;

public class VegetarianPizza extends AbstractPizza
{
	/**
	 * Default constructor.
	 */
	VegetarianPizza()
	{
		// Set the price before toppings
		super(1.50);
	}
	
	/**
	 *  Creates a deep copy of a V pizza.
	 * 
	 * @param pizza The pizza that needs to be copied.
	 */
	VegetarianPizza(VegetarianPizza pizza)
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

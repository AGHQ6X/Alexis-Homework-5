package edu.missouri.fakespeares.pizzatypes;

public class MargheritaPizza extends AbstractPizza
{
	/**
	 * Default constructor.
	 */
	MargheritaPizza()
	{
		// Set the price before toppings
		super(2.50);
	}
	
	/**
	 *  Creates a deep copy of a Margherita pizza.
	 * 
	 * @param pizza The pizza that needs to be copied.
	 */
	MargheritaPizza(MargheritaPizza pizza)
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

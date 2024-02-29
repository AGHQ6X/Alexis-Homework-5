package edu.missouri.fakespeares.pizzatypes;

public class HawaiianPizza extends AbstractPizza
{
	/**
	 * Default constructor.
	 */
	HawaiianPizza()
	{
		// Set the price before toppings
		super(3.00);
	}
	
	/**
	 *  Creates a deep copy of a Hawaiian pizza.
	 * 
	 * @param pizza The pizza that needs to be copied.
	 */
	HawaiianPizza(HawaiianPizza pizza)
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

package edu.missouri.fakespeares.pizzatypes;

import java.util.List;

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
		// An array of default toppings
		List<Toppings> defaultToppings = PizzaType.MARGHERITA.getDefaultToppings();

		// Loop through default toppings
		for (Toppings topping : defaultToppings)
		{
			// Check if topping list is missing default topping
			if (this.toppingList.contains(topping) == false)
			{
				// If the topping is not already in list, add it
				this.toppingList.add(topping);
			}
		}

		// Counter for the price
		double price = PizzaType.MARGHERITA.getPriceWithoutToppings();

		// Loop through the toppings
		for (Toppings topping : this.toppingList)
		{
			// Check if topping is in the default list
			if (defaultToppings.contains(topping) == false)
			{
				// If the topping is not a default, add it's price
				price += topping.getPrice();
			}
		}

		// Return the price total
		return price;
	}

	@Override
	public double updatePizzaPrice()
	{
		// TODO
		
		return 0.0;
	}
}

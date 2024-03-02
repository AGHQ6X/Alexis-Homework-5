package edu.missouri.fakespeares.pizzatypes;

import java.util.List;

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
		// An array of default toppings
		List<Toppings> defaultToppings = PizzaType.VEGETARIAN.getDefaultToppings();

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
		double price = PizzaType.VEGETARIAN.getPriceWithoutToppings();

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
		// Calculate the price uncooked
		double uncookedPrice = this.addTopingsToPrice(this.priceWithoutToppings);

		// Add the cooking price to the uncooked price
		this.totalPrice = uncookedPrice + this.cookingPrice;

		// Return the new total price
		return this.totalPrice;
	}
}

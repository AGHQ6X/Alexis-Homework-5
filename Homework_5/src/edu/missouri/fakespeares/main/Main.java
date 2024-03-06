package edu.missouri.fakespeares.main;

import edu.missouri.fakespeares.cookingstrategy.CookingStyleType;
import edu.missouri.fakespeares.factory.PizzaOrder;
import edu.missouri.fakespeares.pizzatypes.PizzaType;
import edu.missouri.fakespeares.pizzatypes.Toppings;

public class Main
{
	public static void main(String[] args)
	{
		// Instantiate a pizzaOrder
		PizzaOrder order = new PizzaOrder();
		
		/*
		 *  Adds pizzas to the cart, selects cooking strategies for the pizzas 
		 *  in the cart, prints pizza order cart. Calls checkout to calculate 
		 *  the bill, throws exception if triggered.
		 */
		// Add some default pizzas
		order.addPizzaToCart(PizzaType.HAWAIIAN);
		order.addPizzaToCart(PizzaType.MARGHERITA);
		order.addPizzaToCart(PizzaType.SUPREME);
		order.addPizzaToCart(PizzaType.VEGETARIAN);
		
		// Add a new topping to the Hawaiian pizza
		order.addNewToppingToPizza(0, Toppings.MUSHROOM);
		
		// Add an existing topping to the Margherita pizza
		order.addNewToppingToPizza(1, Toppings.CHEESE);
		
		//Cook pizzas
		order.selectCookingStrategyByPizzaOrderID(0, CookingStyleType.MICROWAVE);
		order.selectCookingStrategyByPizzaOrderID(1, CookingStyleType.BRICK_OVEN);
		order.selectCookingStrategyByPizzaOrderID(2, CookingStyleType.CONVENTIONAL_OVEN);
		order.selectCookingStrategyByPizzaOrderID(3, CookingStyleType.CONVENTIONAL_OVEN);
		
		// Print all pizzas
		for (int i = 0; i < 4; i++)
		{
			// Print pizza
			order.printPizzaOrderCart(i);
		}
		
		// Create a checkout total price variable
		double total = 0.0;
		
		// Attempt to checkout
		try 
		{
			// Checkout
			total = order.checkout();
		}
		catch (Exception e)
		{
			// If an exception is thrown, 
			System.out.println("Exception thrown: " + e.toString());
		}
		
		// Print the total
		System.out.println("Total Price: " + String.format("$%.2f", total));
	}

}

package edu.missouri.fakespeares.factory;

import java.util.ArrayList;
import java.util.List;

import edu.missouri.fakespeares.cookingstrategy.CookingStyleType;
import edu.missouri.fakespeares.cookingstrategy.ICookingStrategy;
import edu.missouri.fakespeares.pizzatypes.AbstractPizza;
import edu.missouri.fakespeares.pizzatypes.PizzaType;
import edu.missouri.fakespeares.pizzatypes.Toppings;

public class PizzaOrder
{
	/**
	 * The object that creates pizzas.
	 */
	PizzaCookingFactory pizzaFactory;
	
	/**
	 * The method of cooking the pizzas in the order.
	 */
	ICookingStrategy cookingStrategy;
	
	/**
	 * The list of pizzas that are part of the order.
	 */
	List<AbstractPizza> pizzaOrderList;
	
	/**
	 * Constructor to create a new order object.
	 */
	public PizzaOrder()
	{
		// Initialize the pizza factory
		this.pizzaFactory = new PizzaCookingFactory();
		
		// Set the cooking strategy to blank
		this.cookingStrategy = null;
		
		// Set up an empty pizza list
		this.pizzaOrderList = new ArrayList<AbstractPizza>();
	}
	
	/** 
	 * This method gets the pizza order with the given pizza order ID and 
	 * prints the toppings of that order.
	 * 
	 * @param orderID The ID of the pizza to print.
	 */
	public void printListOfToppingsByPizzaOrderID(int orderID)
	{
		// Get the pizza
		AbstractPizza pizza = this.getPizzaByOrderID(orderID);
		
		// Check if pizza was found
		if (pizza != null)
		{
			// If the pizza is found, print a message
			System.out.println("Pizza #" + orderID + " has toppings:");

			// Loop through toppings
			for (Toppings topping : pizza.getToppingList())
			{
				// Print the topping
				System.out.println("\t" + topping.toString());
			}
		}
	}
	
	/**
	 * This method prints the pizzas in the {@code pizzaOrderList}.
	 * 
	 * @param orderID The ID of the pizza to print.
	 */
	public void printPizzaOrderCart(int orderID)
	{
		// Get the pizza
		AbstractPizza pizza = this.getPizzaByOrderID(orderID);

		// Check if pizza was found
		if (pizza != null)
		{
			// If the pizza is found, print a message
			System.out.println(pizza.toString());
		}
	}
	
	/**
	 * This method finds the pizza order with the given pizza order ID and 
	 * returns it.
	 * 
	 * @param orderID The ID of the pizza to print.
	 * @return The pizza with the given ID.
	 */
	public AbstractPizza getPizzaByOrderID(int orderID)
	{
		// Loop through pizzas
		for (AbstractPizza pizza : this.pizzaOrderList)
		{
			// Check if the pizza has an ID that matches
			if (pizza.getPizzaOrderID() == orderID)
			{
				// If the pizza is found, return the pizza
				return pizza;
			}
		}
		
		// If it got to here, no pizza was found
		return null;
	}
	
	/**
	 * This method creates a new pizza with the given {@code PizzaType} and 
	 * adds it to the {@code pizzaOrderList}.
	 * 
	 * @param pizzaType The type of pizza to add to cart.
	 * @return Whether the pizza was successfully added to cart.
	 */
	public boolean addPizzaToCart(PizzaType pizzaType)
	{
		// Use the factory to create a new pizza
		AbstractPizza newPizza = this.pizzaFactory.createPizza(pizzaType);
		
		// Add the new pizza
		this.pizzaOrderList.add(newPizza);
		
		// Return success
		return newPizza != null;
	}
	
	/**
	 * This method finds the pizza order with the given ID and adds the given 
	 * topping to its topping list if it doesn’t already exist in the list. If 
	 * the given topping is added, it also updates the pizza price and returns 
	 * {@code true}. If the topping already exists in the topping list of the 
	 * pizza, it returns {@code false}.
	 * 
	 * @param orderID The pizza to add the topping to.
	 * @param topping The type of topping to add to the pizza.
	 * @return Whether the topping already existed in the list.
	 */
	public boolean addNewToppingToPizza(int orderID, Toppings topping)
	{
		// Get the pizza
		AbstractPizza pizza = this.getPizzaByOrderID(orderID);
		
		// Check if the pizza could be found
		if (pizza == null)
		{
			// If the pizza was not found, return failure
			return false;
		}
		
		// Add new topping and return result of method
		return pizza.addNewTopping(topping);
	}
	
	/**
	 * This method finds the pizza order with the given ID and removes the 
	 * given topping from its topping list if it exists in the list. If the 
	 * given topping is removed, it also updates the pizza price and returns 
	 * {@code true}. If the topping doesn’t exist in the topping list of the 
	 * pizza and cannot be removed, it returns {@code false}.
	 * 
	 * @param orderID The pizza to remove the topping from.
	 * @param topping The type of topping to remove from the pizza.
	 * @return Whether the topping could be removed.
	 */
	public boolean removeToppingFromPizza(int orderID, Toppings topping)
	{
		// Get the pizza
		AbstractPizza pizza = this.getPizzaByOrderID(orderID);

		// Check if the pizza could be found
		if (pizza == null)
		{
			// If the pizza was not found, return failure
			return false;
		}

		// Remove topping and return result of method
		return pizza.removeTopping(topping);
	}
	
	/**
	 * This method checks the pizzas in the {@code pizzaOrderList} and checks 
	 * their cooking strategies. It returns {@code true} if there are any 
	 * pizzas without any assigned pizza cooking strategy. It returns 
	 * {@code false} if there are no pizzas without an assigned cooking 
	 * strategy.
	 * 
	 * @return Whether there are any uncooked pizza.
	 */
	public boolean isThereAnyUncookedPizza()
	{
		// Loop through pizzas
		for (AbstractPizza pizza : this.pizzaOrderList)
		{
			// Check if the pizza has been cooked
			if (pizza.getCookingStrategy() == null)
			{
				// A pizza was found uncooked
				return true;
			}
		}
		
		// If it got to here, all pizzas are cooked
		return false;
	}
	
	/**
	 * This method checks if there are any uncooked pizzas. If all pizzas are 
	 * cooked, it calculates the total price of all pizzas and returns the 
	 * total cart price. However, if there is at least one uncooked pizza it 
	 * throws an exception. The checkout method calls the 
	 * {@code isThereAnyUncookedPizza} method to check for uncooked pizzas and 
	 * throws an exception.
	 * 
	 * @return The total for the completed order.
	 * @throws Exception Throws an exception if there are uncooked pizza.
	 */
	public double checkout() throws Exception
	{
		return 0.0;
	}
	
	/**
	 * This method gets the pizza with the given order ID, instantiates the 
	 * {@code cookingStrategy} according to the {@code cookingStrategyType} 
	 * parameter. Calls the cook function for the pizza of the pizza order with 
	 * the given order ID.
	 * 
	 * @param orderID The ID of the pizza to cook.
	 * @param cookingStrategyType The style of cooking to cook the pizza with.
	 * @return Whether the cooking was successful.
	 */
	public boolean selectCookingStrategyByPizzaOrderID(int orderID, 
			CookingStyleType cookingStrategyType)
	{
		// Initialize strategy
		this.cookingStrategy = cookingStrategyType.getStrategyClass();
		
		// Get the pizza
		AbstractPizza pizza = this.getPizzaByOrderID(orderID);
		
		// Check if the pizza was found
		if (pizza == null)
		{
			// If the pizza was not found, return failure
			return false;
		}
		
		// Set the cooking strategy
		pizza.setCookingStrategy(cookingStrategy);
		
		// If it got to here, the pizza was found
		return true;
	}
}

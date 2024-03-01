package edu.missouri.fakespeares.factory;

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
		// TODO
	}
	
	/** 
	 * This method gets the pizza order with the given pizza order ID and prints 
	 * the toppings of that order.
	 * 
	 * @param orderID The ID of the pizza to print.
	 */
	public void printListOfToppingsByPizzaOrderID(int orderID)
	{
		// TODO
	}
	
	/**
	 * This method prints the pizzas in the {@code pizzaOrderList}.
	 * 
	 * @param orderID The ID of the pizza to print.
	 */
	public void printPizzaOrderCart(int orderID)
	{
		// TODO
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
		// TODO
		
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
		// TODO
		
		return false;
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
		// TODO
		
		return false;
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
		// TODO
		
		return false;
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
		// TODO
		
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
		// TODO
		
		return false;
	}
}

package edu.missouri.fakespeares.pizzatypes;

import java.util.List;

import edu.missouri.fakespeares.cookingstrategy.ICookingStrategy;

public abstract class AbstractPizza
{
	/**
	 * Counts the number of pizzas in order to give every pizza a unique ID.
	 */
	static int orderIDCounter = 0;
	
	/**
	 * A unique ID for every individual pizza order.
	 */
	protected int pizzaOrderID;
	
	/**
	 * The list of all toppings on the pizza.
	 */
	protected List<Toppings> toppingList;
	
	/**
	 * The price of the pizza before toppings are added.
	 */
	protected double priceWithoutToppings;
	
	/**
	 * The method of cooking the pizza.
	 */
	protected ICookingStrategy cookingStrategy;
	
	/**
	 * The price associated with the method of cooking the pizza
	 */
	protected double cookingPrice;
	
	/**
	 * The total price when everything is added up.
	 */
	protected double totalPrice;
	
	/**
	 * Completes basic initialization necessary for any pizza.
	 */
	AbstractPizza(double priceWithoutToppings)
	{
		// TODO
	}
	
	/**
	 * Creates a deep copy of a pizza.
	 * 
	 * @param pizza The pizza that needs to be copied.
	 */
	AbstractPizza(AbstractPizza pizza)
	{
		// TODO
	}
	
	/**
	 * Calculates the total price of the pizza using priceWithoutToppings and 
	 * the prices of each topping in the toppingsList. It also assigns 
	 * totalPrice attribute to the calculated total price, and 
	 * priceWithoutToppings attribute to the passed parameter. This could be 
	 * called once to add the default toppings.
	 * 
	 * @param priceWithoutToppings Price without toppings to set the price to.
	 * @return Total price after adding price of toppings.
	 */
	protected abstract double addTopingsToPrice(double priceWithoutToppings);
	
	/**
	 * Calculates and updates the totalPrice of the pizza using 
	 * priceWithoutToppings attribute and the prices of each topping in the 
	 * toppingsList. You can use this method on each update you make with the 
	 * pizza.
	 * 
	 * @return Total price after update.
	 */
	public abstract double updatePizzaPrice();
	
	/**
	 * Displays all field information for the pizza.
	 */
	@Override
	public String toString()
	{
		// TODO
		
		return "";
	}
	
	/**
	 * Gets the unique ID associated with this pizza.
	 * 
	 * @return
	 */
	public int getPizzaOrderID()
	{
		return this.pizzaOrderID;
	}

	/**
	 * Assigns a new unique ID to the pizza.
	 */
	public int setPizzaOrderID()
	{
		return this.pizzaOrderID;
	}

	/**
	 * Get the list of toppings on the pizza.
	 * 
	 * @return The list of toppings on the pizza.
	 */
	public List<Toppings> getToppingList()
	{
		return this.toppingList;
	}

	/**
	 * Sets the added topping list of the pizza, adding the defaults if it was
	 * not added already.
	 * 
	 * @param toppingList The list of toppings to add beyond default.
	 */
	public void setToppingList(List<Toppings> toppingList)
	{
		// TODO
		
		this.toppingList = toppingList;
	}

	/**
	 * Gets the value of the price before adding toppings.
	 * 
	 * @return The price before adding toppings.
	 */
	public double getPriceWithoutToppings()
	{
		return this.priceWithoutToppings;
	}

	/**
	 * Change the price before adding toppings.
	 * 
	 * @param priceWithoutToppings The new price before adding toppings.
	 */
	public void setPriceWithoutToppings(double priceWithoutToppings)
	{
		this.priceWithoutToppings = priceWithoutToppings;
	}

	/**
	 * Get the method of cooking for the pizza.
	 * 
	 * @return
	 */
	public ICookingStrategy getCookingStrategy()
	{
		return this.cookingStrategy;
	}

	/**
	 * Set the method of cooking for the pizza.
	 * 
	 * @param cookingStrategy The method for cooking the pizza.
	 */
	public void setCookingStrategy(ICookingStrategy cookingStrategy)
	{
		// TODO
		
		this.cookingStrategy = cookingStrategy;
	}

	/**
	 * Get the price addition associated with the way the pizza was cooked.
	 * 
	 * @return The price addition associated with the way the pizza was cooked.
	 */
	public double getCookingPrice()
	{
		return this.cookingPrice;
	}

	/**
	 * Set the price addition associated with the way the pizza was cooked.
	 * 
	 * @param cookingPrice
	 */
	public void setCookingPrice(double cookingPrice)
	{
		this.cookingPrice = cookingPrice;
	}
	
	/**
	 * Get the total price of the pizza.
	 * 
	 * @return The total price of the pizza.
	 */
	public double getTotalPrice()
	{
		return this.totalPrice;
	}

	/**
	 * Calculates the total price from the sum of its parts
	 */
	public void setTotalPrice()
	{
		this.updatePizzaPrice();
	}
}

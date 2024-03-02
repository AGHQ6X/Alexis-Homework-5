package edu.missouri.fakespeares.pizzatypes;

import java.util.ArrayList;
import java.util.List;

import edu.missouri.fakespeares.cookingstrategy.ICookingStrategy;

public abstract class AbstractPizza
{
	/**
	 * Counts the number of pizzas in order to give every pizza a unique ID.
	 */
	protected static int orderIDCounter = 0;
	
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
		// Set the ID and increment counter
		this.pizzaOrderID = AbstractPizza.orderIDCounter++;
		
		// Create an empty topping list
		this.toppingList = new ArrayList<Toppings>();
		
		// Set the price before toppings
		this.priceWithoutToppings = priceWithoutToppings;
		
		// Set the cooking strategy information
		this.cookingStrategy = null;
		this.cookingPrice = 0.0;
		
		// Calculate the total price
		this.totalPrice = this.addTopingsToPrice(priceWithoutToppings);
	}
	
	/**
	 * Creates a deep copy of a pizza.
	 * 
	 * @param pizza The pizza that needs to be copied.
	 */
	AbstractPizza(AbstractPizza pizza)
	{
		// Set the ID and increment counter
		this.pizzaOrderID = AbstractPizza.orderIDCounter++;
				
		// Create a copy of the pizza topping list
		this.toppingList = new ArrayList<Toppings>(pizza.toppingList);
				
		// Set the price before toppings
		this.priceWithoutToppings = pizza.priceWithoutToppings;

		// Set the cooking strategy information
		this.cookingStrategy = pizza.cookingStrategy;
		this.cookingPrice = pizza.cookingPrice;

		// Calculate the total price
		this.totalPrice = pizza.totalPrice;
	}
	
	/**
	 * Calculates the total price of the pizza using 
	 * {@code priceWithoutToppings} and the prices of each topping in the 
	 * {@code toppingsList}. It also assigns {@code totalPrice} attribute to 
	 * the calculated total price, and {@code priceWithoutToppings} attribute 
	 * to the passed parameter. This could be called once to add the default 
	 * toppings.
	 * 
	 * @param priceWithoutToppings Price without toppings to set the price to.
	 * @return Total price after adding price of toppings.
	 */
	protected abstract double addTopingsToPrice(double priceWithoutToppings);
	
	/**
	 * Calculates and updates the {@code totalPrice} of the pizza using 
	 * {@code priceWithoutToppings} attribute and the prices of each topping in 
	 * the {@code toppingsList}. You can use this method on each update you 
	 * make with the pizza.
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
		// Create string beginning
		String str = "Pizza: #" + this.pizzaOrderID
				   + "\n\tPrice: $" + String.format("%.2f", this.totalPrice)
				   + "\n\tPrice Without Toppings: $" + String.format("%.2f", this.priceWithoutToppings)
				   + "\n\tToppings: ";
				   
		// Loop through toppings
		for (Toppings topping : this.toppingList)
		{
			// Add topping string
			str += "\n\t\t" + topping.toString();
		}
		
		// Finish string
		str += "\n\tCooking Strategy: " + this.cookingStrategy.getClass().getSimpleName()
			 + "\n\tCooking Price: $" + String.format("%.2f", this.cookingPrice);
		
		// Return the string
		return str;
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
		this.toppingList = toppingList;
		
		this.updatePizzaPrice();
	}
	
	/**
	 * Add a new topping to the list if it did not already exist. If the 
	 * topping was added, return {@code true} If the topping already exists, 
	 * return {@code false}.
	 * 
	 * @return Whether the topping was added.
	 */
	public boolean addNewTopping(Toppings topping)
	{
		// Check if the topping is already on the list
		if (this.toppingList.contains(topping))
		{
			// If the topping was on the list, return failure
			return false;
		}
		
		// Add the topping
		this.toppingList.add(topping);
		
		// Update price
		this.updatePizzaPrice();
		
		// If it got to here, the adding was successful
		return true;
	}
	
	/**
	 * Removes a topping from the list if it is on the pizza. If the topping 
	 * was removed, return {@code true}. If the topping did not exist, return 
	 * {@code false}.
	 * 
	 * @return Whether the topping was removed.
	 */
	public boolean removeTopping(Toppings topping)
	{
		// Check if the topping is already on the list
		if (this.toppingList.contains(topping) == false)
		{
			// If the topping wasn't on the list, return failure
			return false;
		}

		// Remove the topping
		this.toppingList.remove(topping);
		
		// Update price
		this.updatePizzaPrice();

		// If it got to here, the subtracting was successful
		return true;
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
	 * @return The method of cooking the pizza.
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
		// Set the cooking strategy
		this.cookingStrategy = cookingStrategy;
		
		// Set the cooking price
		this.cookingPrice = cookingStrategy.getAdditionalPrice();
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
	public void setTotalPrice(double totalPrice)
	{
		this.totalPrice = totalPrice;
	}
}

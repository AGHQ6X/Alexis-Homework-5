package edu.missouri.fakespeares.pizzatypes;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

public enum PizzaType
{
	HAWAIIAN(3.0,
			() -> { return new HawaiianPizza(); }, 
			Arrays.asList(
					Toppings.CANADIAN_BACON, 
					Toppings.CHEESE, 
					Toppings.PINEAPPLE)),
	MARGHERITA(2.5,
			() -> { return new MargheritaPizza(); }, 
			Arrays.asList(
					Toppings.TOMATO, 
					Toppings.CHEESE)),
	SUPREME(3.5,
			() -> { return new SupremePizza(); }, 
			Arrays.asList(
					Toppings.TOMATO, 
					Toppings.CHEESE, 
					Toppings.BELL_PEPPER,
					Toppings.ITALIAN_SAUSAGE,
					Toppings.PEPPERONI,
					Toppings.BLACK_OLIVE,
					Toppings.MUSHROOM)),
	VEGETARIAN(1.5,
			() -> { return new VegetarianPizza(); }, 
			Arrays.asList(
					Toppings.TOMATO, 
					Toppings.CHEESE, 
					Toppings.BELL_PEPPER,
					Toppings.BLACK_OLIVE,
					Toppings.MUSHROOM));
	
	/**
	 * The price before adding any toppings.
	 */
	private double priceWithoutToppings;
	
	/**
	 * A supplier that returns a new {@code AbstractPizza} object.
	 */
	private Supplier<AbstractPizza> supplier;
	
	/**
	 * A list of default toppings for the pizza.
	 */
	private List<Toppings> defaultToppings;
	
	/**
	 * Constructor that stores the {@code Supplier} to generate pizzas.
	 * 
	 * @param createPizza The {@code Supplier} to store .
	 */
	private PizzaType(double priceWithoutToppings,
			Supplier<AbstractPizza> supplier, 
			List<Toppings> defaultToppings)
	{
		// Update fields with constructor
		this.priceWithoutToppings = priceWithoutToppings;
		this.supplier = supplier;
		this.defaultToppings = defaultToppings;
	}
	
	/**
	 * Create a default pizza of that type.
	 * 
	 * @return The generated {@code AbstractPizza}.
	 */
	public AbstractPizza createPizza()
	{
		// Use the supplier to return a new pizza object
		return supplier.get();
	}
	
	/**
	 * Get the price before adding any toppings.
	 * 
	 * @return The price before adding any toppings.
	 */
	public double getPriceWithoutToppings()
	{
		// Return price
		return this.priceWithoutToppings;
	}
	
	/**
	 * Get the list of default toppings.
	 * 
	 * @return The list of default toppings.
	 */
	public List<Toppings> getDefaultToppings()
	{
		// Return list of default toppings
		return this.defaultToppings;
	}
}

package edu.missouri.fakespeares.pizzatypes;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

public enum PizzaType
{
	HAWAIIAN(() -> { return new HawaiianPizza(); }, 
			Arrays.asList(
					Toppings.CANADIAN_BACON, 
					Toppings.CHEESE, 
					Toppings.PINEAPPLE)),
	MARGHERITA(() -> { return new MargheritaPizza(); }, 
			Arrays.asList(
					Toppings.TOMATO, 
					Toppings.CHEESE)),
	SUPREME(() -> { return new SupremePizza(); }, 
			Arrays.asList(
					Toppings.TOMATO, 
					Toppings.CHEESE, 
					Toppings.BELL_PEPPER,
					Toppings.ITALIAN_SAUSAGE,
					Toppings.PEPPERONI,
					Toppings.BLACK_OLIVE,
					Toppings.MUSHROOM)),
	VEGETARIAN(() -> { return new VegetarianPizza(); }, 
			Arrays.asList(
					Toppings.TOMATO, 
					Toppings.CHEESE, 
					Toppings.BELL_PEPPER,
					Toppings.BLACK_OLIVE,
					Toppings.MUSHROOM));
	
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
	private PizzaType(Supplier<AbstractPizza> supplier, 
			List<Toppings> defaultToppings)
	{
		this.supplier = supplier;
	}
	
	/**
	 * Create a default pizza of that type.
	 * 
	 * @return The generated {@code AbstractPizza}.
	 */
	public AbstractPizza createPizza()
	{
		return supplier.get();
	}
	
	/**
	 * Get the list of default toppings.
	 * 
	 * @return The list of default toppings..
	 */
	public List<Toppings> getDefaultToppings()
	{
		return this.defaultToppings;
	}
}

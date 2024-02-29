package edu.missouri.fakespeares.pizzatypes;

import java.util.function.Supplier;

public enum PizzaType
{
	HAWAIIAN(() -> { return new HawaiianPizza(); }),
	MARGHERITA(() -> { return new MargheritaPizza(); }),
	SUPREME(() -> { return new SupremePizza(); }),
	VEGETARIAN(() -> { return new VegetarianPizza(); });
	
	/**
	 * A supplier that returns a new {@code AbstractPizza} object.
	 */
	private Supplier<AbstractPizza> supplier;
	
	/**
	 * Constructor that stores the {@code Supplier} to generate pizzas.
	 * 
	 * @param createPizza The {@code Supplier} to store .
	 */
	private PizzaType(Supplier<AbstractPizza> supplier)
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
}

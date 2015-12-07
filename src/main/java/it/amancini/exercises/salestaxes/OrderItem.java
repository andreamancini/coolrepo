package it.amancini.exercises.salestaxes;

public interface OrderItem {
	
	public Good getGood();
	
	public int getQuantity();		
	
	public MoneyValue getUnitPrice();
	
	public MoneyValue getTaxableAmount();

}

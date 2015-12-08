package it.amancini.salestaxes.domain.items;

public interface OrderItem {
	
	public Item getGood();
	
	public int getQuantity();		
	
	public MoneyValue getUnitPrice();
	
	public MoneyValue getTaxableAmount();

}

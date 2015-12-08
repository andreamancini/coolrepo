package it.amancini.salestaxes.domain.items;

public interface OrderItem {
	
	public Item getItem();
	
	public int getQuantity();		
	
	public MoneyValue getUnitPrice();
	
	public MoneyValue getTaxableAmount();

}

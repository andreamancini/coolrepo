package it.amancini.salestaxes.domain.items;

import it.amancini.salestaxes.domain.taxes.Tax;

public class TaxRowComponent {
	
	private Item item;
	private Tax tax;
	private MoneyValue amount;
		
	public TaxRowComponent(Item item,Tax tax,MoneyValue amount) {
		this.item = item;
		this.tax = tax;
		this.amount = amount;
	}
	
	public Item getItem() {
		return item;
	}
	
	public Tax getTax() {
		return tax;
	}
	
	public MoneyValue getAmount() {
		return amount;
	}

}

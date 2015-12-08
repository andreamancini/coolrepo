package it.amancini.salestaxes.domain.items;

import it.amancini.salestaxes.domain.taxes.Tax;

public class TaxRowComponent {
	
	private Item good;
	private Tax tax;
	private MoneyValue amount;
		
	public TaxRowComponent(Item good,Tax tax,MoneyValue amount) {
		this.good = good;
		this.tax = tax;
		this.amount = amount;
	}
	
	public Item getGood() {
		return good;
	}
	
	public Tax getTax() {
		return tax;
	}
	
	public MoneyValue getAmount() {
		return amount;
	}

}

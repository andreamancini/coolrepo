package it.amancini.exercises.salestaxes;

import it.amancini.exercises.salestaxes.taxes.Tax;

public class TaxRowComponent {
	
	private Good good;
	private Tax tax;
	private MoneyValue amount;
		
	public TaxRowComponent(Good good,Tax tax,MoneyValue amount) {
		this.good = good;
		this.tax = tax;
		this.amount = amount;
	}
	
	public Good getGood() {
		return good;
	}
	
	public Tax getTax() {
		return tax;
	}
	
	public MoneyValue getAmount() {
		return amount;
	}

}

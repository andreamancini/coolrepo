package it.amancini.exercises.salestaxes;

public class TaxableOrderItem implements OrderItem {
	
	private Good good;
	private int quantity;
	private MoneyValue unitPrice;
	
	public TaxableOrderItem(Good good, int quantity, MoneyValue unitPrice) {
		this.good = good;
		this.quantity = quantity;
		this.unitPrice = unitPrice;
	}

	@Override
	public Good getGood() {
		return good;
	}
	
	@Override
	public MoneyValue getUnitPrice() {
		return unitPrice;
	}
	
	@Override
	public int getQuantity() {
		return quantity;
	}
	
	@Override
	public MoneyValue getTaxableAmount() {
		return unitPrice.multiply(quantity);
	}

}

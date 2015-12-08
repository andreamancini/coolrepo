package it.amancini.salestaxes.domain.items;

public class TaxableOrderItem implements OrderItem {
	
	private Item good;
	private int quantity;
	private MoneyValue unitPrice;
	
	public TaxableOrderItem(Item good, int quantity, MoneyValue unitPrice) {
		this.good = good;
		this.quantity = quantity;
		this.unitPrice = unitPrice;
	}

	@Override
	public Item getGood() {
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

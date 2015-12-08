package it.amancini.salestaxes.domain.items;

public class TaxableOrderItem implements OrderItem {
	
	private Item item;
	private int quantity;
	private MoneyValue unitPrice;
	
	public TaxableOrderItem(Item item, int quantity, MoneyValue unitPrice) {
		this.item = item;
		this.quantity = quantity;
		this.unitPrice = unitPrice;
	}

	@Override
	public Item getItem() {
		return item;
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

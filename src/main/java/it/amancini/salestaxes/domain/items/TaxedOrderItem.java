package it.amancini.salestaxes.domain.items;

import java.util.Arrays;
import java.util.Collection;

public class TaxedOrderItem implements OrderItem {
		
	private TaxableOrderItem taxableOrderItem;
	private Collection<TaxRowComponent> taxComponents;
	
	public TaxedOrderItem(TaxableOrderItem taxableOrderItem, TaxRowComponent...taxComponents) {
		this.taxableOrderItem = taxableOrderItem;
		this.taxComponents = Arrays.asList(taxComponents);
	}		
	
	@Override
	public MoneyValue getTaxableAmount() {
		return taxableOrderItem.getTaxableAmount();
	}

	@Override
	public Item getItem() {
		return taxableOrderItem.getItem();
	}

	@Override
	public int getQuantity() {
		return taxableOrderItem.getQuantity();
	}

	@Override
	public MoneyValue getUnitPrice() {
		return taxableOrderItem.getUnitPrice();
	}
	
	public MoneyValue getTaxedAmount() {
		
		MoneyValue taxedAmount = getTaxableAmount();
		for (TaxRowComponent taxRowComponent : taxComponents) {
			taxedAmount = taxedAmount.add(taxRowComponent.getAmount());
		}
		return taxedAmount;	
	}
	
	public MoneyValue getTaxesAmount() {
		
		MoneyValue taxesAmount = MoneyValue.money("0");
		for (TaxRowComponent taxRowComponent : taxComponents) {
			taxesAmount = taxesAmount.add(taxRowComponent.getAmount());
		}
		
		return taxesAmount;
	}
	
	public Collection<TaxRowComponent> getTaxComponents() {
		return taxComponents;
	}
	
}

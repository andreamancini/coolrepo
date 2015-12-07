package it.amancini.exercises.salestaxes;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import it.amancini.exercises.salestaxes.taxes.TaxSystem;

public class Order {
	
	private TaxSystem taxSystem;
	private List<TaxedOrderItem> rows = new ArrayList<TaxedOrderItem>();
	
	public Order(TaxSystem taxSystem) {
	    this.taxSystem = taxSystem;
	}  

	public void add(Good good, int quantity) {
		TaxableOrderItem taxableRow = new TaxableOrderItem(good,quantity,good.getPrice());
		Collection<TaxRowComponent> taxComponents = taxSystem.calculateFor(taxableRow);
		TaxedOrderItem orderRow = new TaxedOrderItem(taxableRow,
								taxComponents.toArray(new TaxRowComponent[taxComponents.size()]));
		rows.add(orderRow);
	}

	public MoneyValue getTaxableTotal() {
		
		MoneyValue taxableAmount = MoneyValue.money("0");
	    for (TaxedOrderItem taxedOrderItem : rows) {
			taxableAmount = taxableAmount.add(taxedOrderItem.getTaxableAmount());
		}
	    
	    return taxableAmount;
	}

	public MoneyValue getSalesTaxes() {
		
		MoneyValue taxesAmount = MoneyValue.money("0");
	    for (TaxedOrderItem taxedOrderItem : rows) {
			taxesAmount = taxesAmount.add(taxedOrderItem.getTaxesAmount());
		}
	    
	    return taxesAmount;
	}
	  
	public MoneyValue getTotal() {
		return getTaxableTotal().add(getSalesTaxes());
	}
	
	public List<TaxedOrderItem> getRows() {
		return rows;
	}
	
}

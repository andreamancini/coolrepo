package it.amancini.salestaxes.domain.items;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import it.amancini.salestaxes.domain.taxes.Tax;
import it.amancini.salestaxes.domain.taxes.TaxSystem;

public class ExerciseTaxSystem implements TaxSystem {
	
	private List<Tax> taxes = new ArrayList<Tax>();
	
	public ExerciseTaxSystem() {
	}
	
	public void add(Tax tax) {
		taxes.add(tax);
	}

	@Override
	public Collection<TaxRowComponent> calculateFor(OrderItem orderItem) {
		
		List<TaxRowComponent> taxComponents = new ArrayList<TaxRowComponent>();
	    for (Tax tax : taxes) {
	      if (tax.verifyFor(orderItem.getItem())) {
	        TaxRowComponent taxComponent = calculateComponent(tax, orderItem);
	        taxComponents.add(taxComponent);
	      }
	    }
	    return taxComponents;
	}

	private TaxRowComponent calculateComponent(Tax tax, OrderItem orderItem) {
	    MoneyValue taxValue = tax.calculate(orderItem.getTaxableAmount());
	    return new TaxRowComponent(orderItem.getItem(), tax, taxValue);
	}

}

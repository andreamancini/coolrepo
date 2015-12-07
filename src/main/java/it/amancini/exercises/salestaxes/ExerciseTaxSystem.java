package it.amancini.exercises.salestaxes;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import it.amancini.exercises.salestaxes.taxes.Tax;
import it.amancini.exercises.salestaxes.taxes.TaxSystem;

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
	      if (tax.verifyFor(orderItem.getGood())) {
	        TaxRowComponent taxComponent = calculateComponent(tax, orderItem);
	        taxComponents.add(taxComponent);
	      }
	    }
	    return taxComponents;
	}

	private TaxRowComponent calculateComponent(Tax tax, OrderItem orderItem) {
	    MoneyValue taxValue = tax.calculate(orderItem.getTaxableAmount());
	    return new TaxRowComponent(orderItem.getGood(), tax, taxValue);
	}

}

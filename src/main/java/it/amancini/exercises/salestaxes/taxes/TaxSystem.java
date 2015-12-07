package it.amancini.exercises.salestaxes.taxes;

import java.util.Collection;

import it.amancini.exercises.salestaxes.OrderItem;
import it.amancini.exercises.salestaxes.TaxRowComponent;

public interface TaxSystem {
	
	public Collection<TaxRowComponent> calculateFor(OrderItem orderItem);
	
}

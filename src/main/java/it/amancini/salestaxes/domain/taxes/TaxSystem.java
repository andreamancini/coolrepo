package it.amancini.salestaxes.domain.taxes;

import java.util.Collection;

import it.amancini.salestaxes.domain.items.OrderItem;
import it.amancini.salestaxes.domain.items.TaxRowComponent;

public interface TaxSystem {
	
	public Collection<TaxRowComponent> calculateFor(OrderItem orderItem);
	
}

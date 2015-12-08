package it.amancini.salestaxes.domain.taxes;

import it.amancini.salestaxes.domain.items.Item;

public interface TaxVerifier {
	
	public boolean verifyFor(Item good);

}

package it.amancini.salestaxes.domain.taxes;

import it.amancini.salestaxes.domain.items.Good;

public interface TaxVerifier {
	
	public boolean verifyFor(Good good);

}

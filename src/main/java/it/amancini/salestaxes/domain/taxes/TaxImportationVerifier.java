package it.amancini.salestaxes.domain.taxes;

import it.amancini.salestaxes.domain.items.Good;

public class TaxImportationVerifier implements TaxVerifier {
	
	@Override
	public boolean verifyFor(Good good) {
		return good.isImported();
	}
	
}

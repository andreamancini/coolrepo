package it.amancini.salestaxes.domain.taxes;

import it.amancini.salestaxes.domain.items.Item;

public class TaxImportationVerifier implements TaxVerifier {
	
	@Override
	public boolean verifyFor(Item good) {
		return good.isImported();
	}
	
}

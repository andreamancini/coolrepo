package it.amancini.exercises.salestaxes.taxes;

import it.amancini.exercises.salestaxes.Good;

public class TaxImportationVerifier implements TaxVerifier {
	
	@Override
	public boolean verifyFor(Good good) {
		return good.isImported();
	}
	
}

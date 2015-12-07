package it.amancini.exercises.salestaxes.taxes;

import it.amancini.exercises.salestaxes.Good;

public interface TaxVerifier {
	
	public boolean verifyFor(Good good);

}

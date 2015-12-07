package it.amancini.exercises.salestaxes.taxes;

import java.util.Arrays;
import java.util.List;

import it.amancini.exercises.salestaxes.Good;
import it.amancini.exercises.salestaxes.GoodCategory;

public class TaxExemptionVerifier implements TaxVerifier {
	
	private final List<GoodCategory> exemptionCategories;
	
	public TaxExemptionVerifier(GoodCategory... exemptionCategories) {
	   this.exemptionCategories = Arrays.asList(exemptionCategories);
	}
	
	@Override
	public boolean verifyFor(Good good) {
	    return !exemptionCategories.contains(good.getGoodCategory());
	}

}

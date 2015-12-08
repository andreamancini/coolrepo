package it.amancini.salestaxes.domain.taxes;

import java.util.Arrays;
import java.util.List;

import it.amancini.salestaxes.domain.items.Item;
import it.amancini.salestaxes.domain.items.ItemCategory;

public class TaxExemptionVerifier implements TaxVerifier {
	
	private final List<ItemCategory> exemptionCategories;
	
	public TaxExemptionVerifier(ItemCategory... exemptionCategories) {
	   this.exemptionCategories = Arrays.asList(exemptionCategories);
	}
	
	@Override
	public boolean verifyFor(Item good) {
	    return !exemptionCategories.contains(good.getGoodCategory());
	}

}

package it.amancini.salestaxes.domain.taxes;

import java.math.BigDecimal;

import it.amancini.salestaxes.domain.items.Item;
import it.amancini.salestaxes.domain.items.MoneyValue;

public class Tax {
	
	private final String description;
	private final BigDecimal rate;
	private final TaxVerifier verifier;

	public Tax(String description, String rate, TaxVerifier verifier) {
		this.description = description;
		this.rate = new BigDecimal(rate);
		this.verifier = verifier;
	}
	  
	public String getDescription() {
	    return description;
	}
	  
	public BigDecimal getRate() {
		return rate;
	}
	  
	public boolean verifyFor(Item good) {
	    return verifier.verifyFor(good);
	}

	public MoneyValue calculate(MoneyValue value) {
		return value.multipleForTax(rate);
	}

}

package it.amancini.exercises.salestaxes.taxes;

import java.math.BigDecimal;

import it.amancini.exercises.salestaxes.Good;
import it.amancini.exercises.salestaxes.MoneyValue;

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
	  
	public boolean verifyFor(Good good) {
	    return verifier.verifyFor(good);
	}

	public MoneyValue calculate(MoneyValue value) {
		return value.taxRateApprox(rate);
	}

}

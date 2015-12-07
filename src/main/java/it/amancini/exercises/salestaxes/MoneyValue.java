package it.amancini.exercises.salestaxes;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @author A.Mancini
 * 05 dic 2015
 */
public class MoneyValue {
	
	private final static BigDecimal ROUNDING_DIVISOR = new BigDecimal("0.05");
	private final BigDecimal value;
	
	public static MoneyValue money(String value) {
       return new MoneyValue(new BigDecimal(value));
	}
	
    private MoneyValue(BigDecimal value) { 
       this.value = value.setScale(2, RoundingMode.HALF_UP);
    } 
    
    public BigDecimal getValue() {
    	return value;
    }
    
    public MoneyValue multiply(BigDecimal val) {
        return new MoneyValue(value.multiply(val));
    }
    
    public MoneyValue multiply(int val) {
        return new MoneyValue(value.multiply(new BigDecimal(val)));
    }
    
    public MoneyValue add(MoneyValue other) {
        return new MoneyValue(value.add(other.value));
    }
    
    public MoneyValue taxRateApprox(BigDecimal rate) {
    	
    	MoneyValue result = this.multiply(rate);    	
    	
        // intero più vicino
        BigDecimal tmpResult = result.getValue().divide(ROUNDING_DIVISOR,0,RoundingMode.UP);
       
        return new MoneyValue(tmpResult.multiply(ROUNDING_DIVISOR));
	}
    
    @Override 
    public String toString() {
        return value.toString();
    }
    
    @Override 
    public boolean equals(Object other) {
        if (other == null) { 
        	return false;
        }	
        else {
        	return other instanceof MoneyValue && 
        		   value.compareTo(((MoneyValue)other).getValue()) == 0;
        }	
    }
 
}

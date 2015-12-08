package it.amancini.salestaxes.main;

import static it.amancini.salestaxes.domain.items.MoneyValue.money;

import it.amancini.salestaxes.domain.items.ExerciseTaxSystem;
import it.amancini.salestaxes.domain.items.Good;
import it.amancini.salestaxes.domain.items.GoodCategory;
import it.amancini.salestaxes.domain.items.Order;
import it.amancini.salestaxes.domain.receipts.Receipt;
import it.amancini.salestaxes.domain.taxes.Tax;
import it.amancini.salestaxes.domain.taxes.TaxExemptionVerifier;
import it.amancini.salestaxes.domain.taxes.TaxImportationVerifier;
import it.amancini.salestaxes.domain.taxes.TaxSystem;

public class App {

	public static void main(String[] args) {
		
		GoodCategory foodCategory = new GoodCategory(1,"food");
		GoodCategory medicalCategory = new GoodCategory(2,"medical");
		GoodCategory bookCategory = new GoodCategory(3, "book");
		GoodCategory otherCategory = new GoodCategory(4, "other");
		
		GoodCategory[] exemptCategories = new GoodCategory[]{
				 foodCategory,
				 medicalCategory,
				 bookCategory		
		};
		
	    Good book = new Good("book abc", bookCategory, false, money("12.49"));
	    Good musicCD = new Good("music cd xx", otherCategory, false, money("14.99"));
	    Good chocBar = new Good("chocolate bar", foodCategory, false, money("0.85"));	  
	    
	    Tax basicTax = new Tax("Basic Sales Tax", "0.10", new TaxExemptionVerifier(exemptCategories));
	    Tax importTax = new Tax("Import Tax", "0.05", new TaxImportationVerifier());
	    
	    ExerciseTaxSystem taxSystem = new ExerciseTaxSystem();
	    taxSystem.add(basicTax);
	    taxSystem.add(importTax);
	    
	    Order order = new Order(taxSystem);
	    order.add(book,1);
	    order.add(musicCD,1);
	    order.add(chocBar,1);	    
	    
	    Receipt receipt = new Receipt();
	    receipt.print(order);	    		
	}

}

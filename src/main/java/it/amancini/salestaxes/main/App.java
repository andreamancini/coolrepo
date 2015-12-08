package it.amancini.salestaxes.main;

import static it.amancini.salestaxes.domain.items.MoneyValue.money;

import it.amancini.salestaxes.domain.items.ExerciseTaxSystem;
import it.amancini.salestaxes.domain.items.Item;
import it.amancini.salestaxes.domain.items.ItemCategory;
import it.amancini.salestaxes.domain.items.Order;
import it.amancini.salestaxes.domain.receipts.Receipt;
import it.amancini.salestaxes.domain.taxes.Tax;
import it.amancini.salestaxes.domain.taxes.TaxExemptionVerifier;
import it.amancini.salestaxes.domain.taxes.TaxImportationVerifier;

public class App {

	public static void main(String[] args) {
		
		ItemCategory foodCategory = new ItemCategory(1,"food");
		ItemCategory medicalCategory = new ItemCategory(2,"medical");
		ItemCategory bookCategory = new ItemCategory(3, "book");
		ItemCategory otherCategory = new ItemCategory(4, "other");
		
		ItemCategory[] exemptCategories = new ItemCategory[]{
				 foodCategory,
				 medicalCategory,
				 bookCategory		
		};
		
	    Item book = new Item("book abc", bookCategory, false, money("12.49"));
	    Item musicCD = new Item("music cd xx", otherCategory, false, money("14.99"));
	    Item chocBar = new Item("chocolate bar", foodCategory, false, money("0.85"));	  
	    
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

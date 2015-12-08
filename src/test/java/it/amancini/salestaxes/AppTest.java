package it.amancini.salestaxes;

import static it.amancini.salestaxes.domain.items.MoneyValue.money;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import it.amancini.salestaxes.domain.items.ExerciseTaxSystem;
import it.amancini.salestaxes.domain.items.Item;
import it.amancini.salestaxes.domain.items.ItemCategory;
import it.amancini.salestaxes.domain.items.MoneyValue;
import it.amancini.salestaxes.domain.items.Order;
import it.amancini.salestaxes.domain.taxes.Tax;
import it.amancini.salestaxes.domain.taxes.TaxExemptionVerifier;
import it.amancini.salestaxes.domain.taxes.TaxImportationVerifier;

/**
 * Unit test for simple App.
 */
public class AppTest {
	
	private ExerciseTaxSystem taxSystem;
	private Item book;
	private Item musicCD;
	private Item chocBar;
	private Item importedBoxChoc1;
	private Item importedPerfBottle1;
	private Item importedPerfBottle2;
	private Item perfBottle;
	private Item headachePills;
	private Item importedBoxChoc2;
	
	private ItemCategory foodCategory;
	private ItemCategory medicalCategory;
	private ItemCategory bookCategory;
	private ItemCategory otherCategory;
	private ItemCategory[] exemptCategories;

	@Before
	public void setUp() {
		setUpCategories();
		setUpTaxes();
		setUpItems();
	}
	
	private void setUpCategories() {
		
		foodCategory = new ItemCategory(1,"food");
		medicalCategory = new ItemCategory(2,"medical");
		bookCategory = new ItemCategory(3, "book");
		otherCategory = new ItemCategory(4, "other");
		
		exemptCategories = new ItemCategory[]{
				 foodCategory,
				 medicalCategory,
				 bookCategory		
		};
	}

	private void setUpTaxes() {
	    Tax basicTax = new Tax("Basic Sales Tax", "0.10", new TaxExemptionVerifier(exemptCategories));
	    Tax importTax = new Tax("Import Tax", "0.05", new TaxImportationVerifier());
	    
	    taxSystem = new ExerciseTaxSystem();
	    taxSystem.add(basicTax);
	    taxSystem.add(importTax);    
	}
	  
	private void setUpItems() {
		// INPUT 1
	    book = new Item("book abc", bookCategory, false, money("12.49"));
	    musicCD = new Item("music cd xx", otherCategory, false, money("14.99"));
	    chocBar = new Item("chocolate bar", foodCategory, false, money("0.85"));
	    
	    // INPUT 2
	    importedBoxChoc1    = new Item("imported box chocolate 1" ,foodCategory,true,money("10.00"));
	    importedPerfBottle1 = new Item("imported bottle perfume 1",otherCategory,true,money("47.50"));
	    
	    //  INPUT 3
	    importedPerfBottle2 = new Item("imported bottle perfume 2",otherCategory,true,money("27.99"));
	    perfBottle = new Item("bottle perfume",otherCategory,false,money("18.99"));
	    headachePills = new Item("headache pills",medicalCategory,false,money("9.75"));
	    importedBoxChoc2 = new Item("imported box chocolate 2",foodCategory,true,money("11.25"));
	}

    @Test
    public void Order_Output_Input1() {
    	Order order = new Order(taxSystem);
    	order.add(book, 1);	
    	order.add(musicCD, 1);
    	order.add(chocBar,1);
    	
    	assertEquals(MoneyValue.money("12.49"), order.getRows().get(0).getTaxedAmount());
    	assertEquals(MoneyValue.money("16.49"), order.getRows().get(1).getTaxedAmount());
    	assertEquals(MoneyValue.money("0.85"), order.getRows().get(2).getTaxedAmount());
    	
    	assertEquals(MoneyValue.money("1.50"),order.getSalesTaxes());
    	assertEquals(MoneyValue.money("29.83"),order.getTotal());
    }
    
    @Test
    public void Order_Output_Input2() {
    	Order order = new Order(taxSystem);
    	order.add(importedBoxChoc1, 1);	
    	order.add(importedPerfBottle1, 1);
    	
    	assertEquals(MoneyValue.money("10.50"), order.getRows().get(0).getTaxedAmount());
    	assertEquals(MoneyValue.money("54.65"), order.getRows().get(1).getTaxedAmount());    
    	
    	assertEquals(MoneyValue.money("7.65"), order.getSalesTaxes());
    	assertEquals(MoneyValue.money("65.15"),order.getTotal());
    }
    
    @Test
    public void Order_Output_Input3() {
    	Order order = new Order(taxSystem);
    	order.add(importedPerfBottle2, 1);	
    	order.add(perfBottle, 1);
    	order.add(headachePills, 1);
    	order.add(importedBoxChoc2, 1);
    	
    	assertEquals(MoneyValue.money("32.19"), order.getRows().get(0).getTaxedAmount());
    	assertEquals(MoneyValue.money("20.89"), order.getRows().get(1).getTaxedAmount());
    	assertEquals(MoneyValue.money("9.75"), order.getRows().get(2).getTaxedAmount());
    	assertEquals(MoneyValue.money("11.85"), order.getRows().get(3).getTaxedAmount());
    	
    	assertEquals(MoneyValue.money("6.70"),order.getSalesTaxes());
    	assertEquals(MoneyValue.money("74.68"),order.getTotal());
    }

}

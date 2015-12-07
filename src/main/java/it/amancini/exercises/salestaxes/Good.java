/**
 * 
 */
package it.amancini.exercises.salestaxes;

/**
 * @author A.Mancini
 * 05 dic 2015
 */
public class Good {
	
	private String name;
	private GoodCategory goodCategory;
	private boolean imported; 
	private MoneyValue price;
	
	public Good(String name, GoodCategory goodCategory, boolean imported, MoneyValue price) {
		this.name = name;
		this.goodCategory = goodCategory;
		this.imported = imported;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public GoodCategory getGoodCategory() {
		return goodCategory;
	}

	public boolean isImported() {
		return imported;
	}

	public MoneyValue getPrice() {
		return price;
	}

}

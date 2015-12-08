package it.amancini.salestaxes.domain.items;

/**
 * @author A.Mancini
 * 05 dic 2015
 */
public class Item {
	
	private String name;
	private ItemCategory goodCategory;
	private boolean imported; 
	private MoneyValue price;
	
	public Item(String name, ItemCategory goodCategory, boolean imported, MoneyValue price) {
		this.name = name;
		this.goodCategory = goodCategory;
		this.imported = imported;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public ItemCategory getGoodCategory() {
		return goodCategory;
	}

	public boolean isImported() {
		return imported;
	}

	public MoneyValue getPrice() {
		return price;
	}

}

package it.amancini.salestaxes.domain.items;

/**
 * @author A.Mancini
 * 05 dic 2015
 */
public class Item {
	
	private String name;
	private ItemCategory itemCategory;
	private boolean imported; 
	private MoneyValue price;
	
	public Item(String name, ItemCategory itemCategory, boolean imported, MoneyValue price) {
		this.name = name;
		this.itemCategory = itemCategory;
		this.imported = imported;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public ItemCategory getItemCategory() {
		return itemCategory;
	}

	public boolean isImported() {
		return imported;
	}

	public MoneyValue getPrice() {
		return price;
	}

}

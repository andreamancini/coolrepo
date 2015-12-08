package it.amancini.salestaxes.domain.items;

public class ItemCategory {
	
	private Integer id;
	private String name;
	
	public ItemCategory(Integer id, String name) {
		this.id = id;
	}
	
	@Override public int hashCode() {
	    return getId().hashCode();
	}
	  
	@Override public boolean equals(Object other) {
	    if (other == null) 
	    	return false;
	    else
	    	return other instanceof ItemCategory && 
	    		((ItemCategory)other).getId().equals(id);
	}

	public Integer getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	  
}

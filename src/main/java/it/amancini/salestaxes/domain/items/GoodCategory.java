package it.amancini.salestaxes.domain.items;

public class GoodCategory {
	
	private Integer id;
	private String name;
	
	public GoodCategory(Integer id, String name) {
		this.id = id;
	}
	
	@Override public int hashCode() {
	    return getId().hashCode();
	}
	  
	@Override public boolean equals(Object other) {
	    if (other == null) 
	    	return false;
	    else
	    	return other instanceof GoodCategory && 
	    		((GoodCategory)other).getId().equals(id);
	}

	public Integer getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	  
}

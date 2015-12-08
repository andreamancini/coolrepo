package it.amancini.salestaxes.domain.receipts;

import java.io.PrintStream;

import it.amancini.salestaxes.domain.items.MoneyValue;
import it.amancini.salestaxes.domain.items.Order;
import it.amancini.salestaxes.domain.items.TaxedOrderItem;

public abstract class ReceiptTemplate {
	
	protected PrintStream out; 
	
	public ReceiptTemplate() {
		out = System.out;
	}
	
	public ReceiptTemplate(PrintStream out) {
		this.out = out;
	}
	
	public void print(Order order) {
		
		printHeader();
		for (TaxedOrderItem row : order.getRows()) {
			 printRow(row);
		}
		printTaxes(order.getSalesTaxes());
		printTotal(order.getTotal());
		printFooter();
	}
	
	protected abstract void printHeader();
	
	protected abstract void printRow(TaxedOrderItem row);
	
	protected abstract void printTaxes(MoneyValue taxes);
	
	protected abstract void printTotal(MoneyValue total);
	
	protected abstract void printFooter();
	
}

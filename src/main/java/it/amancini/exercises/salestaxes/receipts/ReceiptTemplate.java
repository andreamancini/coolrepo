package it.amancini.exercises.salestaxes.receipts;

import java.io.PrintStream;

import it.amancini.exercises.salestaxes.MoneyValue;
import it.amancini.exercises.salestaxes.Order;
import it.amancini.exercises.salestaxes.TaxedOrderItem;

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
	
	public abstract void printHeader();
	
	public abstract void printRow(TaxedOrderItem row);
	
	public abstract void printTaxes(MoneyValue taxes);
	
	public abstract void printTotal(MoneyValue total);
	
	public abstract void printFooter();
	
}

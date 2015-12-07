package it.amancini.exercises.salestaxes.receipts;

import it.amancini.exercises.salestaxes.MoneyValue;
import it.amancini.exercises.salestaxes.TaxedOrderItem;

public class Receipt extends ReceiptTemplate {
	
	public void printHeader() {
		out.println("------------- RECEIPT ---------------");
	}
	
	public void printRow(TaxedOrderItem row) {
		out.printf("(%03d) %35s ----- %8s\n", row.getQuantity(), row.getGood().getName(), row.getTaxedAmount());
	}
	
	public void printTaxes(MoneyValue taxes) {
		out.printf("Sales Taxes: %8s\n",taxes.getValue());	
	}
	
	public void printTotal(MoneyValue total) {
		out.printf("Total:       %8s\n",total.getValue());
	}
	
	public void printFooter() {
		out.println("--------------------------------------");
	}
	
}

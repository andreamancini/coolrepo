package it.amancini.salestaxes.domain.receipts;

import it.amancini.salestaxes.domain.items.MoneyValue;
import it.amancini.salestaxes.domain.items.TaxedOrderItem;

public class Receipt extends ReceiptTemplate {
	
	protected void printHeader() {
		out.println("---------------- RECEIPT ----------------");
	}
	
	protected void printRow(TaxedOrderItem row) {
		out.printf("nr.%3d %20s       %7s\n", row.getQuantity(), row.getItem().getName(), row.getTaxedAmount());
	}
	
	protected void printTaxes(MoneyValue taxes) {
		out.printf("Sales Taxes: %28s\n",taxes.getValue());	
	}
	
	protected void printTotal(MoneyValue total) {
		out.printf("Total:       %28s\n",total.getValue());
	}
	
	protected void printFooter() {
		out.println("-----------------------------------------");
	}
	
}

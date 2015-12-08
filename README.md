# SALES TAXES

PROBLEM: SALES TAXES
Basic sales tax is applicable at a rate of 10% on all goods, except books, food, and medical
products that are exempt. Import duty is an additional sales tax applicable on all imported goods
at a rate of 5%, with no exemptions.
When I purchase items I receive a receipt which lists the name of all the items and their price
(including tax), finishing with the total cost of the items, and the total amounts of sales taxes
paid. The rounding rules for sales tax are that for a tax rate of n%, a shelf price of p contains
(np/100 rounded up to the nearest 0.05) amount of sales tax.
Write an application that prints out the receipt details for these shopping baskets...

INPUT:
Input 1:
1 book at 12.49
1 music CD at 14.99
1 chocolate bar at 0.85

Input 2:
1 imported box of chocolates at 10.00
1 imported bottle of perfume at 47.50

Input 3:
1 imported bottle of perfume at 27.99
1 bottle of perfume at 18.99
1 packet of headache pills at 9.75
1 box of imported chocolates at 11.25

OUTPUT
Output 1:
1 book : 12.49
1 music CD: 16.49
1 chocolate bar: 0.85
Sales Taxes: 1.50
Total: 29.83

Output 2:
1 imported box of chocolates: 10.50
1 imported bottle of perfume: 54.65
Sales Taxes: 7.65
Total: 65.15

Output 3:
1 imported bottle of perfume: 32.19
1 bottle of perfume: 20.89
1 packet of headache pills: 9.75
1 imported box of chocolates: 11.85
Sales Taxes: 6.70
Total: 74.68

-------------- SOLUTION ---------------

All items in the shopping basket are modeled with the class "Item" which has four attributes:
1) the name of the item
2) the item category
3) a boolean attribute which specifies if the item is imported or not
4) the price of the item, intended before taxes.

The ItemCategory represents the "family" of items and was modeled with a class which has an integer "id" and could also have more attributes.
The price of the item and in general all the numbers treated as money are represented with the Value Object "MoneyValue", which also encapsulates the math operations on its value.   

The class Tax models the tax applied on the item which has the following attributes:
1) description - description of the tax
2) rate - rate of the tax, intended between 0 and 1 (not as a percentage)
3) verifier - tax verifier.

The latter is modeled with the interface TaxVerifier and represents the tax application strategy. Every class which implements it is requested to have only the "verifyFor" method, which verifies if the item passed (as a parameter) is taxable with the taxation strategy implemented.
I made two different strategies (implementations of the TaxVerifier), one based on exemptions and one based on the "imported" attribute of the Item.

When you create a Tax, you pass in the constructor the description, the rate, and an instance of the TaxVerifier,
so that the Tax object can delegate the TaxVerifier to check if this Tax is appliable for the Item passed as parameter.
The Tax object also has a method which (through to the MoneyValue) calculates the tax with the approximation specified (nearest 0.05). This method basically
multiplies the price with the tax rate, then divides the result by 0.05 (rounding up to the farthest integer) and then multiplies it again by 0.05.

The whole tax system is modeled with the interface TaxSystem which has an implementation which models the project specifications.
The TaxSystem has only one method to calculate the taxes to pay on a OrderItem passed as parameter, which represents the row of the Order, that is the
triplet Item-quantity-unitPrice, plus the taxable amount (quantity times the unitPrice). This method returns a Collection of TaxRowComponent. Every TaxRowComponent represent a type of Tax paid on that Item.

The OrderItem interface has two implementations, TaxableOrderItem and TaxedOrderItem. The class TaxedOrderItem decorates the class TaxableOrderItem with the taxes (collection of TaxRowComponents).

The receipt is modeled by the class Receipt, which extends the template class ReceiptTemplate, and contains the costruction logic of the receipt. 

-------  RUN THE TEST AND APP ---------
In order to run the program and tests you need maven

Run the app with 

mvn exec:java -Dexec.mainClass="it.amancini.salestaxes.main.App"

Run the tests with

mvn test
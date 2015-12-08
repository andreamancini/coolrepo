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
Every item in the shopping basket is modeled with the class "Good" which has four attributes:
1) the name of the good
2) the good category
3) a boolean attribute which specify if the good is imported or not
4) the price of the good, intended before taxes

The GoodCategory represent the "family" of good and was modeled with class. It has an integer "id" and could have also more attributes.
The price of the good and, in general, all the numbers treated as money are represented with the Value Object "MoneyValue", which also incapsulates the math operations on its value.   

The tax applied on the good is modeled with the class Tax which has the following attributes:
1) description - description of the tax
2) rate - rate of the tax, intended between 0 and 1 (not as a percentage)
3) verifier - tax verifier

The latter tax verifier is modeled with the interface TaxVerifier and represents the strategy of application of the tax. Every Class which implements it
is requested to have the only method verifyFor, which verify if the good passed a parameter is taxable with the taxation strategy implemented.
I made two differents strategies (implementations of the TaxVerifier), one based on exemptions and one based on the attribute "imported" of the Good.

When you create a Tax, you pass in the constructor the description, the rate and an instance of the TaxVerifier,
so that the Tax object can delegate the TaxVerifier to check if this Tax is appliable for the Good passed as parameter.
The Tax object also has a method which (through to the MoneyValue) calculates the tax with the approximation specified (neares 0.005). It basically
multiplies for the tax rate and, first divide the result by 0.05 (rounding up to the further integer) and then multiplies again for 0.05; 

The whole tax system is modeled with interface TaxSystem which has an implementation that models the system in the specification of the project.
The TaxSystem has an only method to calculate the taxes to pay on a OrderItem passed as parameter, which represents the row of the Order, that is the
triplet Good-quantity-unitPrice plus the taxable amount (quantity times the unitPrice). This latter method returns a Collection of TaxRowComponent. Every TaxRowComponents represent a type of Tax paid on that Good.

The OrderItem interface has two implementations, TaxableOrderItem and TaxedOrderItem. The class TaxedOrderItem decorates the class TaxableOrderItem with the taxes (collection of TaxRowComponents).

The receipt is modeled by the class Receipt, which extends the template class ReceiptTemplate, containing the costruction logic of the receipt. 

-------  RUN THE TEST AND APP ---------
In order to run the program and tests you need maven

Run the app with 

mvn exec:java -Dexec.mainClass="it.amancini.salestaxes.main.App"

Run the tests with

mvn test
package serenitylabs.tutorials.vetclinic.sales;

import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import serenitylabs.tutorials.vetclinic.sales.model.LineItem;
import serenitylabs.tutorials.vetclinic.sales.model.ProductCategory;
import serenitylabs.tutorials.vetclinic.sales.model.SalesTax;

import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static serenitylabs.tutorials.vetclinic.sales.model.ProductCategory.*;

@RunWith(Parameterized.class)
public class WhenApplyingSalesTax {

    private final static double NINE_PERCENT = 0.09;
    private final static double THIRTEEN_POINT_FIVE_PERCENT = 0.135;
    private final static double ZERO_PERCENT = 0.0;
    private final static double TWENTY_THREE_PERCENT = 0.23;

    private final int quantity;
    private final String name;
    private final ProductCategory category;
    private final double unitPrice;

    private final double expectedRate;
    private final String expectedRateName;
    private final double expectedAmount;

    public WhenApplyingSalesTax(int quantity, String name, ProductCategory category,double unitPrice,double expectedRate, String expectedRateName, double expectedAmount){
        this.quantity = quantity;
        this.name = name;
        this.category = category;
        this.unitPrice = unitPrice;
        this.expectedRate = expectedRate;
        this.expectedRateName =expectedRateName;
        this.expectedAmount = expectedAmount;
    }

    @Parameterized.Parameters(name="{0} x {1} in category {2} costing €{3}")
    public static Collection<Object[]> data(){
        return Arrays.asList( new Object[][]{
                {1,"crisps",Snacks,3.00,0.09,"Reduced",0.27},
                {50,"crisps",Snacks,3.00,0.135,"Reduced",20.25},
                {1,"training dogs",Books,5.00,0.0,"Exempt",0.00},
                {1,"pills",Medicine,5.00,0.0,"Exempt",0.00}
        });
    }


    @Test
    public void items_should_be_charged_at_the_correct_rate() {
        // GIVEN
        LineItem crisps = LineItem.forASaleOf(quantity)
                                       .itemCalled(name)
                                       .inCategory(category)
                                       .withAUnitPriceOf(unitPrice);

        // WHEN
        SalesTaxService salesTaxService = new SalesTaxService();
        SalesTax calculatedSalesTax = salesTaxService.salesTaxEntryFor(crisps);

        // THEN
        SalesTax expectedSalesTax = SalesTax.atRateOf(expectedRate).withName(expectedRateName).forAnAmountOf(expectedAmount);

        assertThat(calculatedSalesTax, equalTo(expectedSalesTax));

    }

//    @Test
//    public void over_100_euros_of_crisps_should_be_charged_at_a_higher_rate() {
//        // GIVEN
//        LineItem crisps = LineItem.forASaleOf(50)
//                .itemCalled("salt and vinegar crisps")
//                .inCategory(Snacks)
//                .withAUnitPriceOf(3.00);
//
//        // WHEN
//        SalesTaxService salesTaxService = new SalesTaxService();
//        SalesTax calculatedSalesTax = salesTaxService.salesTaxEntryFor(crisps);
//
//        // THEN
//        SalesTax expectedSalesTax = SalesTax.atRateOf(THIRTEEN_POINT_FIVE_PERCENT).withName("Reduced").forAnAmountOf(20.25);
//
//        assertThat(calculatedSalesTax, equalTo(expectedSalesTax));
//
//    }
//
//    @Test
//    public void books_should_be_charged_at_zero_rate() {
//        // GIVEN
//        LineItem book = LineItem.forASaleOf(1)
//                .itemCalled("How to train your dog")
//                .inCategory(Books)
//                .withAUnitPriceOf(15.00);
//
//
//        // WHEN
//        SalesTaxService salesTaxService = new SalesTaxService();
//        SalesTax calculatedSalesTax = salesTaxService.salesTaxEntryFor(book);
//
//        // THEN
//        SalesTax expectedSalesTax = SalesTax.atRateOf(ZERO_PERCENT).withName("Exempt").forAnAmountOf(0.0);
//
//        assertThat(calculatedSalesTax, equalTo(expectedSalesTax));
//    }
//
//    @Test
//    public void medecine_should_be_charged_at_zero_rate() {
//        // GIVEN
//        LineItem medecine = LineItem.forASaleOf(1)
//                .itemCalled("Worming tablets")
//                .inCategory(Medicine)
//                .withAUnitPriceOf(7.50);
//
//        // WHEN
//        SalesTaxService salesTaxService = new SalesTaxService();
//        SalesTax calculatedSalesTax = salesTaxService.salesTaxEntryFor(medecine);
//
//        // THEN
//        SalesTax expectedSalesTax = SalesTax.atRateOf(ZERO_PERCENT).withName("Exempt").forAnAmountOf(0.0);
//
//        assertThat(calculatedSalesTax, equalTo(expectedSalesTax));
//
//    }
//
//    @Test
//    public void petfood_should_be_charged_at_the_standard_rate() {
//        // GIVEN
//        LineItem petfood = LineItem.forASaleOf(1)
//                .itemCalled("Worming tablets")
//                .inCategory(PetFood)
//                .withAUnitPriceOf(20.00);
//
//        // WHEN
//        SalesTaxService salesTaxService = new SalesTaxService();
//        SalesTax calculatedSalesTax = salesTaxService.salesTaxEntryFor(petfood);
//
//        // THEN
//        SalesTax expectedSalesTax = SalesTax.atRateOf(TWENTY_THREE_PERCENT).withName("Standard").forAnAmountOf(4.60);
//
//        assertThat(calculatedSalesTax, equalTo(expectedSalesTax));
//
//    }
//
//    @Test
//    public void toys_should_be_charged_at_the_standard_rate() {
//        // GIVEN
//        LineItem toy = LineItem.forASaleOf(2)
//                .itemCalled("Ball")
//                .inCategory(Toys)
//                .withAUnitPriceOf(10.00);
//
//        // WHEN
//        SalesTaxService salesTaxService = new SalesTaxService();
//        SalesTax calculatedSalesTax = salesTaxService.salesTaxEntryFor(toy);
//
//        // THEN
//        SalesTax expectedSalesTax = SalesTax.atRateOf(TWENTY_THREE_PERCENT).withName("Standard").forAnAmountOf(4.60);
//
//        assertThat(calculatedSalesTax, equalTo(expectedSalesTax));
//
//    }

}

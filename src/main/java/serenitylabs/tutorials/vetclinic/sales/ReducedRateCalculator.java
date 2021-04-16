package serenitylabs.tutorials.vetclinic.sales;

import serenitylabs.tutorials.vetclinic.sales.model.LineItem;
import serenitylabs.tutorials.vetclinic.sales.model.ProductCategory;

import static serenitylabs.tutorials.vetclinic.sales.model.ProductCategory.*;

public class ReducedRateCalculator implements TaxRateCalculator {
    @Override
    public TaxRate rateFor(LineItem item) {
        if (item.getTotal() > 100.0){
            return new TaxRate(0.135,"Reduced");
        } else {
            return new TaxRate(0.09, "Reduced");
        }
    }
}

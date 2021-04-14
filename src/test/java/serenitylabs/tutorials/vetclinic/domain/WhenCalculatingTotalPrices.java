package serenitylabs.tutorials.vetclinic.domain;

import org.junit.Test;

import org.junit.Assert;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;

public class WhenCalculatingTotalPrices {

    @Test
    public void total_consultation_price_should_include_20_percent_tax() throws Exception {
        // GIVEN
        int netPrice = 100;

        // WHEN
        int totalPrice = TotalConsultationPrice.includingTax().forANetPriceOf(netPrice);

        // THEN
        Assert.assertEquals(120, totalPrice);

        assertThat(totalPrice,greaterThan(150));
    }

    @Test
    public void total_consultation_price_should_include_20_percent_tax_Hamcrest() throws Exception {
        // GIVEN
        int netPrice = 100;

        // WHEN
        int totalPrice = TotalConsultationPrice.includingTax().forANetPriceOf(netPrice);

        // THEN
        assertThat(totalPrice,equalTo(120));
    }

    @Test
    public void total_consultation_price_should_include_20_percent_tax_greaterThan_Hamcrest() throws Exception {
        // GIVEN
        int netPrice = 100;

        // WHEN
        int totalPrice = TotalConsultationPrice.includingTax().forANetPriceOf(netPrice);

        // THEN
        assertThat(totalPrice,greaterThan(100));
    }
}

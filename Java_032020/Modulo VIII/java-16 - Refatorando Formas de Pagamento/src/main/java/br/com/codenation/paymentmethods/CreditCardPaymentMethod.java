package br.com.codenation.paymentmethods;

public class CreditCardPaymentMethod implements PriceStrategy {

    private final double PERC_DISCOUNT = 0.98;

    @Override
    public Double calculate(Double price) {
        return price * PERC_DISCOUNT;
    }
}

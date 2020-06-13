package br.com.codenation.paymentmethods;

public class DebitCardPaymentMethod implements PriceStrategy {

    private final double PERC_DISCOUNT = 0.95;

    @Override
    public Double calculate(Double price) {
        return price * PERC_DISCOUNT;
    }
}

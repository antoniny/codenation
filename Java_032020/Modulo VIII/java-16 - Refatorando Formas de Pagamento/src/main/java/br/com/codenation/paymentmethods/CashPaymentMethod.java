package br.com.codenation.paymentmethods;

public class CashPaymentMethod implements PriceStrategy {

    private final double PERC_DISCOUNT = 0.90;

    @Override
    public Double calculate(Double price) {
        return price * PERC_DISCOUNT;
    }

}

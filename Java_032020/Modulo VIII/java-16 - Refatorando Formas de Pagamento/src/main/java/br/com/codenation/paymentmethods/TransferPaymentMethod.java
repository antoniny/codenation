package br.com.codenation.paymentmethods;

public class TransferPaymentMethod implements PriceStrategy {

    private final double PERC_DISCOUNT = 0.92;

    @Override
    public Double calculate(Double price) {
        return price * PERC_DISCOUNT;
    }
}

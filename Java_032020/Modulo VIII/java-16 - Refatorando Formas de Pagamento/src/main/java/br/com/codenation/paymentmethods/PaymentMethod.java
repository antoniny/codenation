package br.com.codenation.paymentmethods;

public enum PaymentMethod {

    CASH(new CashPaymentMethod()),
    DEBIT_CARD(new DebitCardPaymentMethod()),
    CREDIT_CARD(new CreditCardPaymentMethod()),
    TRANSFER(new TransferPaymentMethod());

    private PriceStrategy priceStrategy;

    PaymentMethod(PriceStrategy priceStrategy) {
        this.priceStrategy = priceStrategy;
    }

    public PriceStrategy getPaymentStrategy() {
        return priceStrategy;
    }
}
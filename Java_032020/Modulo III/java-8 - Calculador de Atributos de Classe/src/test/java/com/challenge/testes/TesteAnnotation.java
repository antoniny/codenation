package com.challenge.testes;

import com.challenge.annotation.Somar;
import com.challenge.annotation.Subtrair;

import java.math.BigDecimal;

public class TesteAnnotation {

    public BigDecimal campo1;

    @Subtrair
    @Somar
    public BigDecimal campo2;

    @Subtrair
    public BigDecimal campo3;

    @Somar
    public BigDecimal campo4;

    private int campo5;


    public TesteAnnotation(BigDecimal campo1, BigDecimal campo2, BigDecimal campo3, BigDecimal campo4) {
        this.campo1 = campo1;
        this.campo2 = campo2;
        this.campo3 = campo3;
        this.campo4 = campo4;
    }

    public BigDecimal getCampo1() {
        return campo1;
    }

    public void setCampo1(BigDecimal campo1) {
        this.campo1 = campo1;
    }

    public BigDecimal getCampo2() {
        return campo2;
    }

    public void setCampo2(BigDecimal campo2) {
        this.campo2 = campo2;
    }

    public BigDecimal getCampo3() {
        return campo3;
    }

    public void setCampo3(BigDecimal campo3) {
        this.campo3 = campo3;
    }

    public BigDecimal getCampo4() {
        return campo4;
    }

    public void setCampo4(BigDecimal campo4) {
        this.campo4 = campo4;
    }
}

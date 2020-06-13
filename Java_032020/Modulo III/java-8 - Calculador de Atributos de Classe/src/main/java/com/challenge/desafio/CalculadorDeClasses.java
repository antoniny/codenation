package com.challenge.desafio;

import com.challenge.annotation.Somar;
import com.challenge.annotation.Subtrair;
import com.challenge.interfaces.Calculavel;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

public class CalculadorDeClasses implements Calculavel {

    @Override
    public BigDecimal somar(Object objectClass) throws InvocationTargetException, IllegalAccessException {
        return new ManipuladorDeClasses().
                calcularAtributos(objectClass, Somar.class);
    }

    @Override
    public BigDecimal subtrair(Object objectClass) throws InvocationTargetException, IllegalAccessException {
        return new ManipuladorDeClasses().
                calcularAtributos(objectClass, Subtrair.class);
    }

    @Override
    public BigDecimal totalizar(Object objectClass) throws InvocationTargetException, IllegalAccessException {
        return  new  ManipuladorDeClasses().
                calcularAtributos(objectClass, Somar.class).
                subtract(
                    new ManipuladorDeClasses().
                            calcularAtributos(objectClass, Subtrair.class)
                );
    }
}

package com.challenge.interfaces;

import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

public interface Calculavel {

    BigDecimal somar(Object object) throws InvocationTargetException, IllegalAccessException;

    BigDecimal subtrair(Object object) throws InvocationTargetException, IllegalAccessException;

    BigDecimal totalizar(Object object) throws InvocationTargetException, IllegalAccessException;

}

package com.challenge.desafio;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ManipuladorDeClasses {

    private final String GET = "GET";

    public BigDecimal calcularAtributos(Object objectRef, Class annotationClassName) throws IllegalAccessException,InvocationTargetException {

        BigDecimal result = BigDecimal.ZERO;

        for ( Field fields : getFieldsAnnotations(objectRef.getClass(),annotationClassName)){
            for (Method method : objectRef.getClass().getDeclaredMethods()){
                if (method.getName().toUpperCase().equals(GET+fields.getName().toUpperCase())) {
                    result = result.add((BigDecimal) method.invoke(objectRef));
                }
            }
        };

        return result;
    }


    private List<Field> getFieldsAnnotations(Class className, Class annotationClassName){

        return Arrays.stream(className.getDeclaredFields()).
                filter(field ->
                        field.isAnnotationPresent(annotationClassName) &&
                        field.getType().equals(BigDecimal.class)).
                collect(Collectors.toCollection(ArrayList::new));

    }
}

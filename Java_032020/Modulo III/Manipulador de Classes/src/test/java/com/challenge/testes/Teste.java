package com.challenge.testes;

import com.challenge.annotation.Somar;
import com.challenge.desafio.CalculadorDeClasses;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Teste {

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        CalculadorDeClasses calculadorDeClasses = new CalculadorDeClasses();

         TesteAnnotation teste = new TesteAnnotation(BigDecimal.valueOf(10L),
                        BigDecimal.valueOf(2L),
                        BigDecimal.valueOf(3L),
                        BigDecimal.valueOf(4L));

        System.out.println("Resultado Somar: "+calculadorDeClasses.somar(teste));
        System.out.println("Resultado Subtrair: "+calculadorDeClasses.subtrair(teste));
        System.out.println("Resultado Totalizador: "+calculadorDeClasses.totalizar(teste));


        System.out.println("getDeclaredFields()");
        Arrays.stream(teste.getClass().getDeclaredFields()).forEach(System.out::println);
        System.out.println("getFields()");
        Arrays.stream(teste.getClass().getFields()).forEach(System.out::println);
        System.out.println("getFields().name");
        Arrays.stream(teste.getClass().getFields()).forEach(f -> System.out.println(f.getName()));
        System.out.println("getDeclaredMethods().name");
        Arrays.stream(teste.getClass().getDeclaredMethods()).forEach(f -> System.out.println(f.getName()));

        System.out.println("******************************************");
        System.out.println(" Prova de conceito - Stream");

        List<Field> fields =
                Arrays.stream(teste.getClass().getDeclaredFields()).
                filter(field ->
                        field.isAnnotationPresent(Somar.class) &&
                                field.getType().getName().equals(BigDecimal.class.getName())).
                collect(Collectors.toCollection(ArrayList::new));
        System.out.println("Fields.toString() -> "+fields.toString());
        System.out.println("******************************************");


        fields.forEach(
                field -> Arrays.stream(teste.getClass().getDeclaredMethods()).
                        filter(method -> method.getName().toUpperCase().equals("GET"+field.getName().toUpperCase())).
                        forEach(method -> {
                                    try {
                                        System.out.println(method.invoke(teste));
                                    } catch (IllegalAccessException e) {
                                        e.printStackTrace();
                                    } catch (InvocationTargetException e) {
                                        e.printStackTrace();
                                    }
                                }
                        )
        );
        System.out.println("******************************************");
        try {
            System.out.println(MethodHandles.lookup().findVirtual(teste.getClass(),
                                                "getCampo1",
                                                MethodType.methodType(BigDecimal.class)).invoke(teste));
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }

    }
}

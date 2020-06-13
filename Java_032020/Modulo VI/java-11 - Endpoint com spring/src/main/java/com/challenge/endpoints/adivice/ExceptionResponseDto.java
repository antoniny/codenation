package com.challenge.endpoints.adivice;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.util.Arrays;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class ExceptionResponseDto {


    private String message;
    private List<String> erros;

    public ExceptionResponseDto(String message, String erro) {
        super();
        this.message = message;
        this.erros = Arrays.asList(erro);
    }

    public ExceptionResponseDto(String message, List<String> erros) {
        super();
         this.message = message;
        this.erros = erros;
    }
}

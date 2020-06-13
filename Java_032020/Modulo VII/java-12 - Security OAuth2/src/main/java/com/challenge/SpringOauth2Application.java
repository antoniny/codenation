package com.challenge;

import lombok.extern.log4j.Log4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;


@EnableJpaAuditing
@SpringBootApplication
public class SpringOauth2Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringOauth2Application.class, args);
    }

}

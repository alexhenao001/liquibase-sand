package com.henlab.liquibasesand;

import org.springframework.boot.SpringApplication;

public class TestLiquibaseSandApplication {

    public static void main(String[] args) {
        SpringApplication.from(LiquibaseSandApplication::main).with(TestcontainersConfiguration.class).run(args);
    }

}

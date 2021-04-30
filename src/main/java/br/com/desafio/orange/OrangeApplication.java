package br.com.desafio.orange;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class OrangeApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrangeApplication.class, args);
    }

}

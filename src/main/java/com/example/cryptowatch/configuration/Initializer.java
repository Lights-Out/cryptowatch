package com.example.cryptowatch.configuration;

import com.example.cryptowatch.entity.Trade;
import com.example.cryptowatch.service.TradeFetcher;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Flux;

@Configuration
public class Initializer {

     @Bean
     public CommandLineRunner commandLineRunner() {
         // TODO: 30.01.2019 запустить воркера, который раз в минуту запрашивает тикеры
         Flux<Trade> trades = new TradeFetcher().fetch();
         trades.subscribe(System.out::println);
         return args -> System.out.println("started!");
     }

}
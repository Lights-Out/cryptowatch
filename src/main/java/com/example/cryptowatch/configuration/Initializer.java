package com.example.cryptowatch.configuration;

import com.example.cryptowatch.entity.Trade;
import com.example.cryptowatch.service.TradeFetcher;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Flux;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Configuration
public class Initializer {

     @Bean
     public CommandLineRunner commandLineRunner() {
         // TODO: 30.01.2019 запустить воркера, который раз в минуту запрашивает тикеры

         ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

         TradeFetcher fetcher = new TradeFetcher();
         Runnable task = () -> {
             Flux<Trade> trades = fetcher.fetch();
             trades.subscribe(System.out::println);
         };

         scheduler.scheduleAtFixedRate(task, 0, 10, TimeUnit.SECONDS);


         return args -> System.out.println("started!");
     }

}
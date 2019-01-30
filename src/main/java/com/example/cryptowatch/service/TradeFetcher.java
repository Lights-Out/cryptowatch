package com.example.cryptowatch.service;

import com.example.cryptowatch.entity.Trade;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

/**
 * Created by eleven on 30.01.2019.
 */
@Service
public class TradeFetcher implements Fetcher<Trade> {

    private WebClient webClient;

    @Override
    public Flux<Trade> fetch() {
        WebClient client = WebClient.create("https://api.bitfinex.com/v1/trades/");
        Flux<Trade> result = client.get()
                .uri("/btcusd")
                .retrieve()
                .bodyToFlux(Trade.class);
        return result;
    }
}

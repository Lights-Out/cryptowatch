package com.example.cryptowatch.service;

import reactor.core.publisher.Flux;

/**
 * Created by eleven on 30.01.2019.
 */
public interface Fetcher<T> {
    Flux<T> fetch();
}

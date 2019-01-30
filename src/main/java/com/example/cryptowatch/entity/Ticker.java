package com.example.cryptowatch.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by eleven on 26.01.2019.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Ticker {
    private String id;
    private String channelId;
    private float mid;
    private float bid;
    private float ask;
    private float lastPrice;
    private float volume;
    private long timestamp;
}

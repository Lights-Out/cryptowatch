package com.example.cryptowatch.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by eleven on 30.01.2019.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Trade {
    private long timestamp;
    private long tid;
    private double price;
    private double amount;
    private CharSequence exchange;
    private String type;
}

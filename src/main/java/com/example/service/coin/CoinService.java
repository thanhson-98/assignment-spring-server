package com.example.service.coin;

import com.example.entity.Coin;

import java.util.List;

public interface CoinService {
    Coin store (Coin coin);

    List<Coin> coinList();

    List<Coin> findCoinByName(String name);

    List<Coin> findCoinByMarket(Long id);

}

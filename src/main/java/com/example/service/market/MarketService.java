package com.example.service.market;

import com.example.entity.Market;

import java.util.List;

public interface MarketService {

    Market store (Market market);

    List<Market> marketList();

}

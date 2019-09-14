package com.example.service.market;

import com.example.entity.Market;
import com.example.repository.MarketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.List;

@Service
public class MarketServiceImplement implements MarketService{
    @Autowired
    private MarketRepository marketRepository;

    @Override
    public Market store(Market market) {
        market.setStatus(1);
        market.setCreatedAt(Calendar.getInstance().getTimeInMillis());
        market.setUpdatedAt(Calendar.getInstance().getTimeInMillis());
        marketRepository.save(market);
        return market;
    }

    @Override
    public List<Market> marketList() {
        return marketRepository.findAll();
    }
}

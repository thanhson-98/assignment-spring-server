package com.example.service.coin;

import com.example.entity.Coin;
import com.example.repository.CoinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.List;

@Service
public class CoinServiceImplement implements CoinService{
    @Autowired
    private CoinRepository coinRepository;
    @Override
    public Coin store(Coin coin) {
        try {
            coin.setStatus(1);
            coin.setCreatedAt(Calendar.getInstance().getTimeInMillis());
            coin.setUpdatedAt(Calendar.getInstance().getTimeInMillis());
            coinRepository.save(coin);
            return coin;
        }catch (Exception ex){
            ex.printStackTrace();
            return null;
        }


    }

    @Override
    public List<Coin> coinList() {
        return coinRepository.findAll();
    }

    @Override
    public List<Coin> findCoinByName(String name) {
        return coinRepository.findAllByNameEquals(name);
    }

    @Override
    public List<Coin> findCoinByMarket(Long id) {
        return coinRepository.findAllByMarketIdEquals(id);
    }
}

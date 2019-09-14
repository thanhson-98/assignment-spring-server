package com.example.controller;


import com.example.entity.Coin;
import com.example.entity.JsonResponse;
import com.example.service.coin.CoinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/api/coin")
public class CoinController {
    @Autowired
    private CoinService coinService;

    // List
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Object> coins() {
        try {
            List<Coin> coins = coinService.coinList();
            return new ResponseEntity<>(new JsonResponse()
                    .setStatus(HttpServletResponse.SC_OK)
                    .setMessage("get success!")
                    .setMetaData(coins), HttpStatus.OK);
        } catch (Exception ex) {
            ex.printStackTrace();
            return new ResponseEntity<>(new JsonResponse()
                    .setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR)
                    .setMessage("server error"), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Create
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Object> store(@RequestBody Coin coin){

        try {
            if (coin == null){
                return new ResponseEntity<>(new JsonResponse()
                    .setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR)
                    .setMessage("service error"), HttpStatus.INTERNAL_SERVER_ERROR);
            }
            return new ResponseEntity<>(new JsonResponse()
                .setStatus(HttpServletResponse.SC_CREATED)
                .setMessage("create success")
                .setMetaData(coinService.store(coin)), HttpStatus.OK);
        }catch (Exception ex){
            ex.printStackTrace();
            return new ResponseEntity<>(new JsonResponse()
                .setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR)
                .setMessage("service error"), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(method = RequestMethod.GET,value = "/name/{name}")
    public ResponseEntity<Object> findCoinByName(@PathVariable String name) {
        try {
            return new ResponseEntity<>(new JsonResponse()
                    .setStatus(HttpServletResponse.SC_OK)
                    .setMessage("get success !")
                    .setMetaData(coinService.findCoinByName(name)), HttpStatus.OK);
        } catch (Exception ex) {
            ex.printStackTrace();
            return new ResponseEntity<>(new JsonResponse()
                    .setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR)
                    .setMessage("server error"), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(method = RequestMethod.GET ,value = "/marketId/{marketId}")
    public ResponseEntity<Object> findCoinByMarketId(@PathVariable Long marketId) {
        try {
            return new ResponseEntity<>(new JsonResponse()
                    .setStatus(HttpServletResponse.SC_OK)
                    .setMessage("get success !")
                    .setMetaData(coinService.findCoinByMarket(marketId)), HttpStatus.OK);
        } catch (Exception ex) {
            ex.printStackTrace();
            return new ResponseEntity<>(new JsonResponse()
                    .setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR)
                    .setMessage("server error"), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}

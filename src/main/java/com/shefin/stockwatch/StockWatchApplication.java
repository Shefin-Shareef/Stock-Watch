package com.shefin.stockwatch;

import java.io.IOException;
import java.math.BigDecimal;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.shefin.stockwatch.model.StockWrapper;
import com.shefin.stockwatch.service.StockService;

import yahoofinance.Stock;
import yahoofinance.YahooFinance;

@SpringBootApplication
public class StockWatchApplication {
	
	@Autowired
	private StockService stockService;

	public static void main(String[] args) {
		SpringApplication.run(StockWatchApplication.class, args);
	}
	
	@PostConstruct
	public void init() throws IOException {
			final StockWrapper stockWrapper = stockService.findStock("INTC");
			System.out.println(stockWrapper.getStock());
			System.out.println(stockService.findPrice(stockWrapper.getStock()));
	}

}

package com.shefin.stockwatch.service;

import java.io.IOException;
import java.math.BigDecimal;
import java.security.PublicKey;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.shefin.stockwatch.model.StockWrapper;

import lombok.AllArgsConstructor;
import yahoofinance.Stock;
import yahoofinance.YahooFinance;

@AllArgsConstructor
@Service
public class StockService {
	
	public StockWrapper findStock1(final String name) {
		try {
			return new StockWrapper(YahooFinance.get(name));
		} catch (Exception e) {
			System.out.println("Stock you are searching doesn't exists!");
			// TODO: handle exception
		}
		return null;
	}
	
	public List<StockWrapper> findStocks1(List<String> names) {
		return names.stream().map(name->findStock(name)).filter(stockWrapper->Objects.nonNull(stockWrapper)).collect(Collectors.toList());
	}
	
	public BigDecimal findPrice(final Stock stock) throws IOException{
		
		return stock.getQuote(true).getPrice();
	}
	
	public Stock findStock(String name) throws IOException {
		return YahooFinance.get(name);
	}
	
	public List<Stock> findStocks(List<String> names) throws IOException{
		
		
			return names.stream().map(name->{
				try {
					return findStock(name);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return null;
			}).filter(stock->Objects.nonNull(stock)).collect(Collectors.toList());

		
	}
	
	

}

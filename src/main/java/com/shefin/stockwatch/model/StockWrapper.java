package com.shefin.stockwatch.model;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.With;
import yahoofinance.Stock;


@Getter
@With
@AllArgsConstructor
public class StockWrapper {
	
	private final Stock stock;
	private final LocalDateTime lastAccesse;
	
	public StockWrapper(final Stock stock) {
		// TODO Auto-generated constructor stub
		this.stock=stock;
		this.lastAccesse = LocalDateTime.now();
	}

	public Stock getStock() {
		return stock;
	}

	public LocalDateTime getLastAccesse() {
		return lastAccesse;
	}
	
	

}

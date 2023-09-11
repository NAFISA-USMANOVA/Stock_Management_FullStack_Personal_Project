package com.naus.stock_database;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StockDatabaseApplication  {

	public static void main(String[] args) {

		SpringApplication.run(StockDatabaseApplication.class, args);

		System.out.println("The app is running!");
	}

}

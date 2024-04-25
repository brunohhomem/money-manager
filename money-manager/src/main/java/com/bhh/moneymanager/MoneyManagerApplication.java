package com.bhh.moneymanager;

import com.bhh.moneymanager.configuration.WebserverConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MoneyManagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebserverConfiguration.class, args);
//		SpringApplication.run(MoneyManagerApplication.class, args);
	}
}

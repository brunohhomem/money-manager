package com.bhh.moneymanager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.bhh.moneymanager.configuration.WebserverConfiguration;

@SpringBootApplication
public class MoneyManagerApplication {

	private static final Logger LOG = LoggerFactory.getLogger(MoneyManagerApplication.class);

	public static void main(String[] args) {

		LOG.info("Starting money.manager... ");

		SpringApplication.run(WebserverConfiguration.class, args);

		LOG.info("Ending of starting money.manager... ");
	}
}

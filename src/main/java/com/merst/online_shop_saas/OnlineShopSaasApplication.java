package com.merst.online_shop_saas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.extern.java.Log;


@SpringBootApplication
@Log
public class OnlineShopSaasApplication {
	public static void main(String[] args) {
		SpringApplication.run(OnlineShopSaasApplication.class, args);
	}
}

//	@Override
//	public void run(final String... args){
//		log.info("Datasource: " + dataSource.toString());
//		final JdbcTemplate restTemplate = new JdbcTemplate(dataSource);
//		restTemplate.execute("select 1");
//	}


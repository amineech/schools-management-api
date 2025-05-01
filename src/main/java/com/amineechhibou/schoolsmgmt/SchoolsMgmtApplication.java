package com.amineechhibou.schoolsmgmt;

// ##### AUTHOR: AMINE ECHHIBOU | 2025 #####

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SchoolsMgmtApplication {

	private static final Logger log = LoggerFactory.getLogger(SchoolsMgmtApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SchoolsMgmtApplication.class, args);
		log.info("##### Created by AMINE ECHHIBOU ! #####");
		log.info("Application running successfully !");
	}
}

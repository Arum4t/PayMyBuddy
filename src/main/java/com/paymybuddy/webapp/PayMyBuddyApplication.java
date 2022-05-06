package com.paymybuddy.webapp;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PayMyBuddyApplication implements ApplicationRunner {

	private static final Logger logger = LogManager.getLogger(PayMyBuddyApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(PayMyBuddyApplication.class, args);
	}

	@Override
	public void run (ApplicationArguments applicationArguments){
		logger.debug("Debugging log");
		logger.info("Info log");
		logger.error("Oops! We have an Error. OK");
	}

}

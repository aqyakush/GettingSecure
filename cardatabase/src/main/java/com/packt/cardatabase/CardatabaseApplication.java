package com.packt.cardatabase;

import com.packt.cardatabase.domain.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CardatabaseApplication {
	private static final Logger logger = LoggerFactory.getLogger(CardatabaseApplication.class);

	@Autowired
	private CarRepository repository;

	@Autowired
	private OwnerRepository orepository;

	@Autowired
	private UserRepository urepository;

	public static void main(String[] args) {

		SpringApplication.run(CardatabaseApplication.class, args);
		logger.info("Hello spring boot");
	}

	@Bean
	CommandLineRunner runner() {
		return args -> {
			Owner owner1 = new Owner("John", "Johnson");
			Owner owner2 = new Owner("Mary", "Robinson");
			orepository.save(owner1);
			orepository.save(owner2);
			repository.save(new Car("Ford", "Mustang", "Red", "ADF-1112", 2017, 59000, owner1));
			repository.save(new Car("Nissan", "Leaf", "White", "SSJ-3002", 2014, 290000, owner2));
			repository.save(new Car("Toyota", "Prius", "Silver", "KKO-0212", 2018, 390000, owner2));

			urepository.save(new User("user", "$2a$10$of6Ve1gmo99t4IxpmXty5.9girHJ.MNMyWvBYrUbl4GTXDoaj3qQ2", "USER"));
			urepository.save(new User("admin", "$2a$10$WkOt.MA/475gg9vPcHmvH.EKXu9z2/VNyAtZY0mLK1ainElcI3NB.", "ADMIN"));
		};
	}

}

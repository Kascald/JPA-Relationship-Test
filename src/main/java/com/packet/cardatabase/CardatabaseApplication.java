package com.packet.cardatabase;

import com.packet.cardatabase.domain.Car;
import com.packet.cardatabase.domain.Owner;
import com.packet.cardatabase.repository.CarRepository;
import com.packet.cardatabase.repository.OwnerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import java.util.Arrays;

@SpringBootApplication
public class CardatabaseApplication implements CommandLineRunner {
	private static final Logger logger = LoggerFactory.getLogger(CardatabaseApplication.class);

	@Autowired
	private CarRepository carRepository;

	@Autowired
	private OwnerRepository ownerRepository;
	public static void main(String[] args) {

		SpringApplication.run(CardatabaseApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Owner owner1 = new Owner("John" , "Johnson");
		Owner owner2 = new Owner("Mery" , "Robinson");
		ownerRepository.saveAll(Arrays.asList(owner1 , owner2));

		Car car1 = new Car("Ford" , "Mustang" , "Red" , "ADF-1121" , 2021 , 59000 , owner1);
		Car car2 = new Car("Nissan" , "Leaf" , "White" , "SSJ-3002" , 2019 , 29000 , owner2);
		Car car3 = new Car("Toyota" , "Prius" , "Silver" , "KKO-0212" , 2020 , 39000 , owner2);

		carRepository.saveAll(Arrays.asList(car1, car2, car3));

		for (Car car : carRepository.findAll()) {
			logger.info(car.getBrand() + " " + car.getModel());
		}
	}
}

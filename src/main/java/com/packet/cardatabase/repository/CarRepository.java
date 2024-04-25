package com.packet.cardatabase.repository;

import com.packet.cardatabase.domain.Car;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;


@RepositoryRestResource(path = "vehicles")
public interface CarRepository extends CrudRepository<Car,Long> {
	List<Car> findByBrand(String brand);
	List<Car> findByColor(String color);
	List<Car> findByYear(int Year);

	List<Car> findByBrandAndColor(String brand, String color);
	List<Car> findByBrandAndModel(String brand, String model);

	List<Car> findByBrandOrderByYearAsc(String brand);

//	@Query("select c from Car c where c.brand = ?1")
//	List<Car> findByBrand(String brand);
}

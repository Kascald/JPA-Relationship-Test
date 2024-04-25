package com.packet.cardatabase.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter@Setter
@NoArgsConstructor
public class Car {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String brand, model, color, registerNumber;

	private int year, price;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "owner")
	private Owner owner;


	/*
	 * 다 대 다로 바꾸기
	 * @ManytoMany(mappedBy = "cars")
	 * private Set<Owner> owners = new HashSet<Owner>();
	 *
	 * //+ getter / setter
	 * */

	public Car(String brand, String model, String color, String registerNumber, int year, int price , Owner owner) {
		super();
		this.brand = brand;
		this.model = model;
		this.color = color;
		this.registerNumber = registerNumber;
		this.year = year;
		this.price = price;
		this.owner = owner;
	}
}

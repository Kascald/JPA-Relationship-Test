package com.packet.cardatabase.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.List;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Getter @Setter
@NoArgsConstructor
public class Owner {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long ownerId;

	private String firstName, lastName;

	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "owner")
	private List<Car> cars;

	/*
	* 다 대 다 설정 !
	* @ManyToMany(cascade = CascadeType.PERSIST)
	* @JoinColumn(name="car_owner",
	*           JoinColumns = { @JoinColumn(name="ownerid") },
	*           inverseJoinColumns = { @JoinColumn(name="`id`") })
	* private Set<Car> cars = new HashSet<Car>();
	* // ++getter / setter
	*
	* */



	public Owner(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
}

package com.packet.cardatabase.repository;

import com.packet.cardatabase.domain.Owner;
import org.springframework.data.repository.CrudRepository;

public interface OwnerRepository extends CrudRepository<Owner, Long> {
}

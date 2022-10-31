package com.keyrequests.consumer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.keyrequests.consumer.model.KeyObject;

public interface KeyObjectRepository extends JpaRepository<KeyObject, Long> {

	KeyObject findById(long id);
	
}

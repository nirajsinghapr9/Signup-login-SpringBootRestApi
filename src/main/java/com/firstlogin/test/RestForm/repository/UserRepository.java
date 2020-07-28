package com.firstlogin.test.RestForm.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.firstlogin.test.RestForm.entity.NewCustomerEntity;

public interface UserRepository extends JpaRepository<NewCustomerEntity, Integer>{

	Optional<NewCustomerEntity> findByEmail(String email);
	

}

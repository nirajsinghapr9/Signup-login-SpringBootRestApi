package com.firstlogin.test.RestForm.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.firstlogin.test.RestForm.entity.NewCustomerEntity;
import com.firstlogin.test.RestForm.repository.UserRepository;
import com.firstlogin.test.RestForm.request.LogInRequest;

@Service
public class RegFormImpl implements RegForm {

	@Autowired
	private UserRepository userRepository;

	@Override
	@Transactional
	public NewCustomerEntity newReg(NewCustomerEntity theNewCustomerEntity) {
		return userRepository.save(theNewCustomerEntity);
	}

	@Override
	@Transactional
	public Optional<NewCustomerEntity> findById(Integer Id) {
		return userRepository.findById(Id);
	}

	@Override
	@Transactional
	public NewCustomerEntity logIn(LogInRequest logInRequest) {
		Optional<NewCustomerEntity> userOptional = userRepository.findByEmail(logInRequest.getEmailId());
		if (userOptional.isEmpty()) {
			throw new RuntimeException("User does not exist");
		}
		NewCustomerEntity user = userOptional.get();
		if (!logInRequest.getPassword().equals(user.getPassword())) {
			throw new RuntimeException("Incorrect Password");
		}
		return user;
	}

}

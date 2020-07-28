package com.firstlogin.test.RestForm.service;

import java.util.Optional;
import com.firstlogin.test.RestForm.entity.NewCustomerEntity;
import com.firstlogin.test.RestForm.request.LogInRequest;

public interface RegForm {

	public NewCustomerEntity newReg(NewCustomerEntity theNewCustomerEntity);
	
	public Optional<NewCustomerEntity> findById(Integer id);
	
	public NewCustomerEntity logIn(LogInRequest logInRequest);
}

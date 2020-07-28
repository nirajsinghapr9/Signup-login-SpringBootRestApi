package com.firstlogin.test.RestForm.rest;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.firstlogin.test.RestForm.entity.NewCustomerEntity;
import com.firstlogin.test.RestForm.request.LogInRequest;
import com.firstlogin.test.RestForm.service.RegForm;
@CrossOrigin
@RestController
@RequestMapping("/api")
public class NewUserRest {

	@Autowired
	private RegForm regForm;

	@PostMapping("/newuser")
	public NewCustomerEntity userRest(@RequestBody NewCustomerEntity theNewCustomerEntity) {
		theNewCustomerEntity = regForm.newReg(theNewCustomerEntity);
		return theNewCustomerEntity;
	}

	@GetMapping("/newuser/{Id}")
	public Optional<NewCustomerEntity> getUser(@PathVariable Integer Id) throws Exception {
		Optional<NewCustomerEntity> thCustomerEntity = regForm.findById(Id);
		if (thCustomerEntity == null) {
			throw new Exception("Customer id not found - " + Id);
		}

		return thCustomerEntity;
	}

	@PostMapping("/login")
	public NewCustomerEntity login(@Valid @RequestBody LogInRequest logInRequest) throws Exception {
		NewCustomerEntity theCustomerEntity = regForm.logIn(logInRequest);
		return theCustomerEntity;
	}

}

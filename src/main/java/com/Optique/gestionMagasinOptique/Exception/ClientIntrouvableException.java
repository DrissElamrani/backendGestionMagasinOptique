package com.Optique.gestionMagasinOptique.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ClientIntrouvableException extends RuntimeException {

	public ClientIntrouvableException(String s) {
		// TODO Auto-generated constructor stub
		super(s);
	}

}

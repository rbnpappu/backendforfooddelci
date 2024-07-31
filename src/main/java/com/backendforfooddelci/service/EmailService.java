package com.backendforfooddelci.service;

import com.backendforfooddelci.Entity.RegisterUser;

public interface EmailService {
	
	void sendEmail(RegisterUser user);
}

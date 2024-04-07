package com.backendforfooddelci.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.backendforfooddelci.Entity.RegisterRestrutant;
import com.backendforfooddelci.Repository.RestroRepository;

@Service
public class RestroRepoService {
	

	
	@Autowired
	private  RestroRepository service;
	
	public RegisterRestrutant save(RegisterRestrutant restro) throws IOException {
	

		
		return service.save(restro);
		
	}

	

}

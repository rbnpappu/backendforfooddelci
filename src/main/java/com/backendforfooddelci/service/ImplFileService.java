package com.backendforfooddelci.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ImplFileService implements FileService{

	String fileName = null;
	
	String filePath = null;
	
	String randomId  = UUID.randomUUID().toString();
	
	@Override
	public String uploadImage(String path, MultipartFile file) throws IOException {
		
		
			fileName = file.getOriginalFilename();
			
			filePath = path + File.separator + fileName;
			
			String fileName1 = randomId.concat(fileName.substring(fileName.lastIndexOf(".")));
			
			File f = new File(path);
			
			
			if(!f.exists()) {
				f.mkdir();
			}
		Files.copy(file.getInputStream(), Paths.get(filePath));
		
		return fileName1;
	


	
			
	}

	@Override
	public InputStream getResource(String path, String fileName) throws FileNotFoundException {
		String filePath = path+File.separator+fileName;
		
		InputStream is = new FileInputStream(filePath);
		
		return is;
	
	}}

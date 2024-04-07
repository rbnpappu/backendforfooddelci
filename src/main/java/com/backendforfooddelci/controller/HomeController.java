package com.backendforfooddelci.controller;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.http.HttpResponse;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.backendforfooddelci.Entity.FileResponse;
import com.backendforfooddelci.Entity.Menuforrestotant;
import com.backendforfooddelci.Entity.RegisterRestrutant;
import com.backendforfooddelci.Entity.RegisterUser;
import com.backendforfooddelci.messages.ResponseMessage;
import com.backendforfooddelci.service.FileService;
import com.backendforfooddelci.service.RestroRepoService;
import com.backendforfooddelci.service.SignUpService;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;

@RestController
public class HomeController {
	
private final SignUpService userService;

private final RestroRepoService restroService;



	public HomeController(SignUpService userService, RestroRepoService restroService, FileService service ) {
		this.userService = userService;
		this.restroService = restroService;
		this.service = service;

	}
	
    @PostMapping("/RegisterUser")
    public ResponseEntity<RegisterUser> signUpUser(@Valid @RequestBody RegisterUser user) {
         userService.save(user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(userService.get())
                .toUri();
        return ResponseEntity.created(location).build();
    }
    
    

    @PreAuthorize("hasAuthority('ROLE_admin')")
    @PostMapping("/RegisterRestro")
    public ResponseEntity<RegisterRestrutant> registerRestro(@Valid @RequestBody RegisterRestrutant restro) throws IOException{
    
		restroService.save(restro);
    	
	
		
		  URI location = ServletUriComponentsBuilder.fromCurrentRequest()
	                .path("/{id}")
	                .buildAndExpand(restroService)
	                .toUri();
		
		return ResponseEntity.created(location).build();
    	
    }
    

    
    @Value("${project.image}")
    String path;
    
    @Autowired
    private final FileService service;

  

    @PostMapping("/upload")
    public ResponseEntity<FileResponse> fileupload(
            @RequestParam("image") MultipartFile image) throws java.io.IOException{
        // Call the service method to handle the file upload
    	String fileName = null;
    	try {
    		fileName = service.uploadImage(path, image);
    	}
    	catch(IOException e) {
    		e.printStackTrace();
    		return new ResponseEntity<>(new FileResponse(null,"file is not uploaded in path directory"),HttpStatus.INTERNAL_SERVER_ERROR);
    	}
    	
        // You can process the response further if needed
    	return new ResponseEntity<>(new FileResponse(fileName,"file is uploaded in path directory"),HttpStatus.OK);
    }


    
    @GetMapping(value="/images/{imageName}", produces = MediaType.IMAGE_JPEG_VALUE)
    public void downloadImage(@PathVariable("imageName") String imageName, HttpServletResponse response) throws IOException {
    	InputStream resource = this.service.getResource(path, imageName);
    	response.setContentType(MediaType.IMAGE_JPEG_VALUE);
    	StreamUtils.copy(resource, response.getOutputStream());
    }

	  

}

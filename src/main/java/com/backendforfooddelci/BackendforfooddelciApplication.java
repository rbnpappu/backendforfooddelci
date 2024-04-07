package com.backendforfooddelci;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;

import com.backendforfooddelci.configuration.RsaKeyProperties;

@EnableConfigurationProperties(RsaKeyProperties.class)
@SpringBootApplication
@ComponentScan("com.backendforfooddelci")
public class BackendforfooddelciApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendforfooddelciApplication.class, args);
	}

}

package com.app.gdmg;

import com.app.gdmg.securities.RsaKeyProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(RsaKeyProperties.class)
public class GdmgApplication {

	public static void main(String[] args) {
		SpringApplication.run(GdmgApplication.class, args);
	}

}

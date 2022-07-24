package com.benny.practice.calendaractivities;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class CalendarActivitiesApplication {

	@Bean
	public PasswordEncoder passwordEncoder() {
		// This will create encrypted, secure passwords...
		// This will internally generate a random salt to generate different results for each call.
		return new BCryptPasswordEncoder();
	}

	public static void main(String[] args) {
		SpringApplication.run(CalendarActivitiesApplication.class, args);
	}

}

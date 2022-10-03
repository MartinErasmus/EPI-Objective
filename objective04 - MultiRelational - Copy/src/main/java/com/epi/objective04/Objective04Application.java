package com.epi.objective04;

import com.epi.objective04.entity.Employee;
import com.epi.objective04.entity.Home_Address;
import com.epi.objective04.entity.Job_Info;
import com.epi.objective04.repo.EmployeeRepo;
import com.epi.objective04.repo.Job_InfoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Arrays;

@SpringBootApplication
public class Objective04Application implements CommandLineRunner {

	public static void main(String[] args)  {
		SpringApplication.run(Objective04Application.class, args);
	}

	@Bean
	public CorsFilter corsFilter() {
		CorsConfiguration corsConfiguration = new CorsConfiguration();
		corsConfiguration.setAllowCredentials(true);
		corsConfiguration.setAllowedOrigins(Arrays.asList("http://localhost:4200"));
		corsConfiguration.setAllowedHeaders(Arrays.asList("Origin", "Access-Control-Allow-Origin", "Content-Type",
				"Accept", "Authorization", "Origin, Accept", "X-Requested-With",
				"Access-Control-Request-Method", "Access-Control-Request-Headers"));
		corsConfiguration.setExposedHeaders(Arrays.asList("Origin", "Content-Type", "Accept", "Authorization",
				"Access-Control-Allow-Origin", "Access-Control-Allow-Origin", "Access-Control-Allow-Credentials"));
		corsConfiguration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));
		UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
		urlBasedCorsConfigurationSource.registerCorsConfiguration("/**", corsConfiguration);
		return new CorsFilter(urlBasedCorsConfigurationSource);
	}


	public void run(String... args) throws Exception {
//		Employee employee = new Employee();
//		employee.setEmail("testingOneToOneV15@gmail.com");
//		employee.setName("testingOneToOneV15");
//
//		Job_Info job_info = new Job_Info();
//		job_info.setPosition("Guy");
//		job_info.setCurrency("R");
//		job_info.setSalary("20000");
//		employee.setJob_info(job_info);
//		job_info.setEmployee(employee);
//
//
//		Home_Address home_address = new Home_Address();
//		home_address.setHomeNumber(15);
//		home_address.setDwellingType("Place");
//		home_address.setStreetName("Fourth Rd");
//		home_address.setPoBox("1619");
//		home_address.setEmployee(employee);
//		employee.setHomeAddress_id(home_address);
//
//
//		job_info.setEmployee(employee);
//
//		employeeRepo.save(employee);
	}
}

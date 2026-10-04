package com.portal.OnlineCourseReg;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@SpringBootApplication
public class OnlineCourseRegApplication {
	public static void main(String[] args) {
		SpringApplication.run(OnlineCourseRegApplication.class, args);
		System.out.println("Backend Is running on PORT: 8081, Open URL: http://localhost:8081\n"
				+ "");
	}
}
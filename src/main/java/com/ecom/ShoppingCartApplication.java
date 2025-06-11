package com.ecom;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.ecom.model.UserDtls;
import com.ecom.repository.UserRepository;

@SpringBootApplication
public class ShoppingCartApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ShoppingCartApplication.class, args);
	}

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;


	@Override
	public void run(String... args) throws Exception {
		// Initial setup or data seeding can be done here if needed
		// For example, you can create an admin user if it doesn't exist
		UserDtls user=new UserDtls();
		user.setName("Admin");
		user.setMobileNumber("1234567890");
		user.setEmail("admin@gmail.com");
		user.setPassword(passwordEncoder.encode("admin@334"));
		user.setRole("ROLE_ADMIN");
		user.setIsEnable(true);
		user.setAccountNonLocked(true);
		user.setFailedAttempt(0);

		userRepository.save(user);
		
		// userRepository.save(user);
		// System.out.println("Admin user created with email: " + user.getEmail());

		

		

	}

}

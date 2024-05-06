package com.mustafa.security.basicautodeneme;

import com.mustafa.security.basicautodeneme.dto.CreateUserRequest;
import com.mustafa.security.basicautodeneme.model.Role;
import com.mustafa.security.basicautodeneme.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Set;

@SpringBootApplication
public class BasicAutoDenemeApplication implements CommandLineRunner {

	private final UserService userService;

	public BasicAutoDenemeApplication(UserService userService) {
		this.userService = userService;
	}

	public static void main(String[] args) {
		SpringApplication.run(BasicAutoDenemeApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		createDummyData();
	}
	private void createDummyData(){
		CreateUserRequest request = CreateUserRequest.builder()
				.name("mustafa")
				.username("musti")
				.password("pass")
				.authorities(Set.of(Role.USER))
				.build();
		userService.createUser(request);

		CreateUserRequest request2 = CreateUserRequest.builder()
				.name("ethem")
				.username("eto")
				.password("pass")
				.authorities(Set.of(Role.ADMIN))
				.build();
		userService.createUser(request2);

		CreateUserRequest request3 = CreateUserRequest.builder()
				.name("hasan")
				.username("haso")
				.password("pass")
				.authorities(Set.of(Role.FSK))
				.build();
		userService.createUser(request3);
	}
}

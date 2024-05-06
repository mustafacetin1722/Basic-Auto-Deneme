package com.mustafa.security.basicautodeneme.service;

import com.mustafa.security.basicautodeneme.model.User;
import com.mustafa.security.basicautodeneme.repository.UserRepository;
import com.mustafa.security.basicautodeneme.dto.CreateUserRequest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;
    public UserService(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }
    public Optional<User> getByUsername(String username){
        return this.userRepository.findByUsername(username);
    }
    public User createUser(CreateUserRequest request){
        User user = User.builder()
                .name(request.name())
                .username(request.username())
                .password(passwordEncoder.encode(request.password()))
                .accountNonExpired(true)
                .authorities(request.authorities())
                .credentialsNonExpired(true)
                .accountNonLocked(true)
                .build();
        return this.userRepository.save(user);

    }
}

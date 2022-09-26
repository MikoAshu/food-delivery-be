package miu.edu.cs544.userservice.service;

import lombok.RequiredArgsConstructor;
import miu.edu.cs544.userservice.dao.AppUser;
import miu.edu.cs544.userservice.exception.CustomException;
import miu.edu.cs544.userservice.repository.UserRepository;
import miu.edu.cs544.userservice.security.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.util.Date;

@Service
@RequiredArgsConstructor
public class UserService {

  private final UserRepository userRepository;
  private final PasswordEncoder passwordEncoder;
  private final JwtTokenProvider jwtTokenProvider;
  private final AuthenticationManager authenticationManager;

  Date date = new Date();
  Timestamp timestamp = new Timestamp(date.getTime());

  @Autowired
  private KafkaTemplate<Object, Object> kafkaTemplate;
  public String signin(String username, String password) {
    try {
      authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
//      this.kafkaTemplate.send("events.new", " New user signin with Username "+ username+" Accessed at "+ timestamp);
      return jwtTokenProvider.createToken(username, userRepository.findByUsername(username));
    } catch (AuthenticationException e) {
//      this.kafkaTemplate.send("events.new", " Incorrect login attempt with Username - "+ username+" Accessed at "+ timestamp);
      throw new CustomException("Invalid username/password supplied", HttpStatus.UNPROCESSABLE_ENTITY);
    }
  }

  public String signup(AppUser appUser) {
    if (!userRepository.existsByUsername(appUser.getUsername())) {
      appUser.setPassword(passwordEncoder.encode(appUser.getPassword()));
      userRepository.save(appUser);
//      this.kafkaTemplate.send("events.new", "New user signup in with Username - "+ appUser.getUsername()+" Accessed at "+ timestamp);
      this.kafkaTemplate.send("user.service.newuser", appUser.getId().toString());
      return jwtTokenProvider.createToken(appUser.getUsername(), appUser);
    } else {
      throw new CustomException("Username is already in use", HttpStatus.UNPROCESSABLE_ENTITY);
    }
  }

  public void delete(String username) {
//    this.kafkaTemplate.send("events.new", "User deleted with Username - "+ username+" Accessed at "+ timestamp);
    userRepository.deleteByUsername(username);
  }

  public AppUser search(String username) {
    AppUser appUser = userRepository.findByUsername(username);
    if (appUser == null) {
      throw new CustomException("The user doesn't exist", HttpStatus.NOT_FOUND);
    }
    return appUser;
  }

  public AppUser whoami(HttpServletRequest req) {
    return userRepository.findByUsername(jwtTokenProvider.getUsername(jwtTokenProvider.resolveToken(req)));
  }

  public String refresh(String username) {
    return jwtTokenProvider.createToken(username, userRepository.findByUsername(username));
  }

}

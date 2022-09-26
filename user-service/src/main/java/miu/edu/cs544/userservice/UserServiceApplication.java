package miu.edu.cs544.userservice;

import lombok.RequiredArgsConstructor;
import miu.edu.cs544.userservice.dao.AppUser;
import miu.edu.cs544.userservice.dao.AppUserRole;
import miu.edu.cs544.userservice.service.UserService;
import org.apache.kafka.clients.admin.NewTopic;
import org.modelmapper.ModelMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.annotation.EnableKafka;

import java.util.ArrayList;
import java.util.Arrays;

@SpringBootApplication
@RequiredArgsConstructor
//@EnableKafka
public class UserServiceApplication {
    final UserService userService;
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Bean
    public NewTopic topic() {
        return new NewTopic("events.new", 10, (short) 1);
    }

//    @Bean
//    public NewTopic topicCart() {
//        return new NewTopic("user.service.newuser", 10, (short) 1);
//    }
    public static void main(String[] args) {
        SpringApplication.run(UserServiceApplication.class, args);
    }

//    @Override
//    public void run(String... params) throws Exception {
//        AppUser admin = new AppUser();
//        admin.setUsername("admin");
//        admin.setPassword("admin");
//        admin.setEmail("admin@email.com");
//        admin.setAppUserRoles(new ArrayList<AppUserRole>(Arrays.asList(AppUserRole.ROLE_ADMIN)));
//
//        userService.signup(admin);
//
//        AppUser client = new AppUser();
//        client.setUsername("client");
//        client.setPassword("client");
//        client.setEmail("client@email.com");
//        client.setAppUserRoles(new ArrayList<AppUserRole>(Arrays.asList(AppUserRole.ROLE_CLIENT)));
//
//        userService.signup(client);
//    }

}


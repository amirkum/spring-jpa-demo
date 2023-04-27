package com.example.jpademo;

import com.example.jpademo.entity.AccountEntity;
import com.example.jpademo.entity.UserEntity;
import com.example.jpademo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.UUID;

@SpringBootApplication
public class JpaDemoApplication implements ApplicationRunner {
	@Autowired
	private UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(JpaDemoApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
//		UserEntity admin = new UserEntity("Amir", "Kumalov", "amirkum88@gmail.com");
//		for (int i = 0; i < 3; i++) {
//			admin.getAccounts().add(new AccountEntity(admin, UUID.randomUUID().toString()));
//		}
//		userRepository.save(admin);
//
//		UserEntity user = new UserEntity("Will", "Rock", "amirkum@yandex.ru");
//		for (int i = 0; i < 5; i++) {
//			user.getAccounts().add(new AccountEntity(user, UUID.randomUUID().toString()));
//		}
//		userRepository.save(user);
		UserEntity user;
		user = new UserEntity("Amir", "Kumalov", "amirkum88@gmail.com");
		user.getAccounts().add(new AccountEntity(user, "212000014160"));
		user.getAccounts().add(new AccountEntity(user, "111000047459"));
		userRepository.save(user);

//		user = new UserEntity("Will", "Rock", "amirkum@yandex.ru");
//		user.getAccounts().add(new AccountEntity(user, "111000047459"));
//		user.getAccounts().add(new AccountEntity(user, "111000047459"));
//		user.getAccounts().add(new AccountEntity(user, "111000047459"));
//		user.getAccounts().add(new AccountEntity(user, "212000014160"));
		userRepository.save(user);
	}
}

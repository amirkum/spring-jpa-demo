package com.example.jpademo.repository;

import com.example.jpademo.entity.UserEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@Transactional(readOnly = true)
class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;

    @Test
    void findByEmail() {
        Optional<UserEntity> user;

        user = userRepository.findByEmail("amirkum@yandex.ru");
        assertTrue(user.isPresent());
        assertEquals(5, user.get().getAccounts().size());

        user = userRepository.findByEmail("amirkum88@gmail.com");
        assertTrue(user.isPresent());
        assertEquals(3, user.get().getAccounts().size());
    }

    @Test
    void findAllByUuid() {
        List<UserEntity> users;
        users = userRepository.findAllByUuid("212000014160");
        assertEquals("212000014160", users.get(0).getAccounts().get(0).getUuid());

        users = userRepository.findAllByUuid("111000047459");
        assertEquals("111000047459", users.get(0).getAccounts().get(0).getUuid());
    }

    @Test
    void findByEmailAndUuid() {
        Optional<UserEntity> user;

        user = userRepository.findByEmailAndUuid("amirkum88@gmail.com", "111000047459");
        assertTrue(user.isPresent());
        assertEquals("111000047459", user.get().getAccounts().get(0).getUuid());

        user = userRepository.findByEmailAndUuid("amirkum88@gmail.com", "212000014160");
        assertTrue(user.isPresent());
        assertEquals("212000014160", user.get().getAccounts().get(0).getUuid());
    }
}

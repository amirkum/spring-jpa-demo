package com.example.jpademo.repository;

import com.example.jpademo.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    @Query("select u from User u left join fetch u.accounts where u.email = :email")
    Optional<UserEntity> findByEmail(String email);
    @Query("select distinct u from User u left join fetch u.accounts a where a.uuid = :uuid")
    List<UserEntity> findAllByUuid(String uuid);

    @Query("select u from User u left join fetch u.accounts a where u.email = :email and a.uuid = :uuid")
    Optional<UserEntity> findByEmailAndUuid(String email, String uuid);
}

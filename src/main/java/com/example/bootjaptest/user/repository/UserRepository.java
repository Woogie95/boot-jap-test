package com.example.bootjaptest.user.repository;

import com.example.bootjaptest.user.entity.UserEntity;
import com.example.bootjaptest.user.model.UserStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    long countByEmail(String email);

    Optional<UserEntity> findByIdAndPassword(Long id, String password);

    Optional<UserEntity> findByUsernameAndPhoneNumber(String username, String phoneNumber);

    Optional<UserEntity> findByEmail(String email);

    List<UserEntity> findByEmailContainsOrUsernameContainsOrPhoneNumberContains(
            String email, String username, String phoneNumber);

    long countByUserStatus(UserStatus userStatus);
}

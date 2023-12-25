package com.arianit.CityGuideKosovo.repository;

import com.arianit.CityGuideKosovo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Modifying
    @Query("UPDATE User u SET u.password = :password WHERE u.userId = :userId")
    int updatePassword(@Param("userId") Long userId, @Param("password") String password);

    @Modifying
    @Query("UPDATE User u SET u.email = :email WHERE u.userId = :userId")
    int updateEmail(@Param("userId") Long userId, @Param("email") String email);

    boolean existsByEmailIgnoreCase(String email);
    Optional<User> findByEmail(String email);
}

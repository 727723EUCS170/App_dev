package com.example.giftapp.repository;

import com.example.giftapp.model.Provider;
import com.example.giftapp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProviderRepository extends JpaRepository<Provider, Long> {
    Optional<Provider> findByUser(User user);
    
    Optional<Provider> findByUserId(Long userId);
}

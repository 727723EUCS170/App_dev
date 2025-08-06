package com.example.giftapp.repository;

import com.example.giftapp.model.Application;
import com.example.giftapp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApplicationRepository extends JpaRepository<Application, Long> {
    List<Application> findByApplicant(User applicant);
    
    List<Application> findByStatus(Application.Status status);
    
    @Query("SELECT a FROM Application a WHERE a.applicant.id = :applicantId")
    List<Application> findByApplicantId(@Param("applicantId") Long applicantId);
}

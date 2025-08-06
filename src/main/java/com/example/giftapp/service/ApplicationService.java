package com.example.giftapp.service;

import com.example.giftapp.model.Application;
import com.example.giftapp.model.User;
import com.example.giftapp.repository.ApplicationRepository;
import com.example.giftapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApplicationService {

    @Autowired
    private ApplicationRepository applicationRepository;

    @Autowired
    private UserRepository userRepository;

    public List<Application> findAll() {
        return applicationRepository.findAll();
    }

    public List<Application> findByApplicant(User applicant) {
        return applicationRepository.findByApplicant(applicant);
    }

    public Application save(Application application) {
        return applicationRepository.save(application);
    }

    public List<Application> findByStatus(Application.Status status) {
        return applicationRepository.findByStatus(status);
    }
}

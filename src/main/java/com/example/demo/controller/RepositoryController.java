package com.example.demo.controller;

import com.example.demo.model.Repository;
import com.example.demo.repository.IRepositoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.util.List;

@RestController
@RequestMapping("/repositories")
@RequiredArgsConstructor
public class RepositoryController {

    private final IRepositoryRepository repositoryRepository;

    @GetMapping
    public List<Repository> findAllRepositories() {
        return repositoryRepository.findAll();
    }
}


package com.example.demo.repository;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.demo.model.PullRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IPullRequestRepository
        extends JpaRepository<PullRequest, Long> {

    // CONSULTA 1: 
    List<PullRequest>
    findByRepository_Assignment_Classroom_NameAndStatusOrderByCreatedAtDesc(
            String classroomName,
            String status
    );

    // CONSULTA 3:
    
    List<PullRequest>
    findByAuthor_RoleAndAuthor_UsernameAndRepository_Assignment_Classroom_Semester(
            String role,
            String username,
            String semester
    );

    

}



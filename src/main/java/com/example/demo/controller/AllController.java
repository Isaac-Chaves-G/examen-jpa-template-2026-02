package com.example.demo.controller;

import com.example.demo.model.Assignment;
import com.example.demo.model.Commit;
import com.example.demo.model.PullRequest;
import com.example.demo.model.Repository;
import com.example.demo.repository.IAssignmentRepository;
import com.example.demo.repository.ICommitRepository;
import com.example.demo.repository.IPullRequestRepository;
import com.example.demo.repository.IRepositoryRepository;

import lombok.RequiredArgsConstructor;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/queries")
@RequiredArgsConstructor
public class AllController {

    private final IPullRequestRepository pullRequestRepository;
    private final IRepositoryRepository repositoryRepository;
    private final ICommitRepository commitRepository;
    private final IAssignmentRepository assignmentRepository;

    // CONSULTA 1
    @GetMapping("/1")
    public List<PullRequest> findPullRequestsByClassroomAndStatus(
            @RequestParam("classroomName") String classroomName,
            @RequestParam("status") String status
    ) {
        return pullRequestRepository
                .findByRepository_Assignment_Classroom_NameAndStatusOrderByCreatedAtDesc(
                        classroomName,
                        status
                );
    }

    // CONSULTA 2
    @GetMapping("/2")
    public List<Repository> findDerivedRepositories(
            @RequestParam("email") String email,
            @RequestParam("deadline")
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
            LocalDateTime deadline
    ) {
        return repositoryRepository
                .findByParentRepoIsNotNullAndAssignment_Classroom_Teacher_EmailAndAssignment_DeadlineAfter(
                        email,
                        Timestamp.valueOf(deadline)
                );
    }

    // cONSUTA 3
    @GetMapping("/3")
    public List<PullRequest> findPullRequestsByRoleAuthorAndSemester(
            @RequestParam("role") String role,
            @RequestParam("username") String username,
            @RequestParam("semester") String semester
    ) {
        return pullRequestRepository
                .findByAuthor_RoleAndAuthor_UsernameAndRepository_Assignment_Classroom_Semester(
                        role,
                        username,
                        semester
                );
    }

}
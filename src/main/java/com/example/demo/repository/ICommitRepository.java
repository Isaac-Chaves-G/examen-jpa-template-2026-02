package com.example.demo.repository;

import com.example.demo.model.Commit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ICommitRepository
        extends JpaRepository<Commit, Long> {

    // CONSULTA 4
    List<Commit>
    findByRepository_ParentRepo_NameAndMessageContainingIgnoreCaseAndLinesAddedLessThan(
            String templateName,
            String keyword,
            Integer linesAdded
    );
}
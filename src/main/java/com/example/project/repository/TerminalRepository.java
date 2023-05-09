package com.example.project.repository;

import com.example.project.model.Department;
import com.example.project.model.Terminal;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TerminalRepository extends JpaRepository<Terminal, Long> {

    @Query("SELECT t FROM Department d JOIN d.terminalList t WHERE t.isActive = true AND t.terminalName = :terminalName")
    Page<Terminal> findByActiveTerminalsAndTerminalName(@Param("terminalName") String terminalName, Pageable pageable);

    @Query("SELECT t FROM Department d JOIN d.terminalList t WHERE t.isActive = true")
    Page<Terminal> findAllByActiveTerminals(Pageable pageable);
}

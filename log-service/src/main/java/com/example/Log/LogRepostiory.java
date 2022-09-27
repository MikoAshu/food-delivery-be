package com.example.Log;

import org.springframework.data.jpa.repository.JpaRepository;


public interface LogRepostiory extends JpaRepository<LogTable, Long> {
}

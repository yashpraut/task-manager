package com.franchiseworld.taskmanager.repos;

import com.franchiseworld.taskmanager.model.Log;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogRepository extends JpaRepository<Log, Long> {
}


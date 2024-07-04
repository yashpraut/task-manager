package com.franchiseworld.taskmanager.repos;

import com.franchiseworld.taskmanager.model.Tasks;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepo extends JpaRepository<Tasks,Integer> {
}

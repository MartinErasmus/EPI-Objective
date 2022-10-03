package com.epi.objective04.repo;

import com.epi.objective04.entity.Job_Info;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Job_InfoRepo extends JpaRepository<Job_Info,Long> {
}

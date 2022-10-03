package com.epi.objective04.repo;

import com.epi.objective04.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee,Long> {

    public boolean existsByEmail(String email);
    public List<Employee> findByEmail(String email);



    @Query("select max(e.id) From Employee e")
    public  Integer findMaxId();

}

package com.epi.objective04.repo;

import com.epi.objective04.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee,Long> {

    public boolean existsByEmail(String email);
    public List<Employee> findByEmail(String email);


    @Query("select max(e.id) From Employee e")
    public  Integer findMaxId();

    @Query("select e.id From Employee e WHERE e.id_number= :id_num")
    public  Integer findupdateId(@Param("id_num") String id_num);

    @Query("select Count(e.id) From Employee e WHERE e.id_number= :id_num")
    public  Integer doesEmployeeExist(@Param("id_num") String id_num);

}

package com.epi.objective04.repo;

import com.epi.objective04.entity.Home_Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HomeAddressRepo extends JpaRepository<Home_Address,Long> {
}

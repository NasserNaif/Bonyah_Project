package com.example.bonyah.Repository;

import com.example.bonyah.Models.Service;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceRepo extends JpaRepository<Service,Integer> {
    Service findServiceById(Integer id);


}

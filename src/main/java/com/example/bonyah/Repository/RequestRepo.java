package com.example.bonyah.Repository;

import com.example.bonyah.Models.Request;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RequestRepo extends JpaRepository<Request,Integer> {
    Request findRequestById(Integer id);
}

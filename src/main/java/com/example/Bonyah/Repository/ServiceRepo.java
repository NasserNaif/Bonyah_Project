package com.example.Bonyah.Repository;

import com.example.Bonyah.Models.Service;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ServiceRepo extends JpaRepository<Service,Integer> {
    Service findServiceById(Integer id);
    List<Service>findServicesByCategory(String category);
    List<Service>findServicesByPrice(Integer price);

    List<Service>findServicesByCategoryAndPrice(String category,Integer price);




}
package com.example.demo.Repository;

import com.example.demo.models.Temperature;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TemperatureRepository extends JpaRepository<Temperature, Long> {
}

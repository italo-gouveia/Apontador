package com.apontador.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.apontador.data.model.Location;

@Repository
public interface LocationRepository extends JpaRepository<Location, Long> {
    @Query("SELECT l FROM Location l WHERE l.name LIKE LOWER(CONCAT ('%', :name, '%'))")
    Page<Location> findLocationByName(@Param("name") String name, Pageable pageable);
}
package org.example.camp.repository;


import org.example.camp.domain.entities.CampEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CampRepository extends JpaRepository<CampEntity,Integer> {
}

package com.recycling.model.repository;

import com.recycling.model.Lga;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface LgaRepository extends JpaRepository<Lga,String> {




}

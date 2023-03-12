package com.recycling.model.repository;

import com.recycling.model.Lga;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface LgaRepository extends JpaRepository<Lga,String> {

    @Transactional
    @Query(value = "select l.lga_name,l.recycle_bin,l.rubbish_bin FROM Lga l WHERE l.lga_pid = 'VIC251'")
    List<Lga> SearchLga ();


}

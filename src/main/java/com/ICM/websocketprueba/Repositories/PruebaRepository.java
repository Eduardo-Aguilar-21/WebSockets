package com.ICM.websocketprueba.Repositories;

import com.ICM.websocketprueba.Models.PruebaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PruebaRepository extends JpaRepository<PruebaModel, Long> {
}

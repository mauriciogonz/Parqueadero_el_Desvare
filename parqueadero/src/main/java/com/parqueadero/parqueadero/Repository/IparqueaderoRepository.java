package com.parqueadero.parqueadero.Repository;

import com.parqueadero.parqueadero.entity.parqueadero;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IparqueaderoRepository
  extends JpaRepository<parqueadero, Long> {
  @Query("FROM parqueadero p WHERE p.num_parq = num")
  List<parqueadero> numeParqueadero(@Param("num") int num);

  @Query("FROM parqueadero p ORDER BY num_parq ASC")
  public List<parqueadero> ordenar();
}

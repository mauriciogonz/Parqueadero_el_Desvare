package com.parqueadero.parqueadero.Repository;

import com.parqueadero.parqueadero.entity.historial;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IhistorialtRepository extends JpaRepository<historial, Long> {
  @Query("FROM vehiculo v WHERE v.placa_vehiculo LIKE :placa")
  public List<historial> busquedaPorPlaca(@Param("placa") String placa);

  @Query("FROM historial h ORDER BY placa_vehiculo ASC")
  public List<historial> ordenarhistorial();
}

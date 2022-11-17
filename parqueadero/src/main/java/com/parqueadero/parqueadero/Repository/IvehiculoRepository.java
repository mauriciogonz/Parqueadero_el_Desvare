package com.parqueadero.parqueadero.Repository;

import com.parqueadero.parqueadero.entity.vehiculo;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IvehiculoRepository extends JpaRepository<vehiculo, Long> {
  @Query("FROM vehiculo v WHERE v.placa_vehiculo LIKE :placa")
  public List<vehiculo> busquedaPorPlaca(@Param("placa") String placa);

  @Query("FROM vehiculo v ORDER BY placa_vehiculo ASC")
  public List<vehiculo> ordenarVehiculos();
}

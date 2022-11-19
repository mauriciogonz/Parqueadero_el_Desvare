package com.parqueadero.parqueadero.Repository;

import com.parqueadero.parqueadero.entity.historial;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IhistorialtRepository extends JpaRepository<historial, Long> {
  /*@Query("FROM vehiculo v WHERE v.placa_vehiculo LIKE :placa")
  public List<historial> busquedaPorPlaca(@Param("placa") String placa);*/

  @Query(
    "SELECT v FROM historial v  WHERE " +
    " CONCAT(v.id, v.placa_vehiculo,v.tipo_vehiculo, v.valor_cancelado,v.fecha_salida)" +
    " LIKE %?1%"
  )
  public List<historial> busquedaPorPlaca(String filtro);

  @Query("FROM historial h ORDER BY fecha_salida ASC")
  public List<historial> ordenarhistorial();
}

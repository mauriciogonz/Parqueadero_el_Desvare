package com.parqueadero.parqueadero.service;

import com.parqueadero.parqueadero.entity.historial;
import java.util.List;

public interface IhistorialService {
  List<historial> getAllHistorial();

  List<historial> getHistorialByName(String placa_vehiculo);

  historial saveHistorial(historial historial);

  historial getHistorialById(Long id);

  historial updateVehiculo(historial historial);

  void deletehisotrialById(Long id);
}

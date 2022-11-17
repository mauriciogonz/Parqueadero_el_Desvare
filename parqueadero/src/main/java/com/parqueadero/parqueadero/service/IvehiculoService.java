package com.parqueadero.parqueadero.service;

import com.parqueadero.parqueadero.entity.vehiculo;
import java.util.List;

public interface IvehiculoService {
  List<vehiculo> getAllVehiculos();
  List<vehiculo> getVehiculoByName(String placa_vehiculo);
  vehiculo saveVehiculo(vehiculo vehiculo);
  vehiculo getVehiculoById(Long id);
  vehiculo updateVehiculo(vehiculo vehiculo);
  void deleteVehiculoById(Long id);
}

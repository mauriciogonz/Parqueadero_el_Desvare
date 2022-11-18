package com.parqueadero.parqueadero.service;

import com.parqueadero.parqueadero.Repository.IvehiculoRepository;
import com.parqueadero.parqueadero.entity.vehiculo;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class vehiculoService implements IvehiculoService {
  private IvehiculoRepository vehiculoRepository;

  public vehiculoService(IvehiculoRepository vehiculoRepository) {
    this.vehiculoRepository = vehiculoRepository;
  }

  @Override
  public List<vehiculo> getAllVehiculos() {
    return vehiculoRepository.ordenarVehiculos();
  }

  @Override
  public List<vehiculo> getVehiculoByName(String placa_vehiculo) {
    return vehiculoRepository.busquedaPorPlaca(placa_vehiculo);
  }

  @Override
  public vehiculo saveVehiculo(vehiculo vehiculo) {
    return vehiculoRepository.save(vehiculo);
  }

  @Override
  public vehiculo getVehiculoById(Long id) {
    return vehiculoRepository.findById(id).get();
  }

  @Override
  public vehiculo updateVehiculo(vehiculo vehiculo) {
    return vehiculoRepository.save(vehiculo);
  }

  @Override
  public void deleteVehiculoById(Long id) {
    vehiculoRepository.deleteById(id);
  }
}

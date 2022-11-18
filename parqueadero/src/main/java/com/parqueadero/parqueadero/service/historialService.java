package com.parqueadero.parqueadero.service;

import com.parqueadero.parqueadero.Repository.IhistorialtRepository;
import com.parqueadero.parqueadero.entity.historial;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class historialService implements IhistorialService {
  private IhistorialtRepository historialRepository;

  public historialService(IhistorialtRepository hisotrialRepository) {
    this.historialRepository = hisotrialRepository;
  }

  @Override
  public List<historial> getAllHistorial() {
    return historialRepository.ordenarhistorial();
  }

  @Override
  public List<historial> getHistorialByName(String placa_vehiculo) {
    return historialRepository.busquedaPorPlaca(placa_vehiculo);
  }

  @Override
  public historial saveHistorial(historial historial) {
    return historialRepository.save(historial);
  }

  @Override
  public historial getHistorialById(Long id) {
    return historialRepository.findById(id).get();
  }

  @Override
  public historial updateVehiculo(historial historial) {
    return historialRepository.save(historial);
  }

  @Override
  public void deletehisotrialById(Long id) {
    historialRepository.deleteById(id);
  }
}

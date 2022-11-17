package com.parqueadero.parqueadero.service;

import com.parqueadero.parqueadero.entity.parqueadero;
import java.util.List;

public interface IparqueaderoService {
  List<parqueadero> getAllParqueaderos();

  List<parqueadero> getParqueaderoByName(int num_parq);

  parqueadero saveParqueadero(parqueadero parqueadero);

  parqueadero getParqueaderoById(Long id);

  parqueadero updateParqueadero(parqueadero parqueadero);

  void deleteParqueaderoById(Long id);
}

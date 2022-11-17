package com.parqueadero.parqueadero.service;

import com.parqueadero.parqueadero.Repository.IparqueaderoRepository;
import com.parqueadero.parqueadero.entity.parqueadero;
import java.util.List;

public class parqueaderoService implements IparqueaderoService {
  private IparqueaderoRepository parqueaderoRepository;

  public parqueaderoService(IparqueaderoRepository parqueaderoRepository) {
    this.parqueaderoRepository = parqueaderoRepository;
  }

  @Override
  public List<parqueadero> getAllParqueaderos() {
    return parqueaderoRepository.ordenar();
  }

  @Override
  public List<parqueadero> getParqueaderoByName(int num_parq) {
    return parqueaderoRepository.numeParqueadero(num_parq);
  }

  @Override
  public parqueadero saveParqueadero(parqueadero parqueadero) {
    return parqueaderoRepository.save(parqueadero);
  }

  @Override
  public parqueadero getParqueaderoById(Long id) {
    return parqueaderoRepository.getReferenceById(id);
  }

  @Override
  public parqueadero updateParqueadero(parqueadero parqueadero) {
    return parqueaderoRepository.save(parqueadero);
  }

  @Override
  public void deleteParqueaderoById(Long id) {
    parqueaderoRepository.deleteById(id);
  }
}

package com.parqueadero.parqueadero.entity;

import java.io.Serializable;
//import java.util.*;
import javax.persistence.*;

@Entity
@Table(name = "historial")
public class historial implements Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "placa_vehiculo", nullable = false)
  private String placa_vehiculo;

  @Column(name = "tipo_vehiculo", nullable = false)
  private String tipo_vehiculo;

  @Column(name = "valor_cancelado")
  private int valor_cancelado;

  @OneToOne
  private vehiculo vehiculo;

  public historial() {}

  public historial(
    String placa_vehiculo,
    String tipo_vehiculo,
    int valor_cancelado,
    com.parqueadero.parqueadero.entity.vehiculo vehiculo
  ) {
    this.placa_vehiculo = placa_vehiculo;
    this.tipo_vehiculo = tipo_vehiculo;
    this.valor_cancelado = valor_cancelado;
    this.vehiculo = vehiculo;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getPlaca_vehiculo() {
    return placa_vehiculo;
  }

  public void setPlaca_vehiculo(String placa_vehiculo) {
    this.placa_vehiculo = placa_vehiculo;
  }

  public String getTipo_vehiculo() {
    return tipo_vehiculo;
  }

  public void setTipo_vehiculo(String tipo_vehiculo) {
    this.tipo_vehiculo = tipo_vehiculo;
  }

  public int getValor_cancelado() {
    return valor_cancelado;
  }

  public void setValor_cancelado(int valor_cancelado) {
    this.valor_cancelado = valor_cancelado;
  }

  public vehiculo getVehiculo() {
    return vehiculo;
  }

  public void setVehiculo(vehiculo vehiculo) {
    this.vehiculo = vehiculo;
  }

  @Override
  public String toString() {
    return (
      "historial [placa_vehiculo=" +
      placa_vehiculo +
      ", tipo_vehiculo=" +
      tipo_vehiculo +
      ", valor_cancelado=" +
      valor_cancelado +
      ", vehiculo=" +
      vehiculo +
      "]"
    );
  }
}

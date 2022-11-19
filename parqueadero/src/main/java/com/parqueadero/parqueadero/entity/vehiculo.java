package com.parqueadero.parqueadero.entity;

import java.io.Serializable;
import java.sql.Time;
import java.time.LocalDate;
import javax.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "vehiculo")
public class vehiculo implements Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "tipo_vehiculo", nullable = true)
  private String tipo_vehiculo;

  @Column(name = "placa_vehiculo", nullable = false)
  private String placa_vehiculo;

  @Column(name = "fecha_ingreso", nullable = true)
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private LocalDate fecha_ingreso;

  @Column(name = "hora_ingreso", nullable = true)
  private Time hora_ingreso;

  @Column(name = "fecha_salida", nullable = true)
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private LocalDate fecha_salida;

  @Column(name = "hora_salida", nullable = true)
  private Time hora_salida;

  @Column(name = "valor_pagar", nullable = true)
  private int valor_pagar;

  @OneToOne
  private parqueadero parqueadero;

  //private Set<parqueadero> parqueaderos = new HashSet<>();

  public vehiculo() {}

  public vehiculo(
    String tipo_vehiculo,
    String placa_vehiculo,
    LocalDate fecha_ingreso,
    Time hora_ingreso,
    LocalDate fecha_salida,
    Time hora_salida,
    int valor_pagar
  ) {
    this.tipo_vehiculo = tipo_vehiculo;
    this.placa_vehiculo = placa_vehiculo;
    this.fecha_ingreso = fecha_ingreso;
    this.hora_ingreso = hora_ingreso;
    this.fecha_salida = fecha_salida;
    this.hora_salida = hora_salida;
    this.valor_pagar = valor_pagar;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getTipo_vehiculo() {
    return tipo_vehiculo;
  }

  public void setTipo_vehiculo(String tipo_vehiculo) {
    this.tipo_vehiculo = tipo_vehiculo;
  }

  public String getPlaca_vehiculo() {
    return placa_vehiculo;
  }

  public void setPlaca_vehiculo(String placa_vehiculo) {
    this.placa_vehiculo = placa_vehiculo;
  }

  public LocalDate getFecha_ingreso() {
    return fecha_ingreso;
  }

  public void setFecha_ingreso(LocalDate fecha_ingreso) {
    this.fecha_ingreso = fecha_ingreso;
  }

  public Time getHora_ingreso() {
    return hora_ingreso;
  }

  public void setHora_ingreso(Time hora_ingreso) {
    this.hora_ingreso = hora_ingreso;
  }

  public LocalDate getFecha_salida() {
    return fecha_salida;
  }

  public void setFecha_salida(LocalDate fecha_salida) {
    this.fecha_salida = fecha_salida;
  }

  public Time getHora_salida() {
    return hora_salida;
  }

  public void setHora_salida(Time hora_salida) {
    this.hora_salida = hora_salida;
  }

  public int getValor_pagar() {
    return valor_pagar;
  }

  public void setValor_pagar(int valor_pagar) {
    this.valor_pagar = valor_pagar;
  }
  /*  public Set<parqueadero> getParqueaderos() {
    return parqueaderos;
  }

  public void setParqueaderos(Set<parqueadero> parqueaderos) {
    this.parqueaderos = parqueaderos;
  }*/
}

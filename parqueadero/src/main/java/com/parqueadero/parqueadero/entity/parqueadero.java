package com.parqueadero.parqueadero.entity;

import java.io.Serializable;
import java.util.*;
import javax.persistence.*;

@Entity
@Table(name = "parqueadero")
public class parqueadero implements Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "num_parq")
  private int num_parq;

  @OneToOne
  private vehiculo vehiculo;

  //private Set<vehiculo> vehiculos = new HashSet<>();

  public parqueadero() {}

  public parqueadero(int num_parq) {
    this.num_parq = num_parq;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public int getNum_parq() {
    return num_parq;
  }

  public void setNum_parq(int num_parq) {
    this.num_parq = num_parq;
  }

  /*public Set<vehiculo> getVehiculos() {
    return vehiculos;
  }

  public void setVehiculos(Set<vehiculo> vehiculos) {
    this.vehiculos = vehiculos;
  }*/

  @Override
  public int hashCode() {
    int hash = 7;
    hash = 83 * hash + Objects.hashCode(this.id);
    hash = 83 * hash + Objects.hashCode(this.num_parq);
    return hash;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    final parqueadero other = (parqueadero) obj;
    if (!Objects.equals(this.num_parq, other.num_parq)) {
      return false;
    }
    if (!Objects.equals(this.id, other.id)) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "parqueadero [num_parq=" + num_parq + "]";
  }
}

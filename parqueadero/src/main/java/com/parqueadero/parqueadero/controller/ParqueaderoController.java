package com.parqueadero.parqueadero.controller;

import com.parqueadero.parqueadero.Repository.IparqueaderoRepository;
import com.parqueadero.parqueadero.entity.parqueadero;
import com.parqueadero.parqueadero.entity.vehiculo;
import com.parqueadero.parqueadero.service.historialService;
import com.parqueadero.parqueadero.service.vehiculoService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ParqueaderoController {
  @Autowired
  private vehiculoService vehiculoService;

  @Autowired
  private historialService historialService;

  @Autowired
  private IparqueaderoRepository parqueaderoRepository;

  private List<parqueadero> parqueaderosList = new ArrayList<>();

  public ParqueaderoController(
    vehiculoService vehiculoService,
    historialService historialService,
    IparqueaderoRepository parqueaderoRepository
  ) {
    this.vehiculoService = vehiculoService;
    this.historialService = historialService;
    this.parqueaderoRepository = parqueaderoRepository;
    this.parqueaderosList = this.parqueaderoRepository.ordenar();
  }

  @GetMapping("/mostrar")
  public String mostrar(Model model) {
    model.addAttribute("mostrar_vehiculos", vehiculoService.getAllVehiculos());
    return "mostrar_vehiculos";
  }

  @GetMapping("/mostrar/registrar")
  public String registrarVehiculoFrom(Model model) {
    // este objeto Student almacenara los valores
    vehiculo vehiculo = new vehiculo();
    model.addAttribute("vehiculo", vehiculo);
    model.addAttribute("parqueaderosList", parqueaderosList);
    return "registro";
  }

  @PostMapping("/mostrar")
  public String saveVehiculo(@ModelAttribute("vehiculo") vehiculo vehiculo) {
    vehiculoService.saveVehiculo(vehiculo);
    return "redirect:/mostrar";
  }

  @GetMapping("/mostrar/salida/{id}")
  public String salidaVehiculoForm(@PathVariable Long id, Model model) {
    vehiculo vh = vehiculoService.getVehiculoById(id);
    model.addAttribute("vehiculo", vh);
    model.addAttribute("parqueaderosList", parqueaderosList);
    return "salida";
  }

  @PostMapping("/mostrar/{id}")
  public String updateVehiculo(
    @PathVariable Long id,
    @ModelAttribute("vehiculo") vehiculo vehiculo,
    Model model
  ) {
    //sacar el vehiculo de la b.d. por el id
    vehiculo existentvehiculo = vehiculoService.getVehiculoById(id);
    // cargarlo
    existentvehiculo.setId(id);
    existentvehiculo.setTipo_vehiculo(vehiculo.getTipo_vehiculo());
    existentvehiculo.setPlaca_vehiculo(vehiculo.getPlaca_vehiculo());
    existentvehiculo.setFecha_ingreso(vehiculo.getFecha_ingreso());
    existentvehiculo.setHora_ingreso(vehiculo.getHora_ingreso());
    existentvehiculo.setFecha_salida(vehiculo.getFecha_salida());
    existentvehiculo.setHora_salida(vehiculo.getHora_salida());

    vehiculoService.updateVehiculo(existentvehiculo);
    return "redirect:/mostrar";
  }

  @GetMapping("/mostrar/{id}")
  public String deleteVehiculo(@PathVariable Long id) {
    vehiculoService.deleteVehiculoById(id);
    return "redirect:/mostrar";
  }

  @RequestMapping("/")
  public String principal() {
    return "home";
  }

  @RequestMapping("/login")
  public String login() {
    return "login";
  }

  @RequestMapping("/nosotros")
  public String nosotros() {
    return "nosotros";
  }

  @RequestMapping("/contact")
  public String contact() {
    return "contact";
  }

  @RequestMapping("/pagos")
  public String pagos() {
    return "pagos";
  }
}

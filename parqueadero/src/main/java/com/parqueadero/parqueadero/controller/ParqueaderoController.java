package com.parqueadero.parqueadero.controller;

import aj.org.objectweb.asm.Attribute;
import com.parqueadero.parqueadero.Repository.IparqueaderoRepository;
import com.parqueadero.parqueadero.entity.historial;
import com.parqueadero.parqueadero.entity.parqueadero;
import com.parqueadero.parqueadero.entity.vehiculo;
import com.parqueadero.parqueadero.service.historialService;
import com.parqueadero.parqueadero.service.vehiculoService;
import java.util.ArrayList;
import java.util.List;
import javax.management.AttributeValueExp;
import javax.swing.JOptionPane;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
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

  @GetMapping("/historial")
  public String historial(Model model, @Param("filtro") String filtro) {
    model.addAttribute("historial", historialService.getAllHistorial(filtro));
    model.addAttribute("filtro", filtro);
    return "historial";
  }

  @GetMapping("/mostrar")
  public String mostrar(Model model) {
    model.addAttribute("vehiculo", vehiculoService.getAllVehiculos());
    return "mostrar_vehiculos";
  }

  public void saveHistorial(vehiculo historial) {
    historial recuerdo = new historial();
    recuerdo.setPlaca_vehiculo(historial.getPlaca_vehiculo());
    recuerdo.setTipo_vehiculo(historial.getTipo_vehiculo());
    recuerdo.setValor_cancelado(historial.getValor_pagar());
    recuerdo.setFecha_salida(historial.getFecha_salida());
    historialService.saveHistorial(recuerdo);
  }

  public void restaHora(int hola) {
    JOptionPane.showInputDialog(null, "hola");
  }

  @GetMapping("/mostrar/registrar")
  public String registrarVehiculoFrom(Model model) {
    // este objeto Student almacenara los valores
    vehiculo vehiculo = new vehiculo();
    model.addAttribute("vehiculo", vehiculo);
    // model.addAttribute("parqueaderosList", parqueaderosList);
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
    return "salidapru";
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
    existentvehiculo.setValor_pagar(vehiculo.getValor_pagar());
    vehiculoService.updateVehiculo(existentvehiculo);
    saveHistorial(existentvehiculo);
    vehiculoService.deleteVehiculoById(id);
    return "redirect:/mostrar";
  }

  @GetMapping("/mostrar/{id}")
  public String deleteVehiculo(@PathVariable Long id) {
    vehiculo aux = vehiculoService.getVehiculoById(id);
    saveHistorial(aux);
    vehiculoService.deleteVehiculoById(id);
    return "redirect:/mostrar";
  }

  @RequestMapping("/")
  public String principal() {
    return "login";
  }

  @RequestMapping("/home")
  public String login() {
    return "home";
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

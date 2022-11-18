var attempt = 3;
function validar() {
  var usuario = "administrador";
  var pwd = "admin";
  var guarda = "guarda1";
  var pwdguarda = "guarda1";
  if (user.value == usuario && password.value == pwd) {
    alert("Ingreso Exitoso");
    window.location = "/home";
  }
  if (user.value == guarda && password.value == pwdguarda) {
    alert("Ingreso Exitoso");
    window.location = "/mostrar";
  } else {
    alert("Por favor ingresa, nombre y contraseña correctos.");
  }
}

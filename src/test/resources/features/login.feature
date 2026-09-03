# language: es
Característica: Inicio de sesión
  Como usuario de SauceDemo
  Quiero iniciar sesión
  Para acceder al catálogo de productos

  @smoke @login
  Escenario: Usuario válido accede al catálogo
    Dado que ingreso a la página de login
    Cuando inicio sesión con el usuario "standard_user" y contraseña "secret_sauce"
    Entonces debería visualizar el catálogo de productos

  @login @negative
  Escenario: Usuario bloqueado no puede acceder
    Dado que ingreso a la página de login
    Cuando inicio sesión con el usuario "locked_out_user" y contraseña "secret_sauce"
    Entonces debería visualizar un mensaje de error que contenga "locked out"

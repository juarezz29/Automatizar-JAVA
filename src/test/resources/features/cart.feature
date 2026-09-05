# language: es
Característica: Gestión del carrito
  Como usuario autenticado
  Quiero agregar productos al carrito
  Para comprarlos posteriormente

  @smoke @cart
  Escenario: Agregar una mochila al carrito
    Dado que inicié sesión como usuario estándar
    Cuando agrego la mochila al carrito
    Entonces el contador del carrito debería mostrar "1"

Feature: Compra de productos en soudemo
  Como: Cliente de la pagina
  Quiero: Agregar dos productos al carrito
  Para: Proceder a la compra

  @Compra
  Scenario Outline:Compra en pagina souce demo
    Given El Cliente ingresa a la pagina souce demo con el usuario: standard_user y clave: secret_sauce
    When Agrega productos <producto1>, <producto2> al carrito de compras
    And Reviso el carrito de compras, e ingreso los datos Fausto,Lamina,593
    Then Finalizo la compra con el mensaje
    """
    Thank you for your order!
    """
    Examples:
      |producto1          |producto2               |
      |Sauce Labs Backpack|Sauce Labs Fleece Jacket|
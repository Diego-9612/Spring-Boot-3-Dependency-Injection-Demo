package com.diego.springboot.di.app.springboot_di.models;

/**
 * La clase Product representa un objeto de dominio en la capa de modelo.
 * Tiene tres atributos: id, name, y price, que representan un producto con
 * su identificador único, nombre y precio respectivamente.
 * 
 * Esta clase es una entidad básica que será utilizada en el sistema para
 * almacenar
 * y transferir información sobre los productos.
 */
public class Product implements Cloneable {

    private Long id;
    private String name;
    private Long price;

    // Constructor por defecto
    public Product() {
    }

    // Constructor con parámetros para inicializar el objeto con valores específicos
    public Product(Long id, String name, Long price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    // Getters y setters necesarios para acceder a los atributos de la clase
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    @Override
    public Object clone() {

        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {

            return new Product(id, name, price);
        }
    }

}

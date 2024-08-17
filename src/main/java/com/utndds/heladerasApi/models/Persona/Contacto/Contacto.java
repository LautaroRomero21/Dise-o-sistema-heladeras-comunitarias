package com.utndds.heladerasApi.models.Persona.Contacto;

import com.utndds.heladerasApi.models.Persona.Persona;

import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo_contacto")
public abstract class Contacto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "persona") // Nombre de la columna que se refiere a la ONG
    private Persona persona;

    // Métodos y atributos comunes si los hay
    public abstract void notificar(String mensaje);
}
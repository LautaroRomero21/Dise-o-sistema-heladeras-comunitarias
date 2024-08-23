package com.utndds.heladerasApi.models.Suscripciones.Evento;

import java.util.List;

import com.utndds.heladerasApi.models.Heladera.Heladera;
import com.utndds.heladerasApi.models.Persona.Contacto.Contacto;

import jakarta.persistence.*;

@Entity
@DiscriminatorValue("MUCHAS_VIANDAS")
public class MuchasViandas extends Evento {

    @Column(name = "cantidad_maxima")
    private int cantidadMaxima;

    public MuchasViandas() {
    }

    public MuchasViandas(List<Contacto> mediosDeseados, int cantidadMaxima) {
        super(mediosDeseados);
        this.cantidadMaxima = cantidadMaxima;
    }

    public void verificarEvento(Heladera heladera) {
        if (heladera.cantViandas() >= this.cantidadMaxima) {
            this.notificarEvento(heladera);
        }
    };

    protected void notificarEvento(Heladera heladera) {
        List<Contacto> contactos = this.suscripcion.getColaborador().getPersona().getMediosContacto();
        for (Contacto contacto : contactos) {
            if (this.mediosDeseados.contains(contacto)) {
                contacto.notificar("Se notifico a " + this.suscripcion.getColaborador().getPersona().getNombre()
                        + " que hay muchas viandas en la heladera: " + heladera.getPunto().getDireccion());
            }
        }

    };
}

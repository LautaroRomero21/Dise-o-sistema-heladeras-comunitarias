package com.utndds.heladerasApi.models.Suscripciones;

import java.util.ArrayList;
import java.util.List;

import com.utndds.heladerasApi.models.Heladera.Heladera;
import com.utndds.heladerasApi.models.Observer.ObservadorSuscripcion;
import com.utndds.heladerasApi.models.Rol.Colaborador;
import com.utndds.heladerasApi.models.Suscripciones.Evento.Evento;

public class Suscripcion implements ObservadorSuscripcion {
    Heladera heladera;
    Colaborador colaborador;
    List<Evento> notificacionesDeseadas = new ArrayList<>();

    public Suscripcion(Heladera heladera, Colaborador colaborador) {
        this.heladera = heladera;
        this.colaborador = colaborador;

        this.procesar();
    }

    public void verificarNotificaciones(Heladera heladera) {
        // FALTA IMPLEMENTAR
    };

    private void procesar() {
        this.heladera.agregarSuscripcion(this);
        this.colaborador.agregarSuscripcion(this);
    };

    public void verificarNotificaciones() {
        for (Evento evento : notificacionesDeseadas) {
            evento.verificarEvento(this.heladera);
        }
    }

}

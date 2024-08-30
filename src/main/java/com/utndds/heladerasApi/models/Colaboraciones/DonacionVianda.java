package com.utndds.heladerasApi.models.Colaboraciones;

import com.utndds.heladerasApi.models.Heladera.Heladera;
import com.utndds.heladerasApi.models.Heladera.Vianda;
import com.utndds.heladerasApi.models.Rol.Colaborador;

import jakarta.persistence.*;

@Entity
public class DonacionVianda extends Colaboracion {

    @OneToOne
    @JoinColumn(name = "vianda")
    private Vianda viandaDonada;

    @ManyToOne
    @JoinColumn(name = "heladera")
    private Heladera heladera;

    // Constructor vacío para JPA
    public DonacionVianda() {
    }

    public DonacionVianda(Colaborador colaborador,
            Vianda viandaDonada, Heladera heladera) {
        super(colaborador);
        this.viandaDonada = viandaDonada;
        this.heladera = heladera;
    }

    @Override
    protected void procesar() {
        super.procesar();
        System.out.println(
                "SE GUARDO LA DONACION DE VIANDAS POR PARTE DE: " + this.colaborador.getPersona().getNombre());
    }
}

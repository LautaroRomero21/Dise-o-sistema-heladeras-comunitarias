package com.utndds.heladerasApi.models.Heladera.Incidentes;

import com.utndds.heladerasApi.models.Heladera.Heladera;
import com.utndds.heladerasApi.models.Rol.Tecnico;
import jakarta.persistence.*;

@Entity
@Table(name = "falla_tecnica")
public class FallaTecnica extends Incidente {

    // Constructor vacío para JPA
    public FallaTecnica() {
    }

    public FallaTecnica(Heladera heladera) {
        super(heladera);
        this.procesar();
        this.notificarTecnicoCercano();
    }

    @Override
    public void procesar() {
        super.procesar();
    };

    private void notificarTecnicoCercano() {
        Tecnico tecnico = new Tecnico(null, null, null, null);
        tecnico.notificar("Necesitamos tu servicio en la heladera " + this.heladera.getPunto().getNombre());

    }

}

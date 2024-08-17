package com.utndds.heladerasApi.controllers;

import com.utndds.heladerasApi.services.CargaCSV.CargaCSV;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cargaCSV")
public class CargaCSVController {

    @Autowired
    private CargaCSV cargaCSV;

    @PostMapping("/cargarCSV")
    public ResponseEntity<String> cargarArchivoCSV() {
        try {
            cargaCSV.cargarCSV();
            return ResponseEntity.ok("Archivo CSV cargado exitosamente.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al cargar el archivo CSV: " + e.getMessage());
        }
    }
}
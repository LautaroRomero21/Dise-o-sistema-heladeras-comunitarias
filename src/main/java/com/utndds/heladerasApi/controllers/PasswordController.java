package com.utndds.heladerasApi.controllers;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.utndds.heladerasApi.models.Validadores.ValidadorContraseña;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.CrossOrigin;


@CrossOrigin(origins = "*") 
@RestController
public class PasswordController {
   @GetMapping("/validar-contraseña")
   
   public String validarContraseña(@RequestParam String contraseña) {
       
    boolean esDebil = ValidadorContraseña.esDebil(contraseña);
    if (esDebil) {
        return "La contraseña es débil. Por favor, elija una contraseña más segura.";
    } else {
        return "La contraseña es segura.";
    }
   }
}